/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.highscore.ui;

import externaldata.controller.ExternalDataController;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import macman.highscore.model.HighScoreList;
import macman.mainmenu.MenuController;

/**
 *
 * @author mpk5206
 */
public class HighscoreUI extends JFrame {
    private MenuController parentCntl;
    private JTable highScoreTable;
    
    public HighscoreUI(MenuController parentCntl) {
        this.parentCntl = parentCntl;
        addComponents();
        this.setSize(300, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLUE);
        this.setVisible(true);
    }
    
    private void addComponents() {
        ExternalDataController dataController = ExternalDataController.getInstance();
        HighScoreList theScoreList = dataController.getExternalData().getHighScoreList();
        
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy  =0;
        JLabel usernameLbl = new JLabel("Username");
        add(usernameLbl, c);
        c.gridx = 1;
        c.gridy = 0;
        JLabel scoreLbl = new JLabel("Score");
        
        add(scoreLbl, c);
        for(int i = 1; i < theScoreList.size() + 1; i++) {
            c.gridy++;
            c.gridx = 0;
            JLabel scoreUsername = new JLabel(theScoreList.getScore(i - 1).getUsername());
            add(scoreUsername, c);
            c.gridx =1;
            JLabel scoreScore = new JLabel(String.valueOf(theScoreList.getScore(i - 1).getScore()));
            add(scoreScore, c);
        }
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("BackButton Click Event Registered");
            parentCntl.displayMenu();
        });
        c.gridx  = 0 ;
        c.gridy++;
        c.gridwidth = 2;
        this.add(backButton, c);
        
    }
}
