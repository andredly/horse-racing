package com.charniauski.training.horsesrace.web.loadbalanser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class LoadBalancer {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadBalancer.class);

    private static final ExecutorService dataTransferPool = Executors.newCachedThreadPool();
    private static final ExecutorService severPool = Executors.newCachedThreadPool();
    private static boolean flag = true;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String args[]) throws IOException {

        int localPort = 8081;
        final List<RemoteServer> remoteServers = new ArrayList<>();
        remoteServers.add(new RemoteServer("localhost", 8080));
        remoteServers.add(new RemoteServer("localhost", 8082));
//        remoteServers.add(new RemoteServer("localhost", 8083));
        int numberServer = 0;

        try (ServerSocket serverSocket = new ServerSocket(localPort)) {
            LOGGER.info("STARTED LOAD BALANSE SERVER ON localhost PORT {}", localPort);
            Iterator<RemoteServer> iterator = remoteServers.iterator();
            while (iterator.hasNext()) {
                RemoteServer next = iterator.next();
                try {
                    URL url = new URL("http://" + next.getHost() + ":" + next.getPort());
                    url.openConnection().connect();
                    LOGGER.info("-->CONNECT FOR SERVER={} PORT={}", next.getHost(), next.getPort());
                } catch (Exception e) {
                    LOGGER.info("NO CONNECT FOR SERVER={} PORT={} ", next.getHost(), next.getPort());
                    iterator.remove();
                }
            }
            if (remoteServers.isEmpty()) {
                LOGGER.info("NO CONNECT FOR ALL SERVERS! SERVER STOP.");
                System.exit(0);
            }else {
                LOGGER.info("SERVER working.....");
            }

            while (flag) {
                Socket in = serverSocket.accept();
                Future future = severPool.submit(new Task(remoteServers.get(numberServer).getHost(), remoteServers.get(numberServer).getPort(), in));
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    numberServer = getNumberServer(remoteServers, numberServer);
                    severPool.submit(new Task(remoteServers.get(numberServer).getHost(), remoteServers.get(numberServer).getPort(), in));
                    numberServer++;
                }
                numberServer = getNumberServer(remoteServers, numberServer);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private static int getNumberServer(List<RemoteServer> remoteServers, int numberServer) {
        if (numberServer < remoteServers.size() - 1) {
            numberServer++;
        } else {
            numberServer = 0;
        }
        return numberServer;
    }


    public void serverStop() {
        flag = false;
        closePool(severPool);
        closePool(dataTransferPool);
    }

    private void closePool(ExecutorService pool) {
        if (pool != null) {
            pool.shutdown();
            try {
                pool.awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!pool.isTerminated()) {
                pool.shutdownNow();
            }
        }
    }


    private static class Task implements Callable {
        private final String remoteHost;
        private final int remotePort;
        private Socket out;
        private Socket in;

        Task(String remoteHost, int remotePort, Socket inMsg) {
            this.remoteHost = remoteHost;
            this.remotePort = remotePort;
            this.in = inMsg;
        }

        @Override
        public Void call() throws IOException {

            try {
                out = new Socket(remoteHost, remotePort);
            } catch (IOException e) {
                in = null;
                throw new IOException();
            }

            dataTransferPool.submit(new DataTransfer(in, out));
            dataTransferPool.submit(new DataTransfer(out, in));
            return null;
        }
    }

}