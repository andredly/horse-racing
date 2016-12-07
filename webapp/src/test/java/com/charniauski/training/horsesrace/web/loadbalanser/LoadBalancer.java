package com.charniauski.training.horsesrace.web.loadbalanser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class LoadBalancer {

    private static ExecutorService dataTransferPool = Executors.newCachedThreadPool();
    private static ExecutorService severPool = Executors.newCachedThreadPool();
    private static boolean flag = true;

    public static void main(String args[]) throws IOException {

        int localPort = 8081;
        List<RemoteServer> remoteServers = new ArrayList<>();
        remoteServers.add(new RemoteServer("localhost", 8080));
        remoteServers.add(new RemoteServer("localhost", 8082));
//        remoteServers.add(new RemoteServer("localhost", 8083));
        int numberServer = 0;

        try (ServerSocket serverSocket = new ServerSocket(localPort)) {
            System.out.println("STARTED LOAD BALANSE SERVER ON " + "localhost" + " PORT " + localPort);
            for (RemoteServer remoteServer : remoteServers) {
                System.out.println("--> FOR SERVER " + remoteServer.getHost() + " PORT " + remoteServer.getPort());
            }

            while (flag) {
                Socket in = serverSocket.accept();
                severPool.submit(new Task(remoteServers.get(numberServer).getHost(), remoteServers.get(numberServer).getPort(), in));
                if (numberServer < remoteServers.size() - 1) {
                    numberServer++;
                } else {
                    numberServer = 0;
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
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
        private String remoteHost;
        private int remotePort;
        private Socket out;
        private Socket in;

        Task(String remoteHost, int remotePort, Socket inMsg) {
            this.remoteHost = remoteHost;
            this.remotePort = remotePort;
            this.in = inMsg;
        }

        @Override
        public Void call() {
            try {
                out = new Socket(remoteHost, remotePort);
            } catch (IOException e) {
                e.printStackTrace();
            }
            dataTransferPool.submit(new DataTransfer(in, out));
            dataTransferPool.submit(new DataTransfer(out, in));
            return null;
        }
    }
}