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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 * Formulario de tipo Arbol
 * @author Francisco Javier Sánchez Lozano
 */
public class FormularioArbol extends FormularioExtensible implements Comunicable, Validable, Observador {

    private JPanel panelPrincipal;
    private JScrollPane panelScroll;
    private JTree arbol;
    private DefaultMutableTreeNode nodoRaiz;
    private String nombreArbol;
    private static final Integer ANCHURA_ARBOL = 250;
    private static final Boolean INTEGRAR_ARBOL = false;

       /**
     * clase para representar los nodos del Arbol de Formularios Extensibles
     */
    private class InfoNodo {

        private String nombreNodo;
        private FormularioExtensible formularioNodo;

        protected InfoNodo(String nombre, FormularioExtensible formulario) {
            nombreNodo = nombre;
            formularioNodo = formulario;

        }

        /**
         * @return the nombreNodo
         */
        protected String getNombreNodo() {
            return nombreNodo;
        }

        /**
         * @param nombreNodo nombre del nodo
         */
        protected void setNombreNodo(String nombreNodo) {
            this.nombreNodo = nombreNodo;
        }

        /**
         * @return  formularioNodo
         */
        protected FormularioExtensible getFormularioNodo() {
            return formularioNodo;
        }

        /**
         * @param formularioNodo formulario nodo a asignar
         */
        protected void setFormularioNodo(FormularioExtensible formularioNodo) {
            this.formularioNodo = formularioNodo;
        }

