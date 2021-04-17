/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * This demo illustrate how to use java.Concurrent.Exchanger class
 *
 * @author tangz
 */
public class ProductExchanger {

    public static Exchanger<List<Integer>> exchanger = new Exchanger<List<Integer>>();
    
    public static void main(String[] args){
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start(); // Be careful, here the thread is not daemon thread
        consumer.start();
        try{
            while(System.in.read() != '\n');
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        producer.interrupt();
        consumer.interrupt();
    }

}

class Producer implements Runnable {
    private static List<Integer> buffer = new ArrayList<>();
    private boolean okToRun = true;
    private final int BUFFSIZE = 10;
    
    @Override
    public void run() {
        int j = 0;
        while (okToRun){
            if (buffer.isEmpty()){ 
                try{
                    for (int i=0; i<BUFFSIZE; i++){
                        buffer.add((int)(Math.random() * 100));
                    }
                    Thread.sleep((int)(Math.random()) * 1000);
                    System.out.println("Producer Buffer: ");
                    for (int i : buffer){
                        ;//System.out.print(i + ", ");
                    }
                    System.out.println();
                    System.out.println("Exchanging ... ");
                    buffer = ProductExchanger.exchanger.exchange(buffer);
                }catch(InterruptedException ie){
                    okToRun = false;
                }
            }
        }
    }
}

class Consumer implements Runnable {

    private static List<Integer> buffer = new ArrayList<Integer>();
    private boolean okToRun = true;
    
    @Override
    public void run() {
        while(okToRun){
            try{
                if (buffer.isEmpty()){
                    buffer = ProductExchanger.exchanger.exchange(buffer);
                    System.out.println("Consumer Buffer: ");
                    for (int i : buffer){
                        System.out.print(i + ", ");
                    }
                    System.out.println("\n");
                    Thread.sleep((int)(Math.random()*1000));
                    buffer.clear(); //Very important here to clean up all buffer items once consumer processed all data
                }
            }catch(InterruptedException ie){
                okToRun = false;
            }
        }
    }
    
}