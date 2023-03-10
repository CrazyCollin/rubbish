package org.collin.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(10);
        CompletableFuture<Void> runFuture= CompletableFuture.runAsync(() -> {
            System.out.println("runAsync");
        });
        CompletableFuture<String> supplyFuture=CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync");
            return "supplyAsync";
        });

        runFuture.join();
        System.out.println(supplyFuture.join());

        executor.shutdown();
    }
}
