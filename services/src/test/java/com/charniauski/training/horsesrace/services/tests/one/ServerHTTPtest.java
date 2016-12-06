package com.charniauski.training.horsesrace.services.tests.one;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerHTTPtest {
    static Socket socket;
    private String url = "";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(request());
                        System.out.println("дошло");
                        response();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private static String request() throws IOException {
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        String tmp = "";
        while ((line = bufferedReader.readLine()) != null&&line.trim().length() != 0) {
//            System.out.println(line);
            tmp = tmp + line+"\n\r";
        }
//        System.out.println("--------");
        String s="";
//        while(true) {
//            s = bufferedReader.readLine();
////            System.out.println(s);
//            tmp = tmp + s+"\n\r";
//            if(s == null || s.trim().length() == 0) {
//                break;
//            }
//        }
        return tmp;
    }

    private static void response() throws IOException {
        OutputStream outputStream = socket.getOutputStream();
//        System.out.println("в ответе");
        outputStream.write(("HTTP/1.1 200 OK\r\n" +
//                "Server: YarServer/2009-09-09\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + 4 + "\r\n" +
                "Connection: close\r\n\r\n" +
                "response").getBytes());
//        System.out.println("в ответе конец");
        outputStream.flush();
    }
}
