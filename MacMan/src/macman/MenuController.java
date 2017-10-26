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
    
    public MenuController(){
        this.theMenuView = new MenuView(this);
    }
}
