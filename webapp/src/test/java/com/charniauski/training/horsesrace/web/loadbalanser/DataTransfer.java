package com.charniauski.training.horsesrace.web.loadbalanser;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class DataTransfer implements Runnable {
    private Socket incoming;
    private Socket outgoing;

    DataTransfer(Socket in, Socket out) {
        incoming = in;
        outgoing = out;
    }

    public void run() {
        byte[] buffer = new byte[60];
        int numberRead;
        OutputStream toClient;
        InputStream fromClient;

        try {
            toClient = outgoing.getOutputStream();
            fromClient = incoming.getInputStream();
            while (true) {
                numberRead = fromClient.read(buffer, 0, 50);
                if (numberRead == -1) {
                    incoming.close();
                    outgoing.close();
                }
                toClient.write(buffer, 0, numberRead);
            }

        } catch (IOException | ArrayIndexOutOfBoundsException e) {
        }

    }

}