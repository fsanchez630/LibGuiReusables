/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Javi
 */
public class LibFormularioArbol extends LibFormularioExtensible implements ActionListener, ChangeListener, IComunicable, IValidable {

    private JPanel panelPrincipal;
    private JScrollPane panelScroll;
    private JTree arbol;

    /**
     * Constructor por defecto crea el panel principal
     */
    public LibFormularioArbol() {
        initComponents();
        panelPrincipal = new JPanel();
        panelScroll = new javax.swing.JScrollPane();
        arbol = new javax.swing.JTree();

        panelScroll.setMinimumSize(new java.awt.Dimension(200, 322));
        panelScroll.setPreferredSize(new java.awt.Dimension(200, 322));
        this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        panelScroll.setViewportView(arbol);
        this.getContentPane().add(panelScroll, java.awt.BorderLayout.WEST);
        // this.setContentPane(panelPrincipal);

    }

    @Override
    public Boolean configurarFormulario() {

        if (super.configurarFormulario()) {

            pack();
            //Set up the content pane.

            //  this.setSize(500, 400);
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
    /**
     * metodos de la Interface IComunicable
     */
    @Override
    public void cambiarValor(String nombreComponente, Object valor) {
        System.out.println("cambiar valor");
        if ("panelPrincipal".equals(nombreComponente)) {
            panelPrincipal = (JPanel) valor;
            //this.setContentPane(panelPrincipal);
        }

    }

    @Override
    public Object obtenerValor(String nombreComponente) {
        System.out.println("obtener valor");
        Object retorno = null;
        if ("panelPrincipal".equals(nombreComponente)) {
            retorno = panelPrincipal;
        }

        return retorno;
    }

    @Override
    public void recuperarValorExterno(String nombreComponente, Object valor) {
        System.out.println("recuperar valor");
    }

    /**
     * metodos de gestion de eventos
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Botón pulsado: " + evt.getActionCommand());

    }

    @Override
    public void stateChanged(ChangeEvent evt) {
        System.out.println("evento cambio");
    }

}
