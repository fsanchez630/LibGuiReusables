/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import java.awt.event.ActionEvent;

/**
 *
 * @author Javi
 */
public class LibFormularioSimple extends LibFormularioExtensible {

    /**
     *
     */
    public LibFormularioSimple() {
        initComponents();
    }

    @Override
    public Boolean configurarFormulario() {

        if (super.configurarFormulario()) {

            pack();
            //Set up the content pane.
            
            this.setSize(400, 300);
            //this.setResizable(false);

            //this.setExtendedState(MAXIMIZED_BOTH);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
 
    @Override
    public void aceptar() {
        System.out.println("has pulsado aceptar");
    }

    @Override
    public void cancelar() {
        System.out.println("has pulsado rechazar");
    }

       @Override
    public void cambiarValor(String nombreComponente, Object valor) {
        System.out.println("cambiar valor");
    }

    @Override
    public void recuperarValorExterno(String nombreComponente, Object valor) {
        System.out.println("recuperar valor");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         System.out.println("evento Accion");
    }

    

}
