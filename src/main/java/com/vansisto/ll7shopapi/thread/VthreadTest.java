package com.vansisto.ll7shopapi.thread;

import java.util.ArrayList;
import java.util.List;

public class VthreadTest {
    public static void main(String[] args) throws InterruptedException {
//        Runnable runnable = () -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("Index: %s".formatted(i));
//            }
//        };
//
//        Thread vThread1 = Thread.ofVirtual().start(runnable);
//        vThread1.join();

        int vThreadsCount = 100_000;

        for (int i = 0; i < vThreadsCount; i++) {
            int vThreadIndex = i;
            Thread.ofVirtual().start(() -> {
                System.out.println("Thread " + vThreadIndex);
            });
        }
    }
}
