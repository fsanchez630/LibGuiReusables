/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;
/**
 *
 * @author Javi
 */

public abstract class LibFormulario extends JFrame implements IValidable,IComunicable , ActionListener, ChangeListener{

    private JFrame extension;
       
    /**
     *
     * @param frame
     */
    public void setExtension (JFrame frame){
    
        extension = frame;
    }
    
    /**
     *
     * @return extension
     */
    public  JFrame getExtension (){
    
        return extension ;
    }


    
    
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
