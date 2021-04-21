/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Javi
 */
public class FormularioArbol extends FormularioExtensible implements ActionListener, ChangeListener, TreeSelectionListener, Comunicable, Validable {

    private JPanel panelPrincipal;
    private JScrollPane panelScroll;
    private JTree arbol;
    private DefaultMutableTreeNode raiz;

    private String nombreArbol;

    /**
     * @return the nombreArbol
     */
    public String getNombreArbol() {
        return nombreArbol;
    }

    /**
     * @param nombreArbol the nombreArbol to set
     */
    public void setNombreArbol(String nombreArbol) {
        this.nombreArbol = nombreArbol;
    }

    /**
     * Constructor por defecto crea el panel principal
     */
    public FormularioArbol() {
        initComponents();
        panelPrincipal = new JPanel();
        panelScroll = new JScrollPane();

        raiz = null;

        /*
        raiz = new DefaultMutableTreeNode("Raiz");
        arbol = new JTree(raiz);
        arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
         */
    }

    private class InfoNodo {

        public String nombreNodo;
        public FormularioExtensible formularioNodo;

        public InfoNodo(String nombre, FormularioExtensible formulario) {
            nombreNodo = nombre;
            formularioNodo = formulario;

        }

        public String toString() {
            return nombreNodo;
        }
    }

    @Override
    public Boolean configurarFormulario() {

        if (super.configurarFormulario()) {

            if (raiz == null) {
                return false;
            } else {

                arbol = new JTree(raiz);
                arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
                arbol.addTreeSelectionListener(this);

                this.setNombreArbol("Dialogos");
                panelScroll.setBorder(BorderFactory.createTitledBorder(this.getNombreArbol()));
                panelScroll.setMinimumSize(new Dimension(200, 322));
                panelScroll.setPreferredSize(new Dimension(200, 322));
                this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
                panelScroll.setViewportView(arbol);

                this.getContentPane().add(panelScroll, java.awt.BorderLayout.WEST);

                InfoNodo nodoraiz;
                nodoraiz = (InfoNodo) raiz.getUserObject();

                if (nodoraiz.formularioNodo != null) {

                    panelPrincipal.removeAll();
                    JPanel panelHijo = (JPanel) nodoraiz.formularioNodo.getContentPane();
                    panelPrincipal.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
                    panelPrincipal.add(panelHijo, BorderLayout.CENTER);

                }

            }

            pack();

            //  this.setSize(500, 400);
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
     * @param hijo
     * @param titulo
     */
    @Override
    public void addHijoExtensible(FormularioExtensible hijo, String titulo) {

        hijo.setnombreContenedor(titulo);

        // System.out.println(hijo);
        getHijosExtensibles().add((FormularioExtensible) hijo.clone());

        if (raiz == null) {
            raiz = new DefaultMutableTreeNode(new InfoNodo(titulo, hijo));
        } else {
            raiz.add(new DefaultMutableTreeNode(new InfoNodo(titulo, hijo)));
        }

        // panelHijo.setLayout(null);
        //LibFormularioArbol padreArbol = (FormularioArbol) this;
        // JPanel panelPrincipal = (JPanel) padreArbol.obtenerValor("panelPrincipal");
        //  panelPrincipal.setLayout(new GridLayout(0, 1));
        if (1 == 0) {
            JPanel panelHijo = (JPanel) hijo.getContentPane();
            panelPrincipal.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            panelPrincipal.add(panelHijo, BorderLayout.CENTER);
        }

    }

    /**
     * inclye los hijos de una lista
     *
     * @param listaHijos
     * @param titulo
     * @throws java.lang.Exception cuando se supera el maximo de hijos = 2 ,en
     * Formulario Simple
     */
    @Override
    public void addListaHijosExtensibles(ArrayList<FormularioExtensible> listaHijos, String titulo) throws Exception {

        //DefaultMutableTreeNode nodopadre = new DefaultMutableTreeNode(titulo);
        DefaultMutableTreeNode nodopadre;
        nodopadre = new DefaultMutableTreeNode((new InfoNodo(titulo, null)));

        if (raiz == null) {
            raiz = nodopadre;
        } else {
            raiz.add(nodopadre);
        }

        for (FormularioExtensible hijo : listaHijos) {

            getHijosExtensibles().add((FormularioExtensible) hijo.clone());

            nodopadre.add(new DefaultMutableTreeNode(new InfoNodo(hijo.getnombreContenedor(), hijo)));

            if (1 == 0) {
                JPanel panelHijo = (JPanel) hijo.getContentPane();
                panelPrincipal.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
                panelPrincipal.add(panelHijo, BorderLayout.CENTER);
            }
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
     * metodos de la Interface Comunicable
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

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        System.out.println("selecion nodo");
        DefaultMutableTreeNode node;

        node = (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();

        InfoNodo nodosel;
        nodosel = (InfoNodo) node.getUserObject();

        if (nodosel.formularioNodo != null) {

            panelPrincipal.removeAll();
            JPanel panelHijo = (JPanel) nodosel.formularioNodo.getContentPane();
            panelPrincipal.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            panelPrincipal.add(panelHijo, BorderLayout.CENTER);
            revalidate();
            repaint();

        }

        //  VISULIZAR NODO SELECCIONADO
    }

}
