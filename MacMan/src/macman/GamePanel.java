/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import static macman.GameView.boardHeight;
import static macman.GameView.boardWidth;

/**
 *
 * @author mpk5206
 */
public class GamePanel extends JPanel implements KeyListener {
    private SpacePanel[][] spaceArray;
    int playerX = 0;
    int playerY = 0;
    JLabel bitcoin;
    JPanel grandPanel = new JPanel();
    ImageIcon BTC = new ImageIcon("Bitcoin_Logo.png");
    JPanel gridPanel, playerPanel, enemyPanel;
    GameController theGameController;
    Border blackline;
    private ArrayList<KeyEvent> keysDown;  
    private boolean isWall = false;
    private Enemy[] enemies;
    int level =1; 
    
    public GamePanel() {
        this.addKeyListener(this);
        populatePanels();
        this.enemies = new Enemy[6];
        this.enemies[0] = new Enemy();
        this.enemies[1] = new Enemy();
        this.enemies[2] = new Enemy();
        this.enemies[3] = new Enemy();
        this.enemies[4] = new Enemy();
        this.enemies[5] = new Enemy();
        this.setBackground(Color.BLACK);
        this.repaint();
        this.revalidate();
    }
    
    private void populatePanels() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        spaceArray = new SpacePanel[20][20];
        for(int i = 0; i < 20; i++) {
            for(int j=0; j < 20; j++) {
                Random rng = new Random();
                
                SpacePanel selectedSpace = new SpacePanel(rng.nextInt(10) > 7);
                spaceArray[i][j] = selectedSpace;
                c.gridx = i;
                c.gridy = j;
                c.weightx = 1;
                c.weighty = 1;
                c.fill = GridBagConstraints.BOTH;
                add(selectedSpace, c);
            }
        }
    }
    
    
    public void buildWall(){
//       int i = 1;
//        Border whiteline;
//        whiteline = BorderFactory.createLineBorder(Color.white);
//        while(i == 1){
//            for(int j = 0; j<= 14; j++){
//                theNumberPanelArray[i][j].setBorder(whiteline);
//                theNumberPanelArray[i][j].setBackground(Color.BLACK);
//            }
//            i = 9;
//        }
//        while(i == 9){
//            for(int j = 2; j<= 12; j++){
//                theNumberPanelArray[j][i].setBorder(whiteline);
//                theNumberPanelArray[j][i].setBackground(Color.BLACK);
//        }
//            i = 14;
//        }
//        
//        while(i == 14){
//            for(int j = 4; j<= 10; j++){
//                theNumberPanelArray[j][i].setBorder(whiteline);
//                theNumberPanelArray[j][i].setBackground(Color.BLACK);
//        }
//            for(int j = 11; j < 18; j++){
//                theNumberPanelArray[i][j].setBorder(whiteline);
//                theNumberPanelArray[i][j].setBackground(Color.BLACK);
//            }
//            i = 11;
//    }
//        while(i == 11){
//              for(int j = 12; j < 20; j++){
//                theNumberPanelArray[i][j].setBorder(whiteline);
//                theNumberPanelArray[i][j].setBackground(Color.BLACK);
//            }
//              i = 5;
//        }
//        while(i == 5){
//              for(int j = 0; j <= 6; j++){
//                theNumberPanelArray[i][j].setBorder(whiteline);
//                theNumberPanelArray[i][j].setBackground(Color.BLACK);
//            }
//              i = 3;
//        }
//        while(i == 3){
//            for(int j = 6; j <= 15; j++){
//                theNumberPanelArray[j][i].setBorder(whiteline);
//                theNumberPanelArray[j][i].setBackground(Color.BLACK);
//            }
//            i = 6;
//        }
//        while(i == 6){
//            for(int j = 10; j < 20; j++){
//                theNumberPanelArray[j][i].setBorder(whiteline);
//                theNumberPanelArray[j][i].setBackground(Color.BLACK);
//            }
//            i = 0;
//        }    
    }
        
    public void points(){
        int numberOfPoints = 2;

        for(int d=0; d<numberOfPoints; d++){
            JPanel point =new JPanel();
            Random rand = new Random();
            int w = rand.nextInt(18)+1;
            int y = rand.nextInt(18)+1;
            point = spaceArray[w][y];
            point.setBackground(Color.green);
        }
    }  
    
    
    public void updateEnemies() {
        for(int i = 0; i < enemies.length; i++) {
            Random rand = new Random();
            int n = rand.nextInt(4)+1;
            System.out.println(n);
            SpacePanel desiredSpace;
            switch(n) {
                case 1:
                    spaceArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.BLUE);
                    if (enemies[i].yPos == 0) {
                        desiredSpace = spaceArray[enemies[i].xPos][19];
                    } else {
                        desiredSpace = spaceArray[enemies[i].xPos][enemies[i].yPos - 1];
                    }
                    if (!desiredSpace.isWallSpace()) {
                        enemies[i].moveUp();
                    }
                    spaceArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.RED);
                    if(playerX == enemies[i].xPos && playerY == enemies[i].yPos) {
                      collision();     
                    }
                    break;
                case 2:
                    spaceArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.BLUE);
                    if(enemies[i].yPos == 19) {
                        desiredSpace = spaceArray[enemies[i].xPos][0];
                    } else {
                        desiredSpace =spaceArray[enemies[i].xPos][enemies[i].yPos + 1];
                    }
                    if (!desiredSpace.isWallSpace()) {
                        enemies[i].moveDown();
                    }
                    spaceArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.RED);
                    if(playerX == enemies[i].xPos && playerY == enemies[i].yPos) {
                      collision();     
                    }
                    break;    
                case 3:
                    spaceArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.BLUE);
                    if(enemies[i].xPos == 0) {
                        desiredSpace = spaceArray[19][enemies[i].yPos];
                    } else { 
                        desiredSpace = spaceArray[enemies[i].xPos - 1][enemies[i].yPos];
                    }
                    if (!desiredSpace.isWallSpace()) {
                        enemies[i].moveLeft();
                    }
                    spaceArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.RED);
                    if(playerX == enemies[i].xPos && playerY == enemies[i].yPos) {
                      collision();     
                    }
                    break;
                case 4:   
                    spaceArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.BLUE);
                    if(enemies[i].xPos == 19) {
                        desiredSpace = spaceArray[0][enemies[i].yPos];
                    } else {
                        desiredSpace = spaceArray[enemies[i].xPos + 1][enemies[i].yPos];
                    }
                    if (!desiredSpace.isWallSpace()) {
                      enemies[i].moveRight();
                    }
                    spaceArray[enemies[i].xPos][enemies[i].yPos].setBackground(Color.RED);
                    if(playerX == enemies[i].xPos && playerY == enemies[i].yPos) {
                        collision();     
                    }
                break;
            }
        }
    }
    
    public void updatePlayerLocation(){
       JPanel player;
       player = spaceArray[playerX][playerY];
       player.setBackground(Color.yellow);
       checkCollision();
       //checkVictory();
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
                if(spaceArray[i][j].getBackground() != Color.GREEN){
                    
                
                touch +=1;
                }
            }         
        }
        
        if(touch == 400){
               JOptionPane.showMessageDialog(null, "win");
               theGameController.levelCompleted();
        }
        
    }
    
    
    public void collision() {
        JOptionPane.showMessageDialog(null, "game over");
        theGameController.gameOver();
        this.setVisible(false);
    }
      
    public void erasepastL(){
        JPanel past=new JPanel();
        past=spaceArray[0][playerY];
        past.setBackground(Color.blue);

    }
    public void erasepastR(){
        JPanel past=new JPanel();
        past=spaceArray[19][playerY];
        past.setBackground(Color.blue);

    }
    public void erasepastU(){
        JPanel past=new JPanel();
        past=spaceArray[playerX][0];
        past.setBackground(Color.blue);

    }
    public void erasepastD(){
        JPanel past=new JPanel();
        past=spaceArray[playerX][19];
        past.setBackground(Color.blue);

    }


    public void lastColor(){
       spaceArray[playerX][playerY].setBackground(Color.blue);
    }
     
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        SpacePanel desiredSpace;  
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
           if(playerX == 0) {
               desiredSpace = spaceArray[19][playerY];
            } else { 
               desiredSpace = spaceArray[playerX - 1][playerY];
            }
            if (desiredSpace.isWallSpace()) {
               //Player would eb moving into wall 
               //Do Nothing
            } else {
                if(playerX!=0){
                    lastColor();
                    playerX--;
                    updatePlayerLocation();
                } else {
                    erasepastL();
                    playerX=19;
                    updatePlayerLocation();
                }
           }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX == 19) {
                desiredSpace = spaceArray[0][playerY];
            } else {
                desiredSpace = spaceArray[playerX + 1][playerY];
            }
            if (desiredSpace.isWallSpace()) {
                //Player is moving into wall
                //Do Nothing
            } else {
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
        }
    
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(playerY == 0) {
                desiredSpace = spaceArray[playerX][19];
            } else {
                desiredSpace = spaceArray[playerX][playerY - 1];
            }
            if (desiredSpace.isWallSpace()) {
                //Player is moving into wall
                //Do Nothing
            } else {
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
        }
         
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(playerY == 19) {
                desiredSpace = spaceArray[playerX][0];
            } else {
                desiredSpace = spaceArray[playerX][playerY + 1];
            }
                
            if (desiredSpace.isWallSpace()) {
                //Player is moving into wall
                //Do Nothing
            } else {
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
        }
        repaint();
            
        
   }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
}
