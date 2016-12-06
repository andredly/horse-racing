package com.charniauski.training.horsesrace.services.tests.one;

import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;

public class StartServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
//        HttpContext context = server.createContext("/test");
        HttpContext context = server.createContext("/*", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                Headers responseHeaders = httpExchange.getResponseHeaders();
                Headers requestHeaders = httpExchange.getRequestHeaders();
                Collection<List<String>> values = requestHeaders.values();

                httpExchange.sendResponseHeaders(200, "Hello".getBytes().length);
                OutputStream responseBody = httpExchange.getResponseBody();
                responseBody.write("Hello".getBytes());
            }
        }); server.setExecutor(null);
        server.start();

    }

}
