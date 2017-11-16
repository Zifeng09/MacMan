/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman;

import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author mpk5206
 */
public class GameThread{
    private static final int timerThing = 1000;
    private Timer timer;
    private GameController parentController;
    
    public GameThread(GameController gameController, int difficulty) {
        this.parentController = gameController;
        timer = new Timer(timerThing / difficulty, (ActionEvent ae) -> { 
            parentController.update();
        });
        timer.start();
    }
    
    public void setDifficulty(int difficulty) {
        timer.setDelay(timerThing / difficulty);
    }
    
//    @Override
//    public void run() {
//        while(true) {
//            long startTime = System.currentTimeMillis();
//            parentController.update();
//            long currentTime = System.currentTimeMillis();
//            while(currentTime - startTime < 1000 / tickRate) {
//                currentTime = System.currentTimeMillis();      
//            }
//            System.out.println("Update");
//        }
//    }
}
