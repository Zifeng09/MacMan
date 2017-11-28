/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.game.map;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import macman.game.enemy.model.Enemy;
import macman.Direction;
import macman.game.macman.model.MacManEntity;
import macman.game.model.Game;


/**
 * This class will be used to by the GamePanel class. It will track what the
 * different spaces are.
 * 
 * @author Michael Kramer <mpk5206@psu.edu>
 */
public class Map {
	private Random rng = new Random();
	private static final int ENEMY_COUNT = 0;
	private int numberOfPoints = 1;
	private int numberOfPointsCollected = 0;
	private SpacePanel[][] spaceArray;
	private Enemy[] enemies = new Enemy[ENEMY_COUNT];
	private int mapWidth = 0;
	private int mapHeight = 0;
	private int level = 1;
	private Game parentGame;
	private MacManEntity player;
	
	public Map(int level, Game parentGame) {
		this.parentGame =  parentGame;
		this.level = level;
		this.mapWidth = 14 + level;
		this.mapHeight = 14 + level;
		this.generateSpaces();
		this.spawnPlayer();
		
		this.generateEnemies();
		this.spawnPoints();
	}
	
	private void generateSpaces() {
		spaceArray = new SpacePanel[mapHeight][mapWidth];
		for (int i = 0; i < mapHeight; i++) {
			for(int j = 0; j < mapWidth; j++) {
				//spaceArray[i][j] = new SpacePanel(this, rng.nextBoolean());
				spaceArray[i][j] = new SpacePanel(this, false);
			}
		}
	}
	
	private void spawnPlayer() {
		SpacePanel randomSpace;
		int randomX;
		int randomY;
		do {
			randomX = rng.nextInt(mapHeight);
			randomY = rng.nextInt(mapWidth);
			randomSpace = spaceArray[randomX][randomY];
		} while (randomSpace.isWallSpace());
		SpacePanel playerSpawnPanel = this.getRandomSpace(false);
		this.player = new MacManEntity(this, playerSpawnPanel, randomX, randomY);
		
		playerSpawnPanel.setPlayerState(true);
	}
	
	private void generateEnemies() {
		for(int i = 0; i < ENEMY_COUNT; i++) {
			int randomX = rng.nextInt(mapWidth - 1);
			int randomY = rng.nextInt(mapHeight - 1);
			enemies[i] = new Enemy(level, this, spaceArray[randomX][randomY], 
					randomX, randomY);
		}
	}
	
	private void spawnPoints(){
        for(int i = 0; i < numberOfPoints; i++){
			SpacePanel randomSpace;
			do {
				int randomX = rng.nextInt(spaceArray[0].length);
				int randomY =rng.nextInt(spaceArray.length);
				randomSpace = spaceArray[randomX][randomY];
			} while (randomSpace.isWallSpace());
			randomSpace.setPointState(true);	
        }
    }  
	
	
	public SpacePanel getSpacePanel(int x, int y) {
		return spaceArray[x][y];
	}
	
	public int getWidth() {
		return this.mapWidth;
	}
	
	public int getHeight() {
		return this.mapHeight;
	}
	
	public void updateEnemies() {
		for(int i = 0; i < enemies.length; i++) {
            Random rand = new Random();
            int n = rand.nextInt(4)+1;
            System.out.println(n);
            SpacePanel desiredSpace;
            switch(n) {
                case 1: // Moving Up
                    spaceArray[enemies[i].getXPos()][enemies[i].getYPos()].setBackground(Color.BLUE);
                    if (enemies[i].getYPos() == 0) {
                        desiredSpace = spaceArray[enemies[i].getXPos()][mapHeight - 1];
                    } else {
                        desiredSpace = spaceArray[enemies[i].getXPos()][enemies[i].getYPos() - 1];
                    }
                    if (!desiredSpace.isWallSpace()) {
                        enemies[i].move(Direction.UP);
						enemies[i].changeCurrentSpace(desiredSpace);
                    }
                    spaceArray[enemies[i].getXPos()][enemies[i].getYPos()].setBackground(Color.RED);
                    if(player.getXPos() == enemies[i].getXPos() && player.getYPos() == enemies[i].getYPos()) {
						collisionDetected();
                    }
                    break;
                case 2: // Moing Down
                    spaceArray[enemies[i].getXPos()][enemies[i].getYPos()].setBackground(Color.BLUE);
                    if(enemies[i].getYPos() == mapHeight - 1) {
                        desiredSpace = spaceArray[enemies[i].getXPos()][0];
                    } else {
                        desiredSpace =spaceArray[enemies[i].getXPos()][enemies[i].getYPos() + 1];
                    }
                    if (!desiredSpace.isWallSpace()) {
                        enemies[i].move(Direction.DOWN);
						enemies[i].changeCurrentSpace(desiredSpace);
                    }
                    spaceArray[enemies[i].getXPos()][enemies[i].getYPos()].setBackground(Color.RED);
                    if(player.getXPos() == enemies[i].getXPos() && player.getYPos() == enemies[i].getYPos()) {
                      collisionDetected();     
                    }
                    break;    
                case 3: //Left
                    spaceArray[enemies[i].getXPos()][enemies[i].getYPos()].setBackground(Color.BLUE);
                    if(enemies[i].getXPos() == 0) {
                        desiredSpace = spaceArray[mapWidth - 1][enemies[i].getYPos()];
                    } else { 
                        desiredSpace = spaceArray[enemies[i].getXPos() - 1][enemies[i].getYPos()];
                    }
                    if (!desiredSpace.isWallSpace()) {
                        enemies[i].move(Direction.LEFT);
						enemies[i].changeCurrentSpace(desiredSpace);
                    }
                    spaceArray[enemies[i].getXPos()][enemies[i].getYPos()].setBackground(Color.RED);
                    if(player.getXPos() == enemies[i].getXPos() && player.getYPos() == enemies[i].getYPos()) {
                      collisionDetected();     
                    }
                    break;
                case 4:   
                    spaceArray[enemies[i].getXPos()][enemies[i].getYPos()].setBackground(Color.BLUE);
                    if(enemies[i].getXPos() == mapWidth - 1) {
                        desiredSpace = spaceArray[0][enemies[i].getYPos()];
                    } else {
                        desiredSpace = spaceArray[enemies[i].getXPos() + 1][enemies[i].getYPos()];
                    }
                    if (!desiredSpace.isWallSpace()) {
                      enemies[i].move(Direction.RIGHT);
					  enemies[i].changeCurrentSpace(desiredSpace);
                    }
                    spaceArray[enemies[i].getXPos()][enemies[i].getYPos()].setBackground(Color.RED);
                    if(player.getXPos() == enemies[i].getXPos() && player.getYPos() == enemies[i].getYPos()) {
                        collisionDetected();     
                    }
                break;
            }
			
        }
	}
	
