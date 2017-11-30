/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.highscore.model;

import java.io.Serializable;

/**
 *
 * @author jxw5640
 */
public class Score implements Serializable {
    private int score;
    private String username;
    
    
    public Score(String username, int score) {
        this.username = username;
        this.score = score;
    }
    
    /**
     * @return the score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String toString() { 
        return (getUsername() + " " + getScore());
    }
}
