/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.game.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Michael Kramer <mpk5206 @ psu.edu>
 */
public class PlayerPanel extends JPanel {
	private JLabel levelLbl;
	private JLabel scoreLbl;
	private JProgressBar healthBar;
	
	public PlayerPanel() {
		this.setBackground(Color.GRAY);
		addComponents();
	}
	
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		levelLbl = new JLabel("Level 1");
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.CENTER;
		add(levelLbl, c);
		scoreLbl = new JLabel("Score: 0");
		c.gridy = 1;
		add(scoreLbl, c);
		healthBar = new JProgressBar(0, 3, 3);
		healthBar.setValue(3);
		healthBar.setForeground(Color.GREEN);
		healthBar.setBackground(Color.GREEN);
		c.gridy =2;
		add(healthBar, c);
		
		
	}
	
	public void updateScore(int score) {
		System.err.println("Updating Score");
		scoreLbl.setText("Score: " + String.valueOf(score));
	}
	
	public void updatePlayerHealth(int playerHealth) {
		healthBar.setValue(playerHealth);
		
	}
	
	public void updateLevel(int level) {
		System.err.println("Updateing Level");
		levelLbl.setText("Level " + String.valueOf(level));
	}
	
}
