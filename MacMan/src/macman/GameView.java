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
        int j=9;
        int k=9;
        JLabel bitcoin;
        ImageIcon BTC = new ImageIcon("Bitcoin_Logo.png");
        JPanel gridPanel, playerPanel, enemyPanel;
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
        this.setSize(new Dimension(288,500));
        this.setLayout(null);
        this.addKeyListener(this);
        paint();        

       
    }
     
    private void paint() {
      
       gridPanel = new JPanel();
       gridPanel.setLayout(null);
       this.add(gridPanel);
       gridPanel.setBounds(0, 0, 900, 600);
        FillGrid(); 
        updatePlayerLocation();
        initialenemy();
       
            
    }
   
  
    public void FillGrid(){
      
        for(int i=0; i<24; i++){
          for(int j=0; j<40; j++){
             // if(!((j==1)||(i==20))){
              blackline = BorderFactory.createLineBorder(Color.black);
              theNumberPanelArray[i][j] = new JPanel();
              theNumberPanelArray[i][j].setBorder(blackline);
              theNumberPanelArray[i][j].setBackground(Color.BLUE);
            //  theNumberPanelArray[i][j].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
              
             /* }else{
              theNumberPanelArray[i][j] = new JPanel();
              theNumberPanelArray[i][j].setBorder(blackline);
              theNumberPanelArray[i][j].setBackground(Color.BLACK);
              }*/
                int width = 12; // 30px wide
                int height = 12;// 30px high 
                int xLoc = i * 12; // 30px * the theMainGrid locale
                int yLoc = j * 12; // 30px * the grid locale
                
                theNumberPanelArray[i][j].setBounds(xLoc, yLoc, width, height);
               this.gridPanel.add(theNumberPanelArray[i][j]);
          }
    }
    }
    
    public void initialenemy(){
    JPanel enemy =new JPanel();
    JPanel clear =new JPanel();

    enemy = theNumberPanelArray[j][k];
    clear=theNumberPanelArray[j-1][k];
    for(int j=9; j<20; j++){
    clear.setBackground(Color.blue);
    enemy.setBackground(Color.red);
    }
    
    
    
    }
      public void updatePlayerLocation(){
          
         
         JPanel player = new JPanel();
         
         player = theNumberPanelArray[x][y];
         player.setBackground(Color.yellow);
         
      }
      public void erasepastL(){
      JPanel past=new JPanel();
      past=theNumberPanelArray[0][y];
      past.setBackground(Color.blue);
      
      }
      public void erasepastR(){
      JPanel past=new JPanel();
      past=theNumberPanelArray[23][y];
      past.setBackground(Color.blue);
      
      }
      public void erasepastU(){
      JPanel past=new JPanel();
      past=theNumberPanelArray[x][0];
      past.setBackground(Color.blue);
      
      }
      public void erasepastD(){
      JPanel past=new JPanel();
      past=theNumberPanelArray[x][39];
      past.setBackground(Color.blue);
      
      }
      
      
     public void lastColor(){
        theNumberPanelArray[x][y].setBackground(Color.blue);
     }
     
    
    
        @Override
   public void keyPressed(KeyEvent e) {
    
            
         if(e.getKeyCode() == KeyEvent.VK_LEFT){
         
            if(x!=0){
                 lastColor();
                    x--;
                 updatePlayerLocation();
            }
            else{
            erasepastL();
            x=23;
            updatePlayerLocation();
            }
         }
         if(e.getKeyCode() == KeyEvent.VK_RIGHT){
               if(x!=23){
                lastColor();
                 x++;
                 updatePlayerLocation();
               }    
               else{
               erasepastR();
               x=0;
               updatePlayerLocation();
               }
         }
    
           if(e.getKeyCode() == KeyEvent.VK_UP){
             if(y!=0){
                lastColor();
                 y--;
                 updatePlayerLocation();
             }  
             else{
             erasepastU();
             y=39;
             updatePlayerLocation();
             }
         }
           
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                if(y!=39){
                lastColor();
                 y++;
                 updatePlayerLocation() ;
                }   
                else{
                    y=0;
                    erasepastD();
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
    
    
    
    
    

