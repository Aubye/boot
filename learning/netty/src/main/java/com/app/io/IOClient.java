package com.app.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class IOClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(IOClient.class);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        LOGGER.error("IOClient.error, e:{}", e);
                    }
                }
            } catch (IOException e) {
                LOGGER.error("IOClient.error, e:{}", e);
            }
        }).start();
    }
}