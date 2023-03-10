package org.collin.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureThenApplyTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> firstFuture=CompletableFuture.supplyAsync(()-> "first future");

        CompletableFuture<String> secondFuture=firstFuture.thenApply((result)->{
            System.out.println("Already finish first future");
            return result+"and second future got executed";
        });

        System.out.println(secondFuture.get());
    }
}
