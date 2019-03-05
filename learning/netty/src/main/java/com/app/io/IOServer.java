package com.app.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(IOServer.class);

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        // (1) 接收新连接线程
        new Thread(() -> {
            while (true) {
                try {
                    // (1) 阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();
                    // (2) 每一个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            // (3) 按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                            LOGGER.error("IOClient.error, e:{}", e);
                        }
                    }).start();

                } catch (IOException e) {
                    LOGGER.error("IOClient.error, e:{}", e);
                }
            }
        }).start();
    }

//    public static void main(String[] args) {
//        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 200,
//                0L, TimeUnit.MINUTES,
//                new LinkedBlockingDeque<>(1024),
//                nameThreadFactory, new ThreadPoolExecutor.AbortPolicy()
//        );
//        threadPool.execute(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(10000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
//        threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
//        threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
//        threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
//        threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
//        threadPool.shutdown();
//    }

}