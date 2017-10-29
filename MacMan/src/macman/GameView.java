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
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.Border;
/**
 *
 * @author N9864
 */
public class GameView extends JFrame{
         JPanel gridPanel, playerPanel;
          GameController theGameController;
          GameView theGameView;
          JPanel[][] theNumberPanelArray = new JPanel[12][20];
          Border blackline;
          
    
    public GameView(GameController theParentGameController){
        
        theGameController = theParentGameController;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
	this.setTitle("MACMAN BETA");
        this.setSize(new Dimension(375,639));
        this.setLayout(null);
        initCustomComponents();        

       
    }
     
    private void initCustomComponents() {
      
       gridPanel = new JPanel();
       gridPanel.setLayout(null);
       this.add(gridPanel);
       gridPanel.setBounds(0, 0, 360, 600);
        FillGrid(); 
       
      
       
    }
  
    public void FillGrid(){
      
        for(int i=0; i<12; i++){
          for(int j=0; j<20; j++){
              if(!((j== 2 && i<10 && i >1)||(j == 3 && i<10 && i >1)|| (j == 8 && i<10 && i >1)||(j == 9 && i<10 && i >1)||(j == 14 && i<10 && i >1)||(j == 15 && i<10 && i >1)||(i == 5 && j<16 && j >2)||(i == 6 && j<16 && j >2))){
             blackline = BorderFactory.createLineBorder(Color.black);
              theNumberPanelArray[i][j] = new JPanel();
              theNumberPanelArray[i][j].setBorder(blackline);
              theNumberPanelArray[i][j].setBackground(Color.BLUE);
            //  theNumberPanelArray[i][j].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
              
              }else{
              theNumberPanelArray[i][j] = new JPanel();
              theNumberPanelArray[i][j].setBorder(blackline);
              theNumberPanelArray[i][j].setBackground(Color.BLACK);
              }
                int width = 30; // 30px wide
                int height = 30;// 30px high 
                int xLoc = i * 30; // 30px * the theMainGrid locale
                int yLoc = j * 30; // 30px * the grid locale
                
                
               
                theNumberPanelArray[i][j].setBounds(xLoc, yLoc, width, height);
               this.gridPanel.add(theNumberPanelArray[i][j]);
          }
    }
    }
    
    
    
    
}
