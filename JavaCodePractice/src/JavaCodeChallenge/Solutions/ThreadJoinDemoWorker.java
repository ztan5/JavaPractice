/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

/**
 *
 * @author tangz
 */
public class ThreadJoinDemoWorker implements Runnable {

    public int counter = 10;

    public ThreadJoinDemoWorker(){
        counter = 10;
    }
    
    @Override
    public void run() {
        while (counter > 0) {
            try {
                Thread.sleep(1000);
                counter --;
            } catch (InterruptedException it) {
                ;
            }

        }
    }

}
