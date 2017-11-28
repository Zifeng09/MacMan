/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.game.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
	private boolean hasPoint = false;
	public boolean stateChanged = false;
	private static BufferedImage enemyImage;
	private static BufferedImage playerImage;
	private static BufferedImage grassImage;
	private static BufferedImage pointImage;
	private static BufferedImage wallImage;
	
	private Map parentMap;
    
    public SpacePanel(Map parentMap, boolean isAWallSpace) {
		
		this.parentMap = parentMap;
        this.isAWallSpace = isAWallSpace;
		this.stateChanged = true;
//        if(isAWallSpace) {
//            background = Color.BLACK;
//            this.setBackground(background);
//            this.setBorder(new LineBorder(Color.WHITE));
//        } else  {
//            background = DEFAULT_BACKGROUND;
//            this.setBackground(background);
//            
//        }
		if(playerImage == null || enemyImage == null) {
			readImages();
		}
    }
    
    public boolean isWallSpace() {
        return isAWallSpace;
    }
	
	public void setPlayerState(boolean playerState) {
		if(hasPlayer != playerState) {
			stateChanged = true;
		}
		this.hasPlayer = playerState;
		if (this.hasPlayer && this.hasPoint) {
			hasPoint = false;
			this.parentMap.pointCollected();
		}
	}
	
	public void setEnemyState(boolean enemyState) {
		if(hasEnemy != enemyState) {
			stateChanged = true;
		}
		this.hasEnemy = enemyState;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(isAWallSpace) {
			paintWallImage(g);
		} else {
			paintBackground(g);
		}
		if(hasPlayer) {
			paintPlayerImage(g);
		} else if (hasEnemy) {
			paintEnemyImage(g);
		} else if (hasPoint) {
			paintPointImage(g);
		} else {
			//this.setBackground(background);
		}
	}
	
	private void paintBackground(Graphics g) {
		if(g != null) {
			//System.out.println("Graphics not null");
			g.drawImage(grassImage, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}

	private void paintPlayerImage(Graphics g) {
		if(g != null) {
			g.drawImage(playerImage, 0, 0, this.getWidth(), this.getHeight(), this);
		}
		
	}
	
	private void readImages() {
		try {
			grassImage = ImageIO.read(new File("resources/grass.png"));
			wallImage = ImageIO.read(new File("resources/wall.png"));
			pointImage = ImageIO.read(new File("resources/point.png"));
			enemyImage = ImageIO.read(new File("resources/enemy.png"));
			playerImage = ImageIO.read(new File("resources/macman.png")); 
		}catch (FileNotFoundException a) {
			System.err.println("FILE NOT FOUND");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} 
	}

	private void paintEnemyImage(Graphics g) {
		if(g != null) {
			g.drawImage(enemyImage, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	
	private void paintWallImage(Graphics g) {
		if(g != null) {
			g.drawImage(wallImage, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	
	private void paintPointImage(Graphics g) {
		if(g != null) {
			g.drawImage(pointImage, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	
	void setPointState(boolean pointState) {
		if(hasPoint != pointState) {
			stateChanged = true;
		}
		this.hasPoint = pointState;
	}
}
