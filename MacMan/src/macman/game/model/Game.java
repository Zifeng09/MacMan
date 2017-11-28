/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.game.model;

import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;
import macman.game.controller.GameController;
import macman.game.macman.model.MacManEntity;
import macman.game.map.Map;
import macman.game.map.SpacePanel;


/**
 *
 * @author Michael Kramer <mpk5206 @ psu.edu>
 */
public class Game {

	private int level = 1;
	private Map map;
	private GameController parentController;
	
	public Game(int level, GameController parentContoller) {
		this.parentController = parentController;
		this.level = level;
		this.map = new Map(level, this);
	}
	
	public void moveEnemies() {
        map.updateEnemies();
    }
	
	
	
	public void collision() {
        JOptionPane.showMessageDialog(null, "game over");
        parentController.gameOver();
    }
	
	public void victory() {
		//Should do stuff
	}
	
	public int getBoardWidth() {
		return this.map.getWidth();
	}
	
	public int getBoardHeight() {
		return this.map.getHeight();
	}

	public Map getMap() {
		return this.map;
	}
	
	public void updateMap() {
		map.update();
	}
	
}
