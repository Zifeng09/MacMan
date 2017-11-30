/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externaldata.model;

import java.io.Serializable;
import macman.highscore.model.HighScoreList;

/**
 *
 * @author mpk5206
 */
public class ExternalData implements Serializable {
    private HighScoreList theHighScoreList;
    
    public ExternalData () {
        this.theHighScoreList = new HighScoreList();
    }
    
    public HighScoreList getHighScoreList() {
        return this.theHighScoreList;
    }
}
