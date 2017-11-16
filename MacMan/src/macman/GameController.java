/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author N9864
 */
public class GameController {
    private GameView theGameView = null;
    private GameThread theGameThread;
    MenuController theMenuCntl;
    
    
  public GameController(){
      
        theGameView = new GameView(this);
        theGameView.setVisible(true);
        theGameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGameView.setLocationRelativeTo(null);
        theGameThread = new GameThread(this);
        theGameThread.start();
//        theGameThread.run();
       
      
  }
  
  public void update() {
      theGameView.updateEnemies();
  }
  public void backmenu(){
    theMenuCntl = new MenuController();
  
  }
}
