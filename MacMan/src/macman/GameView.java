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
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author N9864
 */
public class GameView extends JFrame implements KeyListener {
    public static final int boardWidth = 20;
    public static final int boardHeight = 20;
    playerUI thePlayerUI;
    
        int playerX = 0;
        int playerY = 0;
        int j=9;
        int k=9;
        JLabel bitcoin;
        JPanel grandPanel = new JPanel();
        ImageIcon BTC = new ImageIcon("Bitcoin_Logo.png");
        JPanel gridPanel, playerPanel, enemyPanel;
        GameController theGameController;
        //GameView theGameView;
        JPanel[][] theNumberPanelArray = new JPanel[boardWidth][boardHeight];
        Border blackline;
        private ArrayList<KeyEvent> keysDown;  
        private boolean isWall = false;
        private Enemy[] enemies;
        int level =1; 
    public GameView(GameController theParentGameController){
        
        theGameController = theParentGameController;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
	this.setTitle("MACMAN BETA 0.1");
        this.setSize(new Dimension(500, 340));
        this.setLayout(new BorderLayout());
        this.addKeyListener(this);

        this.enemies = new Enemy[6];
        this.enemies[0] = new Enemy();
        this.enemies[1] = new Enemy();
        this.enemies[2] = new Enemy();
        this.enemies[3] = new Enemy();
        this.enemies[4] = new Enemy();
        this.enemies[5] = new Enemy();
        
        
        
       
        this.paint();
        //this.pack();

       
    }
     
    private void paint() {
       thePlayerUI = new playerUI(theGameController);
       gridPanel = new JPanel();
       gridPanel.setLayout(null);
       gridPanel.setSize(new Dimension(315,340));
       gridPanel.setFocusable(true);
      
       JPanel thePlayerPanel = thePlayerUI.getPanel();
       thePlayerPanel.setSize(185,340);
       
       this.add(gridPanel,BorderLayout.CENTER);
       this.add(thePlayerUI.getPanel(),BorderLayout.EAST);
        gridPanel.addKeyListener(this);
        FillGrid();  
        buildWall();
        points();
        updatePlayerLocation();
        
            
    }
    
    
   
    public void buildWall(){
       int i = 2;
        Border whiteline;
        whiteline = BorderFactory.createLineBorder(Color.white);
        while(i == 2){
            for(int j = 0; j<= 13; j++){
                theNumberPanelArray[i][j].setBorder(whiteline);
                theNumberPanelArray[i][j].setBackground(Color.BLACK);
            }
            i = 15;
        }
        while(i == 15){
            for(int j = 6; j<= 12; j++){
                theNumberPanelArray[j][i].setBorder(whiteline);
                theNumberPanelArray[j][i].setBackground(Color.BLACK);
        }
            i = 10;
    }
    }
    
    public void FillGrid(){
      
        for(int i=0; i<20; i++){
          for(int j=0; j<20; j++){
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
                int width = 15; // 30px wide
                int height = 15;// 30px high 
                int xLoc = i * 15; // 30px * the theMainGrid locale
                int yLoc = j * 15; // 30px * the grid locale
                
                theNumberPanelArray[i][j].setBounds(xLoc, yLoc, width, height);
               this.gridPanel.add(theNumberPanelArray[i][j]);
          }
    }
        
        
        
    }
    
    public void points(){
    int numberOfPoints = 2;
    
    for(int d=0; d<numberOfPoints; d++){
         JPanel point =new JPanel();
         Random rand = new Random();
         int w = rand.nextInt(18)+1;
         int y = rand.nextInt(18)+1;
         point = theNumberPanelArray[w][y];
         point.setBackground(Color.green);
    }     
        
   /* JPanel point1 =new JPanel();
    JPanel point2 =new JPanel();
    JPanel point3 =new JPanel();
    JPanel point4 =new JPanel();
    
    
    point1 = theNumberPanelArray[9][9];
    point2 = theNumberPanelArray[12][12];
    point3 = theNumberPanelArray[15][15];
    point4 = theNumberPanelArray[18][18];
    point1.setBackground(Color.green);
    point2.setBackground(Color.green);
    point3.setBackground(Color.green);
    point4.setBackground(Color.green);*/  
    
    }
    public void updateEnemies() {
        for(int i = 0; i < enemies.length; i++) {
            Random rand = new Random();
            int n = rand.nextInt(4)+1;
            System.out.println(n);
            
            switch(n){
            
              case 1:
              theNumberPanelArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.BLUE);
            
              enemies[i].moveUp();
              theNumberPanelArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.RED);
              if(playerX == enemies[i].xPos && playerY == enemies[i].yPos) {
                collision();     
            }
              break;
              
              
              case 2:
        
              theNumberPanelArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.BLUE);
            
