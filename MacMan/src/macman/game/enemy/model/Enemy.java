/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.game.enemy.model;

import java.util.Random;
import macman.Direction;
import macman.highscore.model.Score;
import macman.game.map.Map;
import macman.game.map.SpacePanel;
import macman.game.model.Game;
import macman.game.view.GameView;

/**
 *
 * @author Michael Kramer <mpk5206 @ psu.edu>
 */
public class Enemy {
	private Random rand = new Random();
    private int xPos = 0;
    private int yPos = 0;
    private int level = 1;
	private Map parentMap;
	private SpacePanel currentSpace;
	
    public Enemy(int level, Map parentMap, SpacePanel currentSpace,
			int spawnX, int spawnY) {
		this.level = level;
		this.parentMap = parentMap;
		this.currentSpace = currentSpace;
		currentSpace.setEnemyState(true);
		this.xPos = spawnX;
		this.yPos = spawnY;
    }
    
    public void move(int desiredX, int desiredY) {
        this.xPos = desiredX;
        this.yPos = desiredY;
    }
    
	public void move(Direction direction) {
		switch(direction) {
			case NONE:
				//Do Nothing
				return;
			case UP:
				yPos--;
				if(yPos < 0) {
					yPos = parentMap.getHeight() - 1;
				}
				return;
			case DOWN:
				yPos++;
				if(yPos > parentMap.getHeight() - 1) {
					yPos = 0;
				}
				return;
			case LEFT:
				xPos--;
				if(xPos < 0){
					xPos = parentMap.getWidth() - 1;
				}
				return;
			case RIGHT:
				xPos++;
				if(xPos > parentMap.getWidth() - 1){
					xPos = 0;
				}
				return;		
		}
	}
	public void changeCurrentSpace(SpacePanel newSpace) {
		this.currentSpace.setEnemyState(false);
		this.currentSpace = newSpace;
		this.currentSpace.setEnemyState(true);
	}
	
	public int getYPos() {
		return this.yPos;
	}
	
	public int getXPos() {
		return this.xPos;
	}
}
