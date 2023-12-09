package com.example.classes;

public class Runner implements Runnable{
    public void run(){
        for (int i = 10; i < 0; i--){
            System.out.println("Thread #1: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

package com.example;

import com.example.classes.Runner;

public class Main {

    private int count = 0;

    public static void main(String[] args) {

        Main main = new Main();
        main.exec();

//        Thread thread1 = new Thread(new Runner());
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 10; i > 0; i--){
//                    System.out.println("Thread #2: " + i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                }
//            }
//        });
//        thread1.start();
//        thread2.start();
    }

    public synchronized void increment(){
        count++;
    }

    public void exec(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    count++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++){
                    count++;
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Count: " + count);
    }
}
