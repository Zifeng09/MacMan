/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman;

/**
 *
 * @author mpk5206
 */
public class GameThread extends Thread {
    private int tickRate = 3; //updates per sec
    private GameController parentController;
    
    public GameThread(GameController gameController) {
        this.parentController = gameController;
    }
    
    @Override
    public void run() {
        while(true) {
            long startTime = System.currentTimeMillis();
            parentController.update();
            long currentTime = System.currentTimeMillis();
            while(currentTime - startTime < 1000 / tickRate) {
                currentTime = System.currentTimeMillis();      
            }
            System.out.println("Update");
        }
    }
}
