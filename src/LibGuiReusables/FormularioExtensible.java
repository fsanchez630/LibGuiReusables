/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * clase abstracta que contiene las mayoria de la funcionalidad de sus clases
 derivadas simple, PorFichas y Arbol implementa interfaces para mahejo de
 eventos implementa interface Validable para validacion de datos implementa
 interface Comunicable para comunicion entre componentes
 *
 * @author Javi
 */
public abstract class FormularioExtensible extends Formulario implements ActionListener, ChangeListener, Comunicable, Validable, Cloneable {

    /**
     * enumeracion con los tipos de Contenedor
     */
    public enum TipoContenedor {
        SIMPLE, PORFICHAS, ARBOL
    }

    // nombre del contenedor
    private String nombreContenedor;

    /**
     * obtener el nombre del contenedor
     *
     * @return nombreContenedor
     */
    public String getnombreContenedor() {
        return nombreContenedor;
    }

    /**
     * poner el nobre del contenedor
     *
     * @param nombre
     */
    public void setnombreContenedor(String nombre) {
        nombreContenedor = nombre;
        this.setTitle(nombreContenedor);
    }

    // lista de hijos
    private ArrayList<FormularioExtensible> hijosExtensibles = new ArrayList<FormularioExtensible>();

    /**
     * @return the hijosExtensibles
     */
    public ArrayList<FormularioExtensible> getHijosExtensibles() {
        return hijosExtensibles;
    }

    /**
     * @param hijosExtensibles the hijosExtensibles to set
     */
    public void setHijosExtensibles(ArrayList<FormularioExtensible> hijosExtensibles) {
        this.hijosExtensibles = hijosExtensibles;
    }

    // lista de observadores de eventos
    private ListaObservadoresEventos listaObservadores;

    /**
     * obtener la lista de observadores
     *
     * @return listaObservadores
     */
    public ListaObservadoresEventos getListaObservadores() {
        return listaObservadores;
    }

    /**
     * poner la lista de observadores
     *
     * @param listaObservadores the listaObservadores to set
     */
    public void setListaObservadores(ListaObservadoresEventos listaObservadores) {
        this.listaObservadores = listaObservadores;
    }

    int minAltura = 500;
    int minAnchura = 600;

    /**
     * constructor por defecto crea el panel de botones Aceptar y Cancelar
     */
    public FormularioExtensible() {
        initComponents();
        this.panelBotones = new PanelBotones();
        panelBotones.nuevoActionListener(this);
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            // No debería ocurrir
        }
        // Aqui viene la implementacion de la clonación "profunda" ('deep clone')
        ((FormularioExtensible) clone).setExtension(this.getExtension());

        return clone;
    }

    /**
     * configurar el formulario
     *
     * @return Boolean
     */
    public Boolean configurarFormulario() {

        addPanelBotones();
        // this.setLocationRelativeTo(null);
        Dimension minimumSize = new Dimension();
        minimumSize.setSize(minAnchura, minAltura);
        //this.setMinimumSize(minimumSize);
        this.setPreferredSize(minimumSize);

        this.setSize(minAnchura, minAltura);
        this.setLocation(500, 0);
        return true;
    }

    /**
     * incluye un nuevo hijo
     *
     * @param hijo
     * @param titulo
     * @throws java.lang.Exception cuando se supera el maximo de hijos = 2 ,en
     * Formulario Simple
     */
    public void addHijoExtensible(FormularioExtensible hijo, String titulo) throws Exception {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Template

    }

    /**
     * inclye los hijos de una lista
     *
     * @param listaHijos
     * @param titulo
     * @throws java.lang.Exception cuando se supera el maximo de hijos = 2 ,en
     * Formulario Simple
     */
    public void addListaHijosExtensibles(ArrayList<FormularioExtensible> listaHijos, String titulo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Template
    }

    /**
     * metodos de la Interface Ivalidable
     */
    @Override
    public void aceptar() {
        System.out.println("aceptar " + this.getClass() + " " + this.getName());
        if (this.validar()) {
            this.guardar();
            this.limpiar();
            JOptionPane.showMessageDialog(this, "Operacion Realizada");
        } else {
            JOptionPane.showMessageDialog(this, "Validacion Incorrecta");
        }

    }

    @Override
    public void cancelar() {
        System.out.println("cancelar " + this.getClass() + " " + this.getName());

        this.limpiar();
        JOptionPane.showMessageDialog(this, "Operacion Cancelada");
    }

    @Override
    public Boolean validar() {
        System.out.println("validar " + this.getClass() + " " + this.getName());

        if (this.validarCampos()) {
            // recorrer los hijos
            for (int x = 0; x < getHijosExtensibles().size(); x++) {
                FormularioExtensible prueba = (FormularioExtensible) getHijosExtensibles().get(x);
                if (!prueba.validar()) {
                    return (Boolean.FALSE);
                }
            }
            return (Boolean.TRUE);
        } else {
            return (Boolean.FALSE);
        }
    }

    @Override
    public Boolean validarCampos() {
        System.out.println("Validar Campos " + this.getClass() + " " + this.getName());
        return (Boolean.TRUE);
    }

    @Override
    public void guardar() {
        System.out.println("guardar " + this.getClass() + " " + this.getName());

        // recorrer los hijos
        for (int x = 0; x < getHijosExtensibles().size(); x++) {
            FormularioExtensible prueba = (FormularioExtensible) getHijosExtensibles().get(x);
            prueba.guardar();

        }

    }

    @Override
    public void limpiar() {
        System.out.println("limpiar " + this.getClass() + " " + this.getName());

        // recorrer los hijos
        for (int x = 0; x < getHijosExtensibles().size(); x++) {
            FormularioExtensible prueba = (FormularioExtensible) getHijosExtensibles().get(x);
            prueba.limpiar();

        }
    }

    /**
     * metodos de la Interface Comunicable
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
    private PanelBotones panelBotones;

    private void addPanelBotones() {

        this.getContentPane().add(panelBotones, BorderLayout.PAGE_END);
    }

}