        @Override
        public String toString() {
            return getNombreNodo();
        }
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
        arbol = new JTree();
        arbol.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {

                EventoSelNodo evtSelNod = new EventoSelNodo(e.getSource());
                getGestorEventos().notificarEvento("SelNod", evtSelNod);

            }
        });
    }

    @Override
    public Boolean configurarFormulario() {

        if (super.configurarFormulario()) {

            arbol = new JTree(getNodoRaiz());
            arbol.addTreeSelectionListener(new TreeSelectionListener() {
                @Override
                public void valueChanged(TreeSelectionEvent e) {

                    EventoSelNodo evtSelNod = new EventoSelNodo(arbol);
                    getGestorEventos().notificarEvento("SelNodo", evtSelNod);

                }
            });
            arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            // arbol.setRootVisible(false);

            this.setNombreArbol("Dialogos");
            panelScroll.setBorder(BorderFactory.createTitledBorder(this.getNombreArbol()));
            panelScroll.setMinimumSize(new Dimension(ANCHURA_ARBOL, this.getMinAltura()));
            panelScroll.setPreferredSize(new Dimension(ANCHURA_ARBOL, this.getMinAltura()));

            this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);

            panelScroll.setViewportView(arbol);

            this.getContentPane().add(panelScroll, java.awt.BorderLayout.WEST);

            Dimension minimumSize = new Dimension();
            minimumSize.setSize(this.getMinAnchura() + ANCHURA_ARBOL, this.getMinAltura() + 50);
            this.setMinimumSize(minimumSize);
            this.setPreferredSize(minimumSize);

            this.setSize(this.getMinAnchura() + ANCHURA_ARBOL, this.getMinAltura() + 50);
            this.setLocation(500, 0);
            if (nodoRaiz != null) {

                InfoNodo infoNodosel;
                infoNodosel = (InfoNodo) nodoRaiz.getUserObject();

                if (infoNodosel != null) {

                    if (infoNodosel.getFormularioNodo() != null) {

                        // if (1 == 0) {
                        panelPrincipal.removeAll();
                        JPanel panelHijo = (JPanel) infoNodosel.getFormularioNodo().getContentPane();

                        panelPrincipal.setLayout(new GridLayout(0, 1));
                        panelPrincipal.add(panelHijo, BorderLayout.CENTER);
                        //}

                        revalidate();
                        repaint();

                    }
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
     * @param hijo Formulario Hijp  que se agrega
     * @param titulo titulo del Formulario
     */
    @Override
    public void addHijoExtensible(FormularioExtensible hijo, String titulo) {
        DefaultMutableTreeNode nodo;
        InfoNodo infoNodo;

        hijo.setFormularioPadre(this);
        hijo.setMinAltura(hijo.getHeight());
        hijo.setMinAnchura(hijo.getWidth());
        hijo.setnombreContenedor(titulo);

        if (this.getMinAnchura() < hijo.getMinAnchura()) {
            this.setMinAnchura(hijo.getMinAnchura());
        }

        if (this.getMinAltura() < hijo.getMinAltura()) {
            this.setMinAltura(hijo.getMinAltura());
        }

        if ((hijo instanceof FormularioArbol) && (INTEGRAR_ARBOL)) {
            FormularioArbol hijoArbol = (FormularioArbol) hijo;

            nodo = hijoArbol.getNodoRaiz();
            infoNodo = (InfoNodo) nodo.getUserObject();
            infoNodo.setNombreNodo(titulo);

        } else {
            infoNodo = new InfoNodo(titulo, hijo);
            nodo = new DefaultMutableTreeNode(infoNodo);

        }

        if (this.getHijosExtensibles().isEmpty()) {
            this.setNodoRaiz(nodo);
        } else {
            this.getNodoRaiz().add(nodo);
        }

        this.getHijosExtensibles().add((FormularioExtensible) hijo);

    }

    /**
     * inclye los hijos de una lista
     *
     * @param listaHijos lista de Hijos que se agrega
     * @param titulo titulo del Formulario
     *
     */
    @Override
    public void addListaHijosExtensibles(ArrayList<FormularioExtensible> listaHijos, String titulo) {

        DefaultMutableTreeNode nodo;
        InfoNodo infoNodo;

        // recorrer lista de hijos
        for (int x = 0; x < listaHijos.size(); x++) {
            FormularioExtensible hijo = (FormularioExtensible) listaHijos.get(x);

            if (x == 0) { // primer elemento
                hijo.setnombreContenedor(titulo);
            }
            hijo.setFormularioPadre(this);
            hijo.setMinAltura(hijo.getHeight());
            hijo.setMinAnchura(hijo.getWidth());

            if (this.getMinAnchura() < hijo.getMinAnchura()) {
                this.setMinAnchura(hijo.getMinAnchura());
            }

            if (this.getMinAltura() < hijo.getMinAltura()) {
                this.setMinAltura(hijo.getMinAltura());
            }

            if ((hijo instanceof FormularioArbol) && (INTEGRAR_ARBOL)) {
                FormularioArbol hijoArbol = (FormularioArbol) hijo;

                nodo = hijoArbol.getNodoRaiz();
                infoNodo = (InfoNodo) nodo.getUserObject();
                infoNodo.setNombreNodo(hijo.getnombreContenedor());

            } else {
                infoNodo = new InfoNodo(hijo.getnombreContenedor(), hijo);
                nodo = new DefaultMutableTreeNode(infoNodo);

            }

            if (this.getHijosExtensibles().isEmpty()) {
                this.setNodoRaiz(nodo);
            } else {
                this.getNodoRaiz().add(nodo);
            }

            this.getHijosExtensibles().add((FormularioExtensible) hijo);

        }

    }

    
    
    
    
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
     * @param evt Evento Seleccion Nodo
     */
    @Override
    public void procesarEventoSelNodo(EventoSelNodo evt) {
        //System.out.println("selecion nodo");
        if (evt.getOrigen() == arbol) {

            DefaultMutableTreeNode node;

            node = (DefaultMutableTreeNode) arbol.getLastSelectedPathComponent();

            if (node != null) {

                InfoNodo infoNodosel;
                infoNodosel = (InfoNodo) node.getUserObject();

                if (infoNodosel != null) {

                    if (infoNodosel.getFormularioNodo() != null) {

                        // if (1 == 0) {
                        panelPrincipal.removeAll();
                        FormularioExtensible FormularioHijo = infoNodosel.getFormularioNodo();
                        FormularioHijo.setHayBotones(false); // sin botones
                        FormularioHijo.configurarFormulario();
                        JPanel panelHijo = (JPanel) FormularioHijo.getContentPane();

                        panelPrincipal.setLayout(new GridLayout(0, 1));
                        panelPrincipal.add(panelHijo, BorderLayout.CENTER);

                        panelPrincipal.revalidate();
                        panelPrincipal.repaint();

                        //}
                        // revalidate();
                        // repaint();
                    }
                }
            }
        }
        //  VISULIZAR NODO SELECCIONADO
    }

    
    
    
    
    
    /**
     * @return the nombreArbol
     */
    protected String getNombreArbol() {
        return nombreArbol;
    }

    /**
     * @param nombreArbol nombre del arbol a asignar
     */
    protected void setNombreArbol(String nombreArbol) {
        this.nombreArbol = nombreArbol;
    }

    /**
     * @return the nodoRaiz
     */
    protected DefaultMutableTreeNode getNodoRaiz() {
        return nodoRaiz;
    }

    /**
     * @param nodoRaiz nodo raiz a asignar
     */
    protected void setNodoRaiz(DefaultMutableTreeNode nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
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
