/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import LibGuiReusables.interfaces.Comunicable;
import LibGuiReusables.interfaces.Observador;
import LibGuiReusables.interfaces.Validable;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * clase derivada Formulario por Fichas
 *
 * @author Francisco Javier Sánchez Lozano
 */
public class FormularioPorFichas extends FormularioExtensible implements Comunicable, Validable, Observador {

    // panel primcipal 
    private JPanel panelPrincipal;
    // panel por fichas
    private JTabbedPane panelPorFichas;

    /**
     * Constructor por defecto crea el panel principal y el panel por fichas
     */
    public FormularioPorFichas() {
        initComponents();
        panelPrincipal = new JPanel();
        panelPorFichas = new JTabbedPane();
        //this.setContentPane(panelPrincipal);
        //this.getContentPane().add(panelPorFichas);
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(panelPorFichas);
        this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);

    }

    @Override
    public Boolean configurarFormulario() {

        if (super.configurarFormulario()) {

            pack();
            //Set up the content pane.

            // this.setSize(500, 400);
            //this.setResizable(false);
            //this.setExtendedState(MAXIMIZED_BOTH);
            return true;
        } else {
            return false;
        }
    }

    /**
     * incluye un nuevo hijo
     *
     * @param hijo Formulario hijo a agregar
     * @param titulo titulo del Formulario
     * @throws java.lang.Exception cuando se supera el maximo de hijos = 2 ,en
     * Formulario Simple
     */
    @Override
    public void addHijoExtensible(FormularioExtensible hijo, String titulo) throws Exception {
        hijo.setFormularioPadre(this);
        hijo.setMinAltura(hijo.getHeight());
        hijo.setMinAnchura(hijo.getWidth());
        hijo.setnombreContenedor(titulo);
        getHijosExtensibles().add((FormularioExtensible) hijo);

        JPanel panelHijo = (JPanel) hijo.getContentPane();

        panelPorFichas.addTab(titulo, panelHijo);

        if (this.getMinAnchura() < hijo.getMinAnchura()) {
            this.setMinAnchura(hijo.getMinAnchura());
        }

        if (this.getMinAltura() < hijo.getMinAltura()) {
            this.setMinAltura(hijo.getMinAltura());
        }

    }

    /**
     * incluye los hijos de una lista
     *
     * @param listaHijos lista de Formularios Hijos a agregar
     * @param titulo titulo del Formulario
     * @throws java.lang.Exception cuando se supera el maximo de hijos = 2 ,en
     * Formulario Simple
     */
    @Override
    public void addListaHijosExtensibles(ArrayList<FormularioExtensible> listaHijos, String titulo) throws Exception {
        if (titulo.isEmpty() || titulo.equals(getnombreContenedor())) {
        } else {
            setnombreContenedor(titulo);
        }

        JPanel panelCombinado = new JPanel();

        panelCombinado.setLayout((new GridLayout(0, 1)));

        for (FormularioExtensible hijo : listaHijos) {
            hijo.setFormularioPadre(this);
            hijo.setMinAltura(hijo.getHeight());
            hijo.setMinAnchura(hijo.getWidth());
            getHijosExtensibles().add((FormularioExtensible) hijo);

            JPanel panelHijo = (JPanel) hijo.getContentPane();

            panelCombinado.add(panelHijo);

            if (this.getMinAnchura() < hijo.getMinAnchura()) {
                this.setMinAnchura(hijo.getMinAnchura());
            }

            this.setMinAltura(this.getMinAltura() + hijo.getMinAltura());

        }

        panelPorFichas.addTab(titulo, panelCombinado);

    }

    /**
     * metodos de la Interface Comunicable
     */
    @Override
    public void cambiarValor(String nombreComponente, Object valor) {
        System.out.println("cambiar valor");
        if ("panelPrincipal".equals(nombreComponente)) {
            panelPrincipal = (JPanel) valor;
            //  this.setContentPane(panelPrincipal);
        }

        if ("panelPorFichas".equals(nombreComponente)) {
            panelPorFichas = (JTabbedPane) valor;
        }
    }

    @Override
    public void recuperarValorExterno(String nombreComponente, Object valor) {
        System.out.println("recuperar valor");
    }

    @Override
    public Object obtenerValor(String nombreComponente) {
        System.out.println("obtener valor");
        Object retorno = null;
        if ("panelPrincipal".equals(nombreComponente)) {
            retorno = panelPrincipal;
        }

        if ("panelPorFichas".equals(nombreComponente)) {
            retorno = panelPorFichas;
        }

        return retorno;
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
}
