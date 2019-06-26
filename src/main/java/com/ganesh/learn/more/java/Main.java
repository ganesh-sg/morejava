package com.ganesh.learn.more.java;

import java.util.concurrent.Semaphore;

//from   jav  a  2  s  .  co m
public class Main {
    public static void main(String args[]) {
        Semaphore sem = new Semaphore(5, true);
        new Consumer(sem, "B");
        new Producer(sem, "A");
    }
}

class Shared {
    static int count = 0;
}

class Producer implements Runnable {
    String name;
    Semaphore sem;

    Producer(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        while (true) {
            Shared.count++;
            System.out.println(name + ": " + Shared.count);
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    String name;
    Semaphore sem;

    Consumer(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        while (true) {
            sem.release();
            Shared.count--;
            System.out.println(name + ": " + Shared.count);
        }
    }
}
