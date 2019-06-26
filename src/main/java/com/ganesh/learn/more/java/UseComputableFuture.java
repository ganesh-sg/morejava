package com.ganesh.learn.more.java;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UseComputableFuture {

    static Future<String> someComputableFuture() {
        CompletableFuture<String> cf = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(500);
                cf.complete("Hi");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return cf;
    }

    static Future<String> withAsync() {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()-> "Hello");
        return cf;
    }

    static Future<String> withApply() {
        return CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenApplyAsync(s -> s + " World");
    }

    static Future<String> withCompose() {
        return CompletableFuture
                .supplyAsync(() -> "First")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " Second"))
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " Third"));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> stringFuture = someComputableFuture();
        System.out.println(stringFuture.get());

        System.out.println(withApply().get());
        System.out.println(withCompose().get());
    }
}
