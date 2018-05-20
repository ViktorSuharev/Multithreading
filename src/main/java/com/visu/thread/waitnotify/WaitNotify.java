package com.visu.thread.waitnotify;

public class WaitNotify {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized(b) {
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finish");
        }
    }
}

class ThreadB extends Thread {
    @Override
    public void run() {
        synchronized(this) {
            for (int i = 1; i <= 10; i++) {
                System.out.println("step " + i);
            }
            notify();
        }
    }
}