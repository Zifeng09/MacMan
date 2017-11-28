/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.game.controller;

import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author mpk5206
 */
public class GameThread{
    private static final int timerThing = 25;
    private Timer graphicsTimer;
    private GameController parentController;
    
    public GameThread(GameController gameController, int difficulty) {
        this.parentController = gameController;
        graphicsTimer = new Timer(timerThing, (ActionEvent ae) -> { 
            parentController.updateGame();
        });
        graphicsTimer.start();
    }
    
    public void setDifficulty(int difficulty) {
        graphicsTimer.setDelay(timerThing / difficulty);
    }
	
	public void dispose() {
		graphicsTimer.stop();
		graphicsTimer = null;
		parentController = null;
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
