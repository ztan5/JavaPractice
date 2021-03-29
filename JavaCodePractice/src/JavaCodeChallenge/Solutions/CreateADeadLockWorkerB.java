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
public class CreateADeadLockWorkerB implements Runnable {
    private CreateADeadLock task;
    
    public CreateADeadLockWorkerB(CreateADeadLock task) {
        this.task = task;
    }
    @Override
    public void run() {
        task.processThat();
    }
    
}
