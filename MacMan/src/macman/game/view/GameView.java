/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.game.view;

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
import macman.game.controller.GameController;
import macman.game.map.Map;
import macman.game.view.GamePanel;

/**
 *
 * @author N9864
 */
public class GameView extends JFrame implements KeyListener {
        JLabel bitcoin;
        JPanel grandPanel = new JPanel();
        PlayerPanel playerPanel;
        JPanel enemyPanel;
        GameController theGameController;
        GamePanel gamePanel;
        //GameView theGameView;
        Border blackline;
        private ArrayList<KeyEvent> keysDown;  
        private boolean isWall = false;
        int level =1; 
        
    public GameView(GameController theParentGameController){
		
        theGameController = theParentGameController;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
		this.setTitle("MACMAN BETA 0.1");
        
        this.addKeyListener(this);
		this.gamePanel = new GamePanel(theParentGameController.getGameMap());
		this.gamePanel.requestFocus();
        this.paint();
        //this.pack();

    }
     
    private void paint() {
		this.setLayout(new GridBagLayout());
		playerPanel = new PlayerPanel();
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 1;
		c.weighty = 1;
		c.fill= GridBagConstraints.BOTH;
		this.add(gamePanel, c);
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = .3;
		c.weighty = 1;
		c.fill= GridBagConstraints.BOTH;
		this.add(playerPanel, c);
		
		this.setSize(700, 500);
    }
    
    
   

    
//    public void FillGrid(int level){
//      
//        for(int i=0; i<20; i++){
//          for(int j=0; j<20; j++){
//             // if(!((j==1)||(i==20))){
//              blackline = BorderFactory.createLineBorder(Color.black);
//              theNumberPanelArray[i][j] = new JPanel();
//              theNumberPanelArray[i][j].setBorder(blackline);
//              theNumberPanelArray[i][j].setBackground(Color.BLUE);
//            //  theNumberPanelArray[i][j].setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
//              
//             /* }else{
//              theNumberPanelArray[i][j] = new JPanel();
//              theNumberPanelArray[i][j].setBorder(blackline);
//              theNumberPanelArray[i][j].setBackground(Color.BLACK);
//              }*/
//                int width = 15; // 30px wide
//                int height = 15;// 30px high 
//                int xLoc = i * 15; // 30px * the theMainGrid locale
//                int yLoc = j * 15; // 30px * the grid locale
//                
//                theNumberPanelArray[i][j].setBounds(xLoc, yLoc, width, height);
//               this.gamePanel.add(theNumberPanelArray[i][j]);
//          }
//    }
    
//    public void points(){
////    int numberOfPoints = 2;
////    
////    for(int d=0; d<numberOfPoints; d++){
////         JPanel point =new JPanel();
////         Random rand = new Random();
////         int w = rand.nextInt(18)+1;
////         int y = rand.nextInt(18)+1;
////         point = theNumberPanelArray[w][y];
////         point.setBackground(Color.green);
////    }     
//
//        
//   /* JPanel point1 =new JPanel();
//    JPanel point2 =new JPanel();
//    JPanel point3 =new JPanel();
//    JPanel point4 =new JPanel();
//    
//    
//    point1 = theNumberPanelArray[9][9];
//    point2 = theNumberPanelArray[12][12];
//    point3 = theNumberPanelArray[15][15];
//    point4 = theNumberPanelArray[18][18];
//    point1.setBackground(Color.green);
//    point2.setBackground(Color.green);
//    point3.setBackground(Color.green);
//    point4.setBackground(Color.green);*/  
//    
//    }

    
    public void checkVictory(){
//        
//        int touch =0;
//        for(int i=0; i<20; i++){
//            for(int j=0; j<20; j++){
//                if(theNumberPanelArray[i][j].getBackground() != Color.GREEN){
//                    
//                
//                touch +=1;
//                }
//            }
//                    
//        }
//        
//         if(touch == 400){
//                JOptionPane.showMessageDialog(null, "win");
//                theGameController.levelCompleted();
//         }
//        
    }
    
    
    
    
    public void nextLevel(int level){
		 
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		System.out.println("KeyPressed");
		this.theGameController.getGameMap().playerEnteredControl(ke);
        repaint();
	}

	@Override
	public void keyReleased(KeyEvent ke) {

	}

	public void setMap(Map nextMap) {
		this.gamePanel.setMap(nextMap);
	}
	
	public void updateScore(int score) {
		this.playerPanel.updateScore(score);
	}

	public void updatePlayerHealth(int health) {
		this.playerPanel.updatePlayerHealth(health);
	}
	
	public void updateLevel(int level) {
		this.playerPanel.updateLevel(level);
	}
}
    
    
    
    
    