	public void checkCollision() {
        for(int i = 0; i < enemies.length; i++) {
            if(player.getXPos() == enemies[i].getXPos() && player.getYPos() == enemies[i].getYPos()) {
                collisionDetected();
            }
        }
    }
	
	public void playerEnteredControl(KeyEvent keyEvent) {
		
		if(keyEvent == null)
			return;
        SpacePanel desiredSpace;  
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT){
			if(player.getXPos() != 0) {
                desiredSpace = spaceArray[player.getXPos() - 1][player.getYPos()];
            } else {
                desiredSpace = spaceArray[mapWidth - 1][player.getYPos()];
            }
            if (desiredSpace.isWallSpace()) {
                //Player is moving into wall
                //Do Nothing
            } else {
                player.getCurrentSpace().setPlayerState(false);
				desiredSpace.setPlayerState(true);
				player.move(Direction.LEFT);
				player.setCurrentSpace(desiredSpace);
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(player.getXPos() != spaceArray[0].length - 1) {
                desiredSpace = spaceArray[player.getXPos() + 1][player.getYPos()];
            } else {
                desiredSpace = spaceArray[0][player.getYPos()];
            }
            if (desiredSpace.isWallSpace()) {
                //Player is moving into wall
                //Do Nothing
            } else {
                player.getCurrentSpace().setPlayerState(false);
				desiredSpace.setPlayerState(true);
				player.move(Direction.RIGHT);
				player.setCurrentSpace(desiredSpace);
            }         
        }
    
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
            if(player.getYPos() == 0) {
                desiredSpace = spaceArray[player.getXPos()][mapHeight - 1];
            } else {
                desiredSpace = spaceArray[player.getXPos()][player.getYPos() - 1];
            }
            if (desiredSpace.isWallSpace()) {
                //Player is moving into wall
                //Do Nothing
            } else {
                player.getCurrentSpace().setPlayerState(false);
				desiredSpace.setPlayerState(true);
				player.move(Direction.UP);
				player.setCurrentSpace(desiredSpace);
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN){
            if(player.getYPos() == mapHeight - 1) {
                desiredSpace = spaceArray[player.getXPos()][0];
            } else {
                desiredSpace = spaceArray[player.getXPos()][player.getYPos() + 1];
            }
                
            if (desiredSpace.isWallSpace()) {
                //Player is moving into wall
                //Do Nothing
            } else {
				player.getCurrentSpace().setPlayerState(false);
				desiredSpace.setPlayerState(true);
				player.move(Direction.DOWN);
				player.setCurrentSpace(desiredSpace);
            }
        }
	}
	
	public void pointCollected() {
		this.parentGame.pointCollected();
		numberOfPointsCollected++;
		if(numberOfPointsCollected == numberOfPoints) {
			parentGame.mapCleared();
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

	private void collisionDetected() {
		parentGame.collision();		
	}
	
	public void update() {
		System.out.println("Here");
		updateEnemies();
		for(int i = 0; i < mapHeight; i++) {
			for(int j = 0; j < mapWidth; j++) {
				spaceArray[i][j].paintComponents(spaceArray[i][j].getGraphics());
			}
		}
	}
	
	private SpacePanel getRandomSpace(boolean canBeWall) {
		SpacePanel randomSpace;
		if(!canBeWall) {
			do {
			randomSpace = spaceArray[rng.nextInt(mapHeight)][rng.nextInt(mapWidth)];
			} while (randomSpace.isWallSpace());
		} else {
			randomSpace = spaceArray[rng.nextInt(mapHeight)][rng.nextInt(mapWidth)];
		}
		
		return randomSpace;
	}
}
