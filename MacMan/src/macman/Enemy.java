/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman;

/**
 *
 * @author jxw5640
 */
import java.awt.Color;
import java.util.*;
import java.util.Random;

public class Enemy {
    Random rand = new Random();
    int xPos = rand.nextInt(17)+1;
    int yPos = rand.nextInt(17)+1;
    Score theScore;
    
    //idk
    public Enemy(int theScore){
        
    }
    
    public Enemy() {
        
    }
    
    public void move(int desiredX, int desiredY) {
        this.xPos = desiredX;
        this.yPos = desiredY;
    }
    
    public void moveLeft() {
        xPos--;
        if(xPos < 0){
            xPos = GameView.boardWidth - 1;
        }
    }
    
    public void moveRight() {
        xPos++;
        if(xPos > GameView.boardWidth - 1){
            xPos = 0;
        }
    }
    public void moveUp() {
        yPos--;
        if(yPos < 0) {
            yPos = GameView.boardHeight - 1;
        }
    }
    
    public void moveDown() {
        yPos++;
        if(yPos > GameView.boardHeight - 1) {
            yPos = 0;
        }
    }
}
