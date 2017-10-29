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
        JPanel[][] theNumberPanelArray = new JPanel[12][18];
        Border blackline;
        private ArrayList<KeyEvent> keysDown;  
        
    public GameView(GameController theParentGameController){
        
        theGameController = theParentGameController;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
	this.setTitle("MACMAN BETA");
        this.setSize(new Dimension(375,578));
        this.setLayout(null);
        this.addKeyListener(this);
        paint();        

       
    }
     
    private void paint() {
      
       gridPanel = new JPanel();
       gridPanel.setLayout(null);
       this.add(gridPanel);
       gridPanel.setBounds(0, 0, 360, 600);
        FillGrid(); 
        updatePlayerLocation();
       
            
    }
  
    public void FillGrid(){
      
        for(int i=0; i<12; i++){
          for(int j=0; j<18; j++){
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
      public void updatePlayerLocation(){
         JPanel player = new JPanel();
         player = theNumberPanelArray[y][x];
         player.setBackground(Color.yellow);
       
      }
     public void lastColor(){
        theNumberPanelArray[y][x].setBackground(Color.BLUE);
     }
    
        @Override
   public void keyPressed(KeyEvent e) {
    
         // 没写防错的code player会吃掉墙，也会越界
             
         if(e.getKeyCode() == KeyEvent.VK_LEFT){
                lastColor();
                    y--;
                 updatePlayerLocation() ;
                
         }
    
           if(e.getKeyCode() == KeyEvent.VK_UP){
                lastColor();
                    x--;
                 updatePlayerLocation() ;
                
         }
           if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                lastColor();
                    y++;
                 updatePlayerLocation() ;
                
         }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                lastColor();
                   x++;
                 updatePlayerLocation() ;
                
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
    
    
    
    
    

