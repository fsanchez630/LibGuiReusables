/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * cala se abstracta que contiene las mayoria de la funcionalidad de sus clases derivadas
 * simple, PorFichas y Arbol
 * implementa interfaces para mahejo de eventos
 * implementa interface IValidable para validacion de datos
 * implementa interface IComunicable para comunicion entre componentes
 * @author Javi
 */
public abstract class LibFormularioExtensible extends LibFormulario implements ActionListener, ChangeListener, IComunicable, IValidable {

   

    /**
     * enumeracion con los tipos de Contenedor
     */
    public enum TipoContenedor {
        SIMPLE, PORFICHAS, ARBOL
    }

    // nombre del contenedor
    private String nombreContenedor;

    // lista de hijos
    private ArrayList<LibFormularioExtensible> hijosExtensibles = new ArrayList<>();

    // lista de observadores de eventos
    private LibListaObservadoresEventos listaObservadores;
    
    /**
     * constructor por defecto crea el panel de botones Aceptar y Cancelar
     */
    public LibFormularioExtensible() {
        initComponents();
        this.panelBotones = new LibPanelBotones();
        panelBotones.nuevoActionListener(this);
    }
    
    /**
     * obtener el nombre del contenedor
     * @return
     */
    public String getnombreContenedor() {
        return nombreContenedor;
    }

    /**
     * poner el nobre del contenedor
     * @param nombre
     */
    public void setnombreContenedor(String nombre) {
        nombreContenedor = nombre;
        this.setTitle(nombreContenedor);
    }


    /** obtener la lista de observadores
     * @return listaObservadores
     */
    public LibListaObservadoresEventos getListaObservadores() {
        return listaObservadores;
    }

    /** poner la lista de observadores
     * @param listaObservadores the listaObservadores to set
     */
    public void setListaObservadores(LibListaObservadoresEventos listaObservadores) {
        this.listaObservadores = listaObservadores;
    }
    
    /**
     * configurar el formulario
     * @return Boolean
     */
    public Boolean configurarFormulario() {

        addPanelBotones();
        this.setLocationRelativeTo(null);
        return true;
    }

    /**
     * incluye un nuevo hijo 
     * @param hijo
     * @param titulo
     * @throws java.lang.Exception cuando se supera el maximo de hijos = 2 ,en Formulario Simple
     */
    public void addHijoExtensible(LibFormularioExtensible hijo, String titulo) throws Exception {

        if (this instanceof LibFormularioSimple) {

            if ((hijosExtensibles.size() + 1) > LibFormularioSimple.MAXHIJOS) {
                Exception err = new Exception("maximos de hijos alcanzado");
                throw err;
            }
            hijo.nombreContenedor = titulo;
            hijosExtensibles.add(hijo);

            javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
            JPanel panelHijo = (JPanel) hijo.getContentPane();
            // panelHijo.setLayout(null);

            panelHijo.setBorder(blackline);

            LibFormularioSimple padreSimple = (LibFormularioSimple) this;
            JPanel panelPrincipal = (JPanel) padreSimple.obtenerValor("panelPrincipal");

            panelPrincipal.setLayout((new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS)));
            panelPrincipal.add(panelHijo, BorderLayout.CENTER);
        }

        if (this instanceof LibFormularioPorFichas) {
            hijo.nombreContenedor = titulo;
            hijosExtensibles.add(hijo);

            javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
            JPanel panelHijo = (JPanel) hijo.getContentPane();
            // panelHijo.setLayout(null);

            panelHijo.setBorder(blackline);

            LibFormularioPorFichas padrePorFichas = (LibFormularioPorFichas) this;

            JTabbedPane panelPorFichas = (JTabbedPane) padrePorFichas.obtenerValor("panelPorFichas");
            panelPorFichas.addTab(titulo, panelHijo);

        }

    }

    /**
     * inclye los hijos de una lista
     * @param listaHijos
     * @param titulo
     * @throws java.lang.Exception cuando se supera el maximo de hijos = 2 ,en Formulario Simple
     */
    public void addListaHijosExtensibles(ArrayList<LibFormularioExtensible> listaHijos, String titulo) throws Exception {
        if (titulo.isEmpty() || titulo.equals(nombreContenedor)) {
        } else {
            nombreContenedor = titulo;
        }

        if (this instanceof LibFormularioSimple) {
            for (LibFormularioExtensible hijo : listaHijos) {

                if ((hijosExtensibles.size() + 1) > LibFormularioSimple.MAXHIJOS) {
                    Exception err = new Exception("maximos de hijos alcanzado");

                    throw err;
                }

                hijosExtensibles.add(hijo);

                javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
                JPanel panelHijo = (JPanel) hijo.getContentPane();
                // panelHijo.setLayout(null);

                panelHijo.setBorder(blackline);

                LibFormularioSimple padreSimple = (LibFormularioSimple) this;

                JPanel panelPrincipal = (JPanel) padreSimple.obtenerValor("panelPrincipal");

                panelPrincipal.setLayout((new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS)));
                panelPrincipal.add(panelHijo, BorderLayout.CENTER);
            }

        }

        if (this instanceof LibFormularioPorFichas) {
            LibFormularioPorFichas padrePorFichas = (LibFormularioPorFichas) this;
            JPanel panelCombinado = new JPanel();
            panelCombinado.setLayout((new BoxLayout(panelCombinado, BoxLayout.Y_AXIS)));

            for (LibFormularioExtensible hijo : listaHijos) {
                hijosExtensibles.add(hijo);

                javax.swing.border.Border blackline = BorderFactory.createLineBorder(Color.black);
                JPanel panelHijo = (JPanel) hijo.getContentPane();
                // panelHijo.setLayout(null);

                panelHijo.setBorder(blackline);
                panelCombinado.add(panelHijo);

            }
            JTabbedPane panelPorFichas = (JTabbedPane) padrePorFichas.obtenerValor("panelPorFichas");
            panelPorFichas.addTab(titulo, panelCombinado);

        }

    }

     /**
     * metodos de la Interface Ivalidable
     */

    @Override
    public void aceptar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     /**
     * metodos de la Interface IComunicable
     */
    
    @Override
    public void cambiarValor(String nombreComponente, Object valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recuperarValorExterno(String nombreComponente, Object valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param nombreComponente the value of nombreComponente
     * @return the Object
     */
    @Override
    public Object obtenerValor(String nombreComponente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    private LibPanelBotones panelBotones;

    private void addPanelBotones() {

        this.getContentPane().add(panelBotones, BorderLayout.PAGE_END);
    }

}
