package org.collin.example;

import java.util.concurrent.CompletableFuture;

public class FutureWhenCompleteTest {
    public static void main(String[] args) {

        CompletableFuture<String> firstFuture=CompletableFuture.supplyAsync(()-> {
            System.out.println("first future");
            throw new RuntimeException("first future exception");
        });


    }
}
