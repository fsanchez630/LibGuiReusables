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
public class LibFormularioArbol extends LibFormularioExtensible implements ActionListener, ChangeListener, TreeSelectionListener, IComunicable, IValidable {

    private JPanel panelPrincipal;
    private JScrollPane panelScroll;
    private JTree arbol;
    private DefaultMutableTreeNode raiz;

    /**
     * Constructor por defecto crea el panel principal
     */
    public LibFormularioArbol() {
        initComponents();
        panelPrincipal = new JPanel();
        panelScroll = new JScrollPane();

        //Create the nodes.
        raiz = new DefaultMutableTreeNode("Raiz");
        arbol = new JTree(raiz);
        arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        // incluir categoria y nodo hijo
        crearNodo();

        panelScroll.setBorder(BorderFactory.createTitledBorder("Dialogos"));
        panelScroll.setMinimumSize(new Dimension(200, 322));
        panelScroll.setPreferredSize(new Dimension(200, 322));
        this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        panelScroll.setViewportView(arbol);

        this.getContentPane().add(panelScroll, java.awt.BorderLayout.WEST);
        // this.setContentPane(panelPrincipal);

    }

    private class InfoNodo {

        public String nombreNodo;
        public LibFormularioExtensible formularioNodo;

        public InfoNodo(String nombre, LibFormularioExtensible formulario) {
            nombreNodo = nombre;
            formularioNodo = formulario;

        }

        public String toString() {
            return nombreNodo;
        }
    }

    private void crearNodo() {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode nodo = null;

        category = new DefaultMutableTreeNode("nueva categoria");
        raiz.add(category);

        nodo = new DefaultMutableTreeNode(new InfoNodo("nodo hijo",
                this));
        category.add(nodo);

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
     * incluye un nuevo hijo
     *
     * @param hijo
     * @param titulo
     */
    @Override
    public void addHijoExtensible(LibFormularioExtensible hijo, String titulo)  {
                      
           hijo.setnombreContenedor(titulo);
            
            // System.out.println(hijo);
            getHijosExtensibles().add((LibFormularioExtensible) hijo.clone());

            JPanel panelHijo = (JPanel) hijo.getContentPane();
            // panelHijo.setLayout(null);

            //LibFormularioArbol padreArbol = (LibFormularioArbol) this;

           // JPanel panelPrincipal = (JPanel) padreArbol.obtenerValor("panelPrincipal");

            //  panelPrincipal.setLayout(new GridLayout(0, 1));
            panelPrincipal.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
            panelPrincipal.add(panelHijo, BorderLayout.CENTER);        

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
    public void addListaHijosExtensibles(ArrayList<LibFormularioExtensible> listaHijos, String titulo) throws Exception {
        if (titulo.isEmpty() || titulo.equals(this.getnombreContenedor())) {
        } else {
            setnombreContenedor ( titulo);
        }               
        
            for (LibFormularioExtensible hijo : listaHijos) {                

                getHijosExtensibles().add((LibFormularioExtensible) hijo.clone());

                JPanel panelHijo = (JPanel) hijo.getContentPane();
                // panelHijo.setLayout(null);

             //   LibFormularioArbol padreArbol = (LibFormularioArbol) this;

             //   JPanel panelPrincipal = (JPanel) padreArbol.obtenerValor("panelPrincipal");

                //panelPrincipal.setLayout((new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS)));
                //panelPrincipal.setLayout(new GridLayout(0, 1));
                panelPrincipal.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
                panelPrincipal.add(panelHijo, BorderLayout.CENTER);
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

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
