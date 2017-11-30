/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.highscore.ui;

import externaldata.controller.ExternalDataController;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import macman.highscore.model.Score;

/**
 *
 * @author Michael Kramer
 */
public class EnterUsernameUI extends JFrame {
    private int score;
    private JTextField usernameField;
    
    public EnterUsernameUI(int score) {
        this.score = score;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setUndecorated(true);
        this.setSize(500, 100);
        addComponents();
    }
    
    private void addComponents() {
        usernameField = new JTextField("Enter Username");
        add(usernameField,  BorderLayout.CENTER);
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener((ActionEvent ae) -> {
            ExternalDataController.getInstance().getExternalData().getHighScoreList().addScore(new Score(usernameField.getText(), score));
            this.dispose();
        });
        add(submitBtn, BorderLayout.SOUTH);
    }
}
