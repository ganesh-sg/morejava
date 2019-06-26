package com.ganesh.learn.more.java;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UseReadWriteLock {

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    Map<String, Object> data = new HashMap<>();

    public void saveData(String key, Object value) {
        Lock lock = readWriteLock.writeLock();
        try {
            boolean lockAvailable = lock.tryLock(10, TimeUnit.SECONDS);
            if (lockAvailable) {
                data.put(key, value);
                System.out.println("Wrote into " + key + ", " + value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object getData(String key) throws InterruptedException {
        Lock lock = readWriteLock.readLock();
        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                return data.get(key);
            }
            throw new RuntimeException("Lock not available");
        } catch (InterruptedException e) {
            throw e;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        UseReadWriteLock useReadWriteLock = new UseReadWriteLock();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> useReadWriteLock.saveData("1", "One"));
        executorService.submit(() -> useReadWriteLock.saveData("2", "two"));
        executorService.submit(() -> useReadWriteLock.saveData("3", "three"));
        executorService.submit(() -> useReadWriteLock.saveData("4", "four"));
        executorService.submit(() -> {
            try {
                System.out.println(useReadWriteLock.getData("2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                System.out.println(useReadWriteLock.getData("3"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                System.out.println(useReadWriteLock.getData("3"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