              enemies[i].moveDown();
              theNumberPanelArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.RED);
              if(playerX == enemies[i].xPos && playerY == enemies[i].yPos) {
                collision();     
            }
              break;    
            
              
              case 3:
        
              theNumberPanelArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.BLUE);
            
              enemies[i].moveLeft();
              theNumberPanelArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.RED);
              if(playerX == enemies[i].xPos && playerY == enemies[i].yPos) {
                collision();     
            }
              break;
              
              
              case 4:
        
              theNumberPanelArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.BLUE);
            
              enemies[i].moveRight();
              theNumberPanelArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.RED);
              if(playerX == enemies[i].xPos && playerY == enemies[i].yPos) {
              
                  collision();     
            }
              break;
            
            
          
            
        }

        }
    }
    
    public void updatePlayerLocation(){
       JPanel player = new JPanel();

       player = theNumberPanelArray[playerX][playerY];
       player.setBackground(Color.yellow);
       checkCollision();
       checkVictory();
    }
    
    public void checkCollision() {
        for(int i = 0; i < enemies.length; i++) {
            if(playerX == enemies[i].xPos && playerY == enemies[i].yPos) {
                collision();
            }
        }
    }
    
    public void checkVictory(){
        
        int touch =0;
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                if(theNumberPanelArray[i][j].getBackground() != Color.GREEN){
                    
                
                touch +=1;
                }
            }
                    
        }
        
         if(touch == 400){
                JOptionPane.showMessageDialog(null, "win");
                theGameController.levelCompleted();
         }
        
    }
    
    
    
    
     public void nextLevel(int level){
        this.FillGrid(level);
        this.points();
        this.revalidate();
        this.repaint();
  
  }
    
    
    public void collision() {
        JOptionPane.showMessageDialog(null, "game over");
        theGameController.gameOver();
        this.setVisible(false);
    }
      
    public void erasepastL(){
        JPanel past=new JPanel();
        past=theNumberPanelArray[0][playerY];
        past.setBackground(Color.blue);

    }
    public void erasepastR(){
        JPanel past=new JPanel();
        past=theNumberPanelArray[19][playerY];
        past.setBackground(Color.blue);

    }
    public void erasepastU(){
        JPanel past=new JPanel();
        past=theNumberPanelArray[playerX][0];
        past.setBackground(Color.blue);

    }
    public void erasepastD(){
        JPanel past=new JPanel();
        past=theNumberPanelArray[playerX][19];
        past.setBackground(Color.blue);

    }


    public void lastColor(){
       theNumberPanelArray[playerX][playerY].setBackground(Color.blue);
    }
     
    
    
        @Override
   public void keyPressed(KeyEvent e) {
    
            
         if(e.getKeyCode() == KeyEvent.VK_LEFT){
         
            if(playerX!=0){
                 lastColor();
                    playerX--;
                 updatePlayerLocation();
            }
            else{
            erasepastL();
            playerX=19;
            updatePlayerLocation();
            }
         }
         if(e.getKeyCode() == KeyEvent.VK_RIGHT){
               if(playerX!=19){
                lastColor();
                 playerX++;
                 updatePlayerLocation();
               }    
               else{
               erasepastR();
               playerX=0;
               updatePlayerLocation();
               }
         }
    
           if(e.getKeyCode() == KeyEvent.VK_UP){
             if(playerY!=0){
                lastColor();
                 playerY--;
                 updatePlayerLocation();
             }  
             else{
             erasepastU();
             playerY=19;
             updatePlayerLocation();
             }
         }
           
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                if(playerY!=19){
                lastColor();
                 playerY++;
                 updatePlayerLocation() ;
                }   
                else{
                    playerY=0;
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
    
    
    
    
    

