/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.game.view;

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
import macman.game.controller.GameController;
import macman.game.map.Map;
import macman.game.map.SpacePanel;

/**
 *
 * @author mpk5206
 */
public class GamePanel extends JPanel {
	private Map map;
	private KeyEvent lastDirectionKeyStroke;
    
    private JLabel bitcoin;
    private JPanel grandPanel = new JPanel();
    private ImageIcon BTC = new ImageIcon("Bitcoin_Logo.png");
    private JPanel gridPanel, playerPanel, enemyPanel;
    private GameController theGameController;
    private Border blackline;
    private ArrayList<KeyEvent> keysDown;  
    private boolean isWall = false;
    private int level = 1; 
    
    public GamePanel(Map theMap) {
		this.map = theMap;
        placeSpacePanels();
        this.setBackground(Color.BLACK);
        this.repaint();
        this.revalidate();
    }
    
    private void placeSpacePanels() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for(int i = 0; i < map.getHeight(); i++) {
            for(int j=0; j < map.getWidth(); j++) {
                c.gridx = i;
                c.gridy = j;
                c.weightx = 1;
                c.weighty = 1;
                c.fill = GridBagConstraints.BOTH;
                add(map.getSpacePanel(i ,j), c);
            }
        }
    }

}
