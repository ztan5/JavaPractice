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
public class PrimeNumberGenerateThread implements Runnable{

    @Override
    public void run() {
        long i = 1;
        while (true) {
            long j;
            for (j = 2; j<i; j++){
                long n = i % j;
                if (n == 0){
                    break;
                }
            }
            
            if (i == j){
                System.out.println("  " + i);
            }
            i++;
        }
    }
    
}
