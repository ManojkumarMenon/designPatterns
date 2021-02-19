package com.manoj.practice.design.patterns.creational;

public class BilPughSingletonImplementation {

    public static void main(String[] args) {
        BillPughRunnable r1 = new BillPughRunnable();
        BillPughRunnable r2 = new BillPughRunnable();

        Thread t1 = new Thread(r1, "first");
        Thread t2 = new Thread(r2, "second");

        t1.start();
        t2.start();
    }

}

class BillPughRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread =" + Thread.currentThread() + " -->" + BillPughSingleton.getInstance().hashCode());
    }

}

class BillPughSingleton {

    private BillPughSingleton() {
        System.out.println("Created by :" + Thread.currentThread());
    }

    private static class BillPughSingletonInnerClass {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return BillPughSingletonInnerClass.INSTANCE;
    }
}