package com.learning.concurrent.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPoolTest {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAXIMUM_POOL_SIZE = 200;
    private static final long KEEP_ALIVE_TIME = 0L;

    private static final int SCHEDULE_CORE_POOL_SIZE = 1;

    @Test
    public void testThreadPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());
        pool.execute(getRunnable());

        pool.shutdown();
    }

    @Test
    public void testScheduleThreadPool() {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(SCHEDULE_CORE_POOL_SIZE,
                new BasicThreadFactory.Builder()
                        .namingPattern("thread-schedule-pool-%d")
                        .daemon(true)
                        .build());

        executorService.schedule(getRunnable(), 1L, TimeUnit.SECONDS);
        executorService.schedule(getRunnable(), 1L, TimeUnit.SECONDS);
        executorService.schedule(getRunnable(), 1L, TimeUnit.SECONDS);
        executorService.schedule(getRunnable(), 1L, TimeUnit.SECONDS);

        executorService.shutdown();
    }

    private Runnable getRunnable() {
        return () -> System.out.println(Thread.currentThread().getName());
    }

}
