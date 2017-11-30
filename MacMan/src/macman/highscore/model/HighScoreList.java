/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.highscore.model;

import externaldata.controller.ExternalDataController;
import java.io.Serializable;

/**
 *
 * @author Michael Kramer
 */
public class HighScoreList implements Serializable {
    private static final int NUMBER_OF_HIGHSCORE = 10;
    private Score[] theHighScoreArray;
    
    public HighScoreList() {
        theHighScoreArray = new Score[NUMBER_OF_HIGHSCORE];
        fillWithTestScores();
    }
    
    public void addScore(Score scoreToAdd) {
        Score[] clone = theHighScoreArray.clone();
        for(int i = 0; i < theHighScoreArray.length; i++) {
            if(theHighScoreArray[i].getScore() < scoreToAdd.getScore()) {
                //System.out.println("This is a valid high Score");
                theHighScoreArray[i] = scoreToAdd;
                i++;
                while(i < theHighScoreArray.length) {
                    theHighScoreArray[i] = clone[i - 1];
                    i++;
                }
                ExternalDataController.save();
            }
        }
    }
    
    private void fillWithTestScores() {
        for(int i = 0; i < theHighScoreArray.length; i++) {
            //System.out.println(i);
            theHighScoreArray[i] = new Score("AAA", theHighScoreArray.length - i);
            //System.out.println(theHighScoreArray[i].toString());
        }
    }
    
    public int size() {
        return theHighScoreArray.length;
    }
    
    public Score getScore(int index) {
        return theHighScoreArray[index];
    }
    
    private void printScores() {
        for(int i = 0; i < theHighScoreArray.length; i++) {
            System.out.println(theHighScoreArray[i]);
        }
    }
    
    // This is just some simple code that i was using as a test harness 
    public static void main(String[] args) {
        HighScoreList test = new HighScoreList();
        test.printScores();
        test.addScore(new Score("Test", 50));
        test.addScore(new Score("Test", 49));
        test.addScore(new Score("Test", 51));
        test.printScores();
    }
}
