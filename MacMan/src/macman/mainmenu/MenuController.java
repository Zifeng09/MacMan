/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.mainmenu;

import macman.MenuView;
import macman.game.controller.GameController;
import macman.highscore.ui.HighscoreUI;
import macman.instruction.ui.InstructionUI;

/**
 *
 * @author N9864
 */
public class MenuController {
    private MenuView theMenuView;
    private MenuModel theMenuModel;
    private GameController theGameCntl;
    private InstructionUI instructionUI;
    private HighscoreUI highscoreUI;
    
    public MenuController(){
        theMenuView = new MenuView(this);
        theMenuView.setVisible(true);
        theMenuView.setLocationRelativeTo(null);
        
    }
    
    
    public void startGame(){
        theGameCntl = new GameController();
    }

    public void viewHighscores() {
        System.out.println("Opening Highscore Window");
        highscoreUI = new HighscoreUI(this);
    }

    public void viewInstructions() {
        System.out.println("Opening Instruction Window");
        instructionUI = new InstructionUI(this);
    }
    
    public void displayMenu() {
        System.out.println("Display Meun");
        if (instructionUI != null) {
            instructionUI.dispose();
            instructionUI = null;
        }
        if (highscoreUI != null) {
            highscoreUI.dispose();
            highscoreUI = null;
        }
        theMenuView.setVisible(true);
    }
   
}
