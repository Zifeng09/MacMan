/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import javax.swing.border.Border;
/**
 *
 * @author N9864
 */
public class GameView extends JFrame implements KeyListener{
        int x = 0;
        int y = 0;
        JLabel bitcoin;
        ImageIcon BTC = new ImageIcon("Bitcoin_Logo.png");
        JPanel gridPanel, playerPanel;
        GameController theGameController;
        GameView theGameView;
        JPanel[][] theNumberPanelArray = new JPanel[24][40];
        Border blackline;
        private ArrayList<KeyEvent> keysDown;  
        private boolean isWall = false;
        
    public GameView(GameController theParentGameController){
        
        theGameController = theParentGameController;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
	this.setTitle("MACMAN BETA 0.1");
        this.setSize(new Dimension(750,620));
        this.setLayout(null);
        this.addKeyListener(this);
        paint();        

       
    }
     
    private void paint() {
      
       gridPanel = new JPanel();
       gridPanel.setLayout(null);
       this.add(gridPanel);
       gridPanel.setBounds(0, 0, 760, 600);
        FillGrid(); 
        updatePlayerLocation();
       
            
    }
   
  
    public void FillGrid(){
      
        for(int i=0; i<24; i++){
          for(int j=0; j<40; j++){
              if(!((i==0)||(j==0)|| (i == 23)||(j == 40))){
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
                int width = 12; // 30px wide
                int height = 12;// 30px high 
                int xLoc = i * 12; // 30px * the theMainGrid locale
                int yLoc = j * 12; // 30px * the grid locale
                
                theNumberPanelArray[i][j].setBounds(xLoc, yLoc, width, height);
               this.gridPanel.add(theNumberPanelArray[i][j]);
          }
    }
    }
      public void updatePlayerLocation(){
          
         
         JPanel player = new JPanel();
         
         player = theNumberPanelArray[y][x];
         player.setBackground(Color.yellow);
         
      }
     public void lastColor(){
        theNumberPanelArray[y][x].setBackground(Color.red);
     }
     
    
    
        @Override
   public void keyPressed(KeyEvent e) {
    
            
         if(e.getKeyCode() == KeyEvent.VK_LEFT){
         
            if(y!=0){
                 lastColor();
                    y--;
                 updatePlayerLocation() ;
            }
         }
    
           if(e.getKeyCode() == KeyEvent.VK_UP){
             if(x!=0){
                lastColor();
                    x--;
                 updatePlayerLocation() ;
             }  
         }
           if(e.getKeyCode() == KeyEvent.VK_RIGHT){
               if(y!=11){
                lastColor();
                    y++;
                 updatePlayerLocation() ;
               }    
         }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                if(x!=17){
                lastColor();
                   x++;
                 updatePlayerLocation() ;
                }   
         }
        repaint();
            
        
   }
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void keyReleased(KeyEvent e) {
       
    }
    
    
    public void keyStopped(KeyEvent e) {
        
    }

    
    }

  

         
         
         
         
       // theNumberPanelArray[1][1].setBackground(Color.yellow);
       /*  this.gridPanel.validate();
         this.gridPanel.repaint();
         this.validate();
         this.repaint();*/
    
    
    
    
    

