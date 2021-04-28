/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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
    private DefaultMutableTreeNode nodoRaiz;
    private String nombreArbol;
    static final Integer ANCHURA_ARBOL = 250;

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

        //nodoRaiz = null;   
        InfoNodo infoNodoRaiz;
        infoNodoRaiz = new InfoNodo("Raiz", null);
        nodoRaiz = new DefaultMutableTreeNode(infoNodoRaiz);

        /*
        nodoRaiz = new DefaultMutableTreeNode("Raiz");
        arbol = new JTree(nodoRaiz);
        arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
         */
    }

    @Override
    public Boolean configurarFormulario() {

        if (super.configurarFormulario()) {

            arbol = new JTree(nodoRaiz);
            arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            arbol.setRootVisible(false);
            arbol.addTreeSelectionListener(this);

            this.setNombreArbol("Dialogos");
            panelScroll.setBorder(BorderFactory.createTitledBorder(this.getNombreArbol()));
            panelScroll.setMinimumSize(new Dimension(ANCHURA_ARBOL, this.getMinAltura()));
            panelScroll.setPreferredSize(new Dimension(ANCHURA_ARBOL, this.getMinAltura()));

            this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);

            panelScroll.setViewportView(arbol);

            this.getContentPane().add(panelScroll, java.awt.BorderLayout.WEST);

            Dimension minimumSize = new Dimension();
            minimumSize.setSize(getMinAnchura() + ANCHURA_ARBOL, getMinAltura());
            this.setMinimumSize(minimumSize);
            this.setPreferredSize(minimumSize);

            this.setSize(getMinAnchura() + ANCHURA_ARBOL, getMinAltura());

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
     * clase para representar los nodos del Arbol de Formularios Extensibles
     */
    private class InfoNodo {

        public String nombreNodo;
        public FormularioExtensible formularioNodo;

        public InfoNodo(String nombre, FormularioExtensible formulario) {
            nombreNodo = nombre;
            formularioNodo = formulario;

        }

        @Override
        public String toString() {
            return nombreNodo;
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
        DefaultMutableTreeNode nodo;
        InfoNodo infoNodo;

        hijo.setnombreContenedor(titulo);

        if (this.getMinAnchura() < hijo.getMinAnchura()) {
            this.setMinAnchura(hijo.getMinAnchura());
        }

        if (this.getMinAltura() < hijo.getMinAltura()) {
            this.setMinAltura(hijo.getMinAltura());
        }

        getHijosExtensibles().add((FormularioExtensible) hijo.clone());

        infoNodo = new InfoNodo(titulo, hijo);
        nodo = new DefaultMutableTreeNode(infoNodo);

        crearArbol(nodo);

        nodoRaiz.add(nodo);

    }

    /**
     * inclye los hijos de una lista
     *
     * @param listaHijos
     * @param titulo
     *
     */
    @Override
    public void addListaHijosExtensibles(ArrayList<FormularioExtensible> listaHijos, String titulo) {

        DefaultMutableTreeNode nodoPadre;
        InfoNodo infoNodoPadre;

        infoNodoPadre = new InfoNodo(titulo, null);
        nodoPadre = new DefaultMutableTreeNode(infoNodoPadre);

        DefaultMutableTreeNode nodoHijo;
        InfoNodo infoNodoHijo;

        for (FormularioExtensible hijo : listaHijos) {

            if (this.getMinAnchura() < hijo.getMinAnchura()) {
                this.setMinAnchura(hijo.getMinAnchura());
            }

            if (this.getMinAltura() < hijo.getMinAltura()) {
                this.setMinAltura(hijo.getMinAltura());
            }

            getHijosExtensibles().add((FormularioExtensible) hijo.clone());

            infoNodoHijo = new InfoNodo(hijo.getnombreContenedor(), hijo);

            nodoHijo = new DefaultMutableTreeNode(infoNodoHijo);

            crearArbol(nodoHijo);

            nodoPadre.add(nodoHijo);

        }

        nodoRaiz.add(nodoPadre);

    }

    /**
     *
     * @param nodoPadre crea la estrucutura de arbol para un nodo
     */
    public void crearArbol(DefaultMutableTreeNode nodoPadre) {

        InfoNodo infoNodoPadre;
        infoNodoPadre = (InfoNodo) nodoPadre.getUserObject();
        InfoNodo infoNodoHijo;
        DefaultMutableTreeNode nodoHijo;

        if (infoNodoPadre.formularioNodo != null) {

            // recorrer los hijos
            for (int x = 0; x < infoNodoPadre.formularioNodo.getHijosExtensibles().size(); x++) {
                FormularioExtensible hijo = (FormularioExtensible) infoNodoPadre.formularioNodo.getHijosExtensibles().get(x);
                // if (hijo.getHijosExtensibles().size() > 0) {
                infoNodoHijo = new InfoNodo(hijo.getnombreContenedor(), hijo);
                nodoHijo = new DefaultMutableTreeNode(infoNodoHijo);
                nodoPadre.add(nodoHijo);  // agregar nodo hijo
                crearArbol(nodoHijo); // crear arbol del hijo
                //}

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
     *
     * @param evt
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

        InfoNodo infoNodosel;
        infoNodosel = (InfoNodo) node.getUserObject();

        if (infoNodosel.formularioNodo != null) {

            // if (1 == 0) {
            panelPrincipal.removeAll();
            JPanel panelHijo = (JPanel) infoNodosel.formularioNodo.getContentPane();

            panelPrincipal.setLayout(new GridLayout(0, 1));
            panelPrincipal.add(panelHijo, BorderLayout.CENTER);
            //}

            revalidate();
            repaint();

        }

        //  VISULIZAR NODO SELECCIONADO
    }

}
