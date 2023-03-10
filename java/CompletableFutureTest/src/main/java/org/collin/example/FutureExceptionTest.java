package org.collin.example;

import java.util.concurrent.CompletableFuture;

public class FutureExceptionTest {
    public static void main(String[] args) {

        CompletableFuture<String> firstFuture=CompletableFuture.supplyAsync(()-> {
            System.out.println("first future");
            throw new RuntimeException("first future exception");
        });

        CompletableFuture<String> secondFuture=firstFuture.exceptionally((e)->{
           e.printStackTrace();
           return "first future exception";
        });

        System.out.println(secondFuture.join());
    }

}
