/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This demo is to illustrate how to use scheduled executor service
 * to make a runnable object or callable object runs in periodic manner
 * @author tangz
 */
public class VirusScanner {
    
    private static JFrame appFrame;
    private static JLabel statusString;
    private int scanNumber = 0;
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
    private GregorianCalendar calendar = new GregorianCalendar();
    private static VirusScanner app = new VirusScanner();
    
    public void scanDisk() {
        final Runnable scanner = new Runnable(){
            @Override
            public void run() {
                try{
                    appFrame.setVisible(true);
                    scanNumber++;
                    Calendar cal = Calendar.getInstance();
                    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM);
                    statusString.setText(" Scan " + scanNumber + " started at " + df.format(cal.getTime()));
                    Thread.sleep(1000 + new Random().nextInt(10000));
                    appFrame.setVisible(false);
                }catch(InterruptedException i){
                    i.printStackTrace();
                }
            }
        };
        
        final ScheduledFuture<?> scanManager = scheduler.scheduleAtFixedRate(scanner, 1, 15, TimeUnit.SECONDS);
        scheduler.schedule(new Runnable(){
            @Override
            public void run() {
                scanManager.cancel(true);
                scheduler.shutdown();
                appFrame.dispose();
            }
        
        }, 60, TimeUnit.SECONDS);
    }
    
    public static void main (String[] args){
        appFrame = new JFrame();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        appFrame.setSize(400, 70);
        appFrame.setLocation(dimension.width/2 - appFrame.getWidth()/2, dimension.height/2 - appFrame.getWidth()/2);
        statusString = new JLabel();
        appFrame.add(statusString);
        appFrame.setVisible(false);
        app.scanDisk();
    }
}
