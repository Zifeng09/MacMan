/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.game.macman.model;

import macman.Direction;
import macman.game.map.Map;
import macman.game.map.SpacePanel;

/**
 *
 * @author Michael Kramer <mpk5206 @ psu.edu>
 */
public class MacManEntity {
	private int xPos = 0;
	private int yPos = 0;
	private Map parentMap;
	private Direction direction = Direction.NONE;
	private SpacePanel currentSpace;
	
	public MacManEntity(Map parentMap, SpacePanel spawnPanel, int spawnX, 
			int spawnY) {
		this.parentMap = parentMap;
		this.currentSpace = spawnPanel;
		this.xPos = spawnX;
		this.yPos = spawnY;
		//This should include some logic about X and Y Pos
	}

	public void move(Direction direction) {
		System.out.println("Moving " + direction);
		System.out.println("PlayerX: " + xPos);
		System.out.println("PlayerY: " + yPos);
		switch(direction) {
			case NONE:
				//Do Nothing
				break;
			case UP:
				yPos--;
				if(yPos < 0) {
					yPos = parentMap.getHeight() - 1;
				}
				this.direction = Direction.UP;
				break;
			case DOWN:
				yPos++;
				if(yPos > parentMap.getHeight() - 1) {
					yPos = 0;
				}
				this.direction = Direction.DOWN;
				break;
			case LEFT:
				xPos--;
				if(xPos < 0){
					xPos = parentMap.getWidth() - 1;
				}
				this.direction = Direction.LEFT;
				break;
			case RIGHT:
				xPos++;
				if(xPos > parentMap.getWidth() - 1){
					xPos = 0;
				}
				this.direction = Direction.RIGHT;
				break;	
		}
	}
	
	public void setCurrentSpace(SpacePanel currentSpace) {
		this.currentSpace.repaint();
		this.currentSpace = currentSpace;
		this.currentSpace.repaint();
	}
	
	public SpacePanel getCurrentSpace() {
		return this.currentSpace;
	}
	
	public int getXPos() {
		return this.xPos;
	}
	
	public int getYPos() {
		return this.yPos;
	}
	
}
