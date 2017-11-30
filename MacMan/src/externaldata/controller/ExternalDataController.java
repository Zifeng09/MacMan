/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externaldata.controller;

import externaldata.model.ExternalData;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mpk5206
 */
public class ExternalDataController {
    private static final String FILEPATH = "Data.ser";
    private ExternalData externalData;
    
    public static ExternalDataController getInstance() {
        return LazyHolder.getInstance();
    }
    
    public ExternalData getExternalData() {
        return externalData;
    }
    
    public static void save() {
        LazyHolder.getInstance().writeExternalData();
    }
    
    private ExternalDataController() {
        readExternalData();
        if(this.externalData == null) {
            System.out.println("Creating new ExternalData");
            this.externalData = new ExternalData();
            writeExternalData();
            readExternalData();
        }
    }
    
    private void readExternalData() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream( 
                    new BufferedInputStream(new FileInputStream(FILEPATH)));
            this.externalData = (ExternalData) in.readObject();
        } catch (IOException ex) {
            System.err.println("Error readin tye data ser file");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found Exception will reading Ser file");
        }              
    }
    
    private void writeExternalData() {
        if(this.externalData == null) {
            System.err.println("External Data was null for some reason");;
        }
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(FILEPATH));
            out.writeObject(externalData);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExternalDataController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExternalDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private static class LazyHolder {
        static final ExternalDataController INSTANCE = new ExternalDataController();
         
        static ExternalDataController getInstance() {
            return INSTANCE;
        }
    }
}
