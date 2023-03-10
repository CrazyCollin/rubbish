package org.collin.example;

import java.util.concurrent.CompletableFuture;

public class FutureThenRunTest {
    public static void main(String[] args) {

        // 简单来说就是做完第一个任务，再做第二个任务，任务执行完成后，再执行回调方法
        // 但是前后两个任务之间没有参数传递，也就是说第二个任务不依赖第一个任务的结果

        CompletableFuture<String> firstFuture=CompletableFuture.supplyAsync(()-> "first future");

        CompletableFuture<Void> secondFuture=firstFuture.thenRun(()->{
            System.out.println("Already finish first future");
        });

        secondFuture.join();

        // thenRunAsync()方法是thenRun()方法的异步版本，也就是说thenRunAsync()方法会在另外一个线程中执行任务
        // thenRunAsync()方法的第二个参数是一个Executor，可以指定任务执行的线程池


    }
}
