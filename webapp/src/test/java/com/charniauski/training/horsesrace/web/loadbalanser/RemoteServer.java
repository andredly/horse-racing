package com.charniauski.training.horsesrace.web.loadbalanser;

/**
 * Created by ivc4 on 07.12.2016.
 */
public class RemoteServer {
    private String host;
    private int port;

    public RemoteServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }


    @Override
    public String toString() {
        return "RemoteServer{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }

}
