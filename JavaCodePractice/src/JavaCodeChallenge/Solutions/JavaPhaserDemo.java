/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demo to illustrate how to use java.concurrent.Phaser class
 *
 * @author tangz
 */
public class JavaPhaserDemo {

    private final int NUMBER_OF_HORSES = 12;
    private final static int INIT_PARTIES = 1;
    private final static Phaser manager = new Phaser(INIT_PARTIES);

    public static void main(String[] args) {
        Thread raceMonitor = new Thread(new RaceMonitor());
        raceMonitor.setDaemon(true);
        raceMonitor.start();
        JavaPhaserDemo demo = new JavaPhaserDemo();
        demo.manageRace(); //First run
        try{
            System.out.println("Let us take 6 seconds rest here........");
            Thread.sleep(6000);
        }catch(InterruptedException de){
            
        }
        System.out.println("After rest 6 seconds, let's start another race...");
        demo.manageRace(); //Second run
    }

    public void manageRace() {
        ArrayList<Horse> horseArray = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_HORSES; i++) {
            horseArray.add(new Horse());
        }
        runRace(horseArray);
    }

    private void runRace(Iterable<Horse> team) {
        log("Assign all horses, then start race");
        for (final Horse horse : team) {
            final String dev = horse.toString();
            log("assign " + dev + " to the race");
            JavaPhaserDemo.manager.register();
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((new Random()).nextInt(1000));
                    } catch (InterruptedException ie) {
                    }
                    log(dev + ", please wait all horses");
                    JavaPhaserDemo.manager.arriveAndAwaitAdvance();
                    horse.run();
                }
            }.start();
        }
        try {
            Thread.sleep(6000);
        } catch (InterruptedException ixe) {
        }
        log("All arrived at starting gate, start race");
        JavaPhaserDemo.manager.arriveAndDeregister();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException ixe) {
        }
    }

    private static void log(String msg) {
        System.out.println(msg);
    }

    private static class Horse implements Runnable {

        private final static AtomicInteger idSource = new AtomicInteger();
        private final int id = idSource.incrementAndGet();

        @Override
        public void run() {
            log(this.toString() + ": running");
        }

        @Override
        public String toString() {
            return "Horse #" + id;
        }
    }

    private static class RaceMonitor implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("Number of horses ready to run: " + JavaPhaserDemo.manager.getArrivedParties());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}
