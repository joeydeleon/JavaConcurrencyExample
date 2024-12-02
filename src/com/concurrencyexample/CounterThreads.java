package com.concurrencyexample;

public class CounterThreads {
    public static void main(String[] args) {
        // Create the first thread to count up
        Thread countUpThread = new Thread(() -> {
            for (int i = 0; i <= 20; i++) {
                System.out.println("Count Up: " + i);
                try {
                    Thread.sleep(500); // Pause for 500ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create the second thread to count down
        Thread countDownThread = new Thread(() -> {
            for (int i = 20; i >= 0; i--) {
                System.out.println("Count Down: " + i);
                try {
                    Thread.sleep(500); // Pause for 500ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start the first thread and wait for it to finish
        countUpThread.start();
        try {
            countUpThread.join(); // Wait for countUpThread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Start the second thread
        countDownThread.start();
        try {
            countDownThread.join(); // Wait for countDownThread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have completed.");
    }
}
