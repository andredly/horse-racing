package com.charniauski.training.horsesrace.web.loadbalanser;

/**
 * Created by ivc4 on 07.12.2016.
 */
public class RemoteServer {
    private final String host;
    private final int port;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemoteServer that = (RemoteServer) o;

        if (port != that.port) return false;
        return host != null ? host.equals(that.host) : that.host == null;

    }

    @Override
    public int hashCode() {
        int result = host != null ? host.hashCode() : 0;
        result = 31 * result + port;
        return result;
    }
}
