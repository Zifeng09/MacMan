/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman;

import java.awt.Color;
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
}
