package org.collin.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureThenAcceptTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> firstFuture=CompletableFuture.supplyAsync(()-> {
            System.out.println("execute first future");
            return "first future";
        });

        CompletableFuture<Void> secondFuture=firstFuture.thenAccept((result)->{
            System.out.println("Start execute second future");
            System.out.printf("Already finish %s ",result);
        });

        secondFuture.get();
    }
}
