/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import javax.swing.JFrame;
/**
 * clase abstracta que es la clase base  de la libreria de formularios extensibles
 * @author Javi
 */

public abstract class Formulario extends JFrame  {

    protected JFrame formularioPadre;
       
    /**
     * establece Formulario padre (Jframe)
     * @param frame
     */
    protected void setFormularioPadre (JFrame frame){
    
        formularioPadre = frame;
    }
    
    /**
     * recupera la extension (Jframe)
     * @return extension
     */
    protected  JFrame getFormularioPadre (){
    
        return formularioPadre ;
    }


    
    
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
