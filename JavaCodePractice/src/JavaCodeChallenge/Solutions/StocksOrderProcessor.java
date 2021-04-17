/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * This demo is to illustrate how to use callable and future class also
 * executors
 *
 * @author tangz
 */
public class StocksOrderProcessor {

    static final int MAX_NUMBER_OF_ORDERS = 10000;
    static private ExecutorService executor = Executors.newFixedThreadPool(100);
    static private List<Future> ordersToProcess = new ArrayList();
    
    private static class OrderExecutor implements Callable {

        int id = 0;
        int count = 0;

        public OrderExecutor(int id) {
            this.id = id;
        }

        @Override
        public Object call() throws Exception {
            try {
                while (count < 50) {
                    count++;
                    Thread.sleep(new Random(System.currentTimeMillis() % 100).nextInt(10));
                }
                System.out.println("Successfully executed ordre: " + id);
            } catch (Exception e) {
                throw (e);
            }
            return id;
        }
    }
    
    private static void SubmitOrder(int id){
        Callable<Integer> callable = new OrderExecutor(id);
        ordersToProcess.add(executor.submit(callable));
    }
    
    public static void main(String[] args) {
        System.out.printf("Submitting %d trades %n", MAX_NUMBER_OF_ORDERS);
        for (int i=0; i<MAX_NUMBER_OF_ORDERS; i++){
            SubmitOrder(i);
        }
        new Thread(new EvilThread(ordersToProcess)).start();
        System.out.println("Cancelling a few orders at random");
        try{
            executor.awaitTermination(30, TimeUnit.SECONDS);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
        System.out.println("Checking status before shutdown");
        int count = 0;
        for (Future f : ordersToProcess){
            if (f.isCancelled()){
                count++;
            }
        }
        System.out.printf("%d trades cancleed %n", count);
        executor.shutdownNow();
        
    }
}

    class EvilThread implements Runnable {
        private List<Future> ordersToProcess;
        public EvilThread(List<Future> futures){
            ordersToProcess = futures;
        }
        @Override
        public void run() {
            Random myNextKill = new Random(System.currentTimeMillis() % 100);
            for (int i=0; i<100; i++){
                int index = myNextKill.nextInt(StocksOrderProcessor.MAX_NUMBER_OF_ORDERS);
                boolean cancel = ordersToProcess.get(index).cancel(true);
                if (cancel){
                    System.out.println("Cancel order Succeeded: " + index);
                } else {
                    System.out.println("Cancel order failed: " + index + " this order might have been executed.");
                }
                try{
                    Thread.sleep(myNextKill.nextInt(100));
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }
    }
