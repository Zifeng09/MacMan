/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macman.instruction.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import macman.mainmenu.MenuController;

/**
 *
 * @author mpk5206
 */
public class InstructionUI extends JFrame {
    private MenuController parentCntl;
    
    public InstructionUI(MenuController parentCntl) {
        this.parentCntl = parentCntl;
        addComponents();
        this.setSize(300, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLUE);
        this.setVisible(true);
    }
    
    private void addComponents() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("BackButton Click Event Registered");
            parentCntl.displayMenu();
        });
        this.add(backButton);
        
    }
}
