package com.manoj.practice.design.patterns.creational;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author mmenon
 *
 */
public class SingletonPattern {

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        Thread th1 = new Thread(t1, "First");
        Thread th2 = new Thread(t2, "second");

        th1.start();
        th2.start();

        th1.join();
        th2.join();
        MySingleton sample = MySingleton.createInstance();
        System.out.println("In main thread, hashcode of singleton object:- " + sample.hashCode());

        try (FileOutputStream fos = new FileOutputStream(new File("src/main/resources/Singleton.ser"));
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            oos.writeObject(sample);
            System.out.println("Successfully wrote the object....");

        } catch (IOException e) {
            System.err.println("Caught exception: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(new File("src/main/resources/Singleton.ser"));
                ObjectInputStream ois = new ObjectInputStream(fis);) {

            MySingleton readObjt = (MySingleton) ois.readObject();
            System.out.println("Object read from file with hashcode: " + readObjt.hashCode());

        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Caught exception: " + e.getMessage());
        }
    }

}

class MyThread implements Runnable {

    public void run() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MySingleton obj = MySingleton.createInstance();
        System.out.println("Thread:-" + Thread.currentThread() + "&& Singleton hashcode:-" + obj.hashCode());
    }

}

/**
 * Singleton implementations
 * 
 * @author mmenon
 *
 */
class MySingleton implements Serializable {

    private String id;
    private String name;
    private static final long serialVersionUID = 1L;
    private static MySingleton obj;

    private MySingleton() {
        this.id = "1234";
        this.name = "Manoj";
    }

    public static MySingleton createInstance() {

        if (obj == null) {
            synchronized (MySingleton.class) {
                if (obj == null) {
                    System.out.println("Created by :-" + Thread.currentThread() + " and time:-" + System.currentTimeMillis());
                    obj = new MySingleton();
                }
            }
        }

        return obj;
    }

    @Override
    public MySingleton clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    // Method to ensure that the object read from the files is the same as the
    // object written to it.
    protected Object readResolve() {
        return createInstance();

    }

}
