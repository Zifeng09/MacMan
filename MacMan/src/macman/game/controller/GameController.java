/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.game.controller;

import externaldata.controller.ExternalDataController;
import java.awt.Dimension;
import javax.swing.JFrame;
import macman.game.map.Map;
import macman.game.model.Game;
import macman.game.view.GameView;
import macman.highscore.ui.EnterUsernameUI;
import macman.mainmenu.MenuController;

/**
 *
 * @author N9864
 */
public class GameController {
	private Game game;
    private int level = 1;
    private GameView theGameView = null;
    private GameThread theGameThread;
   
  public GameController(){
		this.game = new Game(level, this);
        theGameView = new GameView(this);
        theGameView.setVisible(true);
        theGameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGameView.setLocationRelativeTo(null);
		theGameView.requestFocus();
        theGameThread = new GameThread(this, 1);
  }
  
  public void updateGame() {
		game.updateMap();
  }
  
  public void backMenu(){
		theGameView.setVisible(false);
		new MenuController(this);
  }
 
  public void levelCompleted() {
		level++;
		theGameThread.setDifficulty(level);
		theGameView.nextLevel(level);
  }
  
  public void gameOver() {
		theGameThread.dispose();
		theGameView.dispose();
        ExternalDataController dataController = ExternalDataController.getInstance();
        new EnterUsernameUI(game.getScore()).setVisible(true);
		backMenu();
  }
  
	public Map getGameMap() {
		return this.game.getMap();
	}
	
	public void nextLevel(Map nextMap) {
		level++;
		theGameView.setMap(nextMap);
		theGameView.updateLevel(level);
	}
	
	public void updateScore(int score) {
		this.theGameView.updateScore(score);
	}

	public void updatePlayerHealth(int health) {
		this.theGameView.updatePlayerHealth(health);
	}
        public void checkHighScore(int Score){
                
        
        }
        
}
