/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author N9864
 */
public class GameView extends JFrame{
         JPanel gridPanel, playerPanel;
    
          GameController theGameController;
          GameView theGameView;
    
    public GameView(GameController theParentGameController){
        
        theGameController = theParentGameController;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
	this.setTitle("MACMAN BETA");
        this.setSize(new Dimension(300,500));
        this.setLayout(null);
      //  initCustomComponents();
        
       
    }

  /*  private void initCustomComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
  
    
    
    
    
    
    
}
