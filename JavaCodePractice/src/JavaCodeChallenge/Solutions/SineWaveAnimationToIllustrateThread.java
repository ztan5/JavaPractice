/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;

/**
 * Sine Wave Animation to illustrate how Java Thread works
 * @author tangz
 */
public class SineWaveAnimationToIllustrateThread extends JFrame implements Runnable{

    private int frame = 0;
    
    public SineWaveAnimationToIllustrateThread() {
        setTitle("Sine Wave Animation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setVisible(true);
    }
    
    @Override
    public void run() {
        while (true) {
            repaint();
            try{
                Thread.sleep(100);
            } catch(InterruptedException ie){
                System.out.println(ie.getStackTrace());
            }
            frame++;
        }
    }
    
    @Override
    public void paint(Graphics g){
        Rectangle d = getBounds();
        g.clearRect(0, 0, d.width, d.height);
        int h = d.height/2;
        for (int x=0; x < d.width; x++){
            int y1 = (int) ((1.0 + Math.sin((x-frame) * 0.09)) * h);
            int y2 = (int) ((1.0 + Math.sin((x + frame) * 0.01)) * h);
            g.drawLine(x, y1, x, y2);
        }
    }
    
    public static void main(String[] args){
        SineWaveAnimationToIllustrateThread app = new SineWaveAnimationToIllustrateThread();
        Thread animation = new Thread(app);
        animation.setDaemon(true);
        animation.start();
    }
    
}
