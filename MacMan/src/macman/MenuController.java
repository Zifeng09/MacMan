/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman;

/**
 *
 * @author N9864
 */
public class MenuController {
    private MenuView theMenuView;
    private MenuModel theMenuModel;
    private GameController theGameCntl;
    
    public MenuController(){
        theMenuView = new MenuView(this);
        theMenuView.setVisible(true);
        theMenuView.setLocationRelativeTo(null);
        
    }
    
    
    public void startGame(){
        theGameCntl = new GameController();
    }
}
