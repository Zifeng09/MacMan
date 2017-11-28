/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.game.map;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author mpk5206
 */
public class SpacePanel extends JPanel {
    private static final Color DEFAULT_BACKGROUND = Color.BLUE;
    private final boolean isAWallSpace;
    private Color background;
	
	private boolean hasPlayer = false;
	private boolean hasEnemy = false;
    
    public SpacePanel(boolean isAWallSpace) {
        this.isAWallSpace = isAWallSpace;
        if(isAWallSpace) {
            background = Color.BLACK;
            this.setBackground(background);
            this.setBorder(new LineBorder(Color.WHITE));
        } else  {
            background = DEFAULT_BACKGROUND;
            this.setBackground(background);
            
        }
    }
    
    public boolean isWallSpace() {
        return isAWallSpace;
    }
	
	public void setPlayerState(boolean playerState) {
		this.hasPlayer = playerState;
		if(playerState = false) {
			this.background = Color.BLUE;
			this.setBackground(background);
		}
		this.paintComponents(this.getGraphics());
	}
	
	public void setEnemyState(boolean enemyState) {
		this.hasEnemy = enemyState;
	}
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		if(hasPlayer) {
			paintPlayerImage();
		} else if (hasEnemy) {
			paintEnemyImage();
		} else {
			this.setBackground(background);
		}
	}

	private void paintPlayerImage() {
		//System.out.println("Painting Player Image");
		this.setBackground(Color.YELLOW);
	}

	private void paintEnemyImage() {
		this.setBackground(Color.RED);
	}
	
	private void paintWall() {
		this.setBackground(Color.BLACK);
	}
}
