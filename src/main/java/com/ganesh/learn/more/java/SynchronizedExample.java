package com.ganesh.learn.more.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedExample implements Runnable {

    private Resource resource;

    private Lock someLock;

    public SynchronizedExample(Resource resource, Lock someLock) {
        this.resource = resource;
        this.someLock = someLock;
    }

    @Override
    public void run() {
        try {
            if (someLock.tryLock(10, TimeUnit.SECONDS)) {
                resource.doSomething();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            someLock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedExample synchronizedExample = new SynchronizedExample(new Resource(), new ReentrantLock());
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(synchronizedExample);
        executor.execute(synchronizedExample);
        executor.execute(synchronizedExample);
        executor.execute(synchronizedExample);
        executor.shutdown();
    }

}
