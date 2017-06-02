/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.greenie99.pentameter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.File;   
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Greenie
 * @github techtide
 */

public class Handler {
    public static void main(String[] args) {
        JButton open = new JButton();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setDialogTitle("Select a Poem");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(fileChooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
            
        }
        File selectedFile = fileChooser.getSelectedFile();
        try {
            Sonnet sonnetPoem = new Sonnet(selectedFile, Sonnet.SonnetStyle.ITALIAN);
            System.out.println(sonnetPoem.getFullText());
        } catch (IOException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
