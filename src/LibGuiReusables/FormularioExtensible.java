/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import LibGuiReusables.revision.Evento;
import LibGuiReusables.revision.EventoPulsarBoton;
import LibGuiReusables.revision.EventoValidar;
import LibGuiReusables.revision.GestorEventos;
import LibGuiReusables.revision.Observador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 * clase abstracta que contiene las mayoria de la funcionalidad de sus clases
 * derivadas simple, PorFichas y Arbol implementa interfaces para mahejo de
 * eventos implementa interface Validable para validacion de datos implementa
 * interface Comunicable para comunicion entre componentes
 *
 * @author Javi
 */
public abstract class FormularioExtensible extends Formulario implements ActionListener, ChangeListener, TreeSelectionListener, Comunicable, Validable, Observador {

   

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
    
    // indica si tiene botones
    private Boolean hayBotones;
    
    
     /**
     * @return the hayBotones
     */
    public Boolean getHayBotones() {
        return hayBotones;
    }

    /**
     * @param hayBotones the hayBotones to set
     */
    public void setHayBotones(Boolean hayBotones) {
        this.hayBotones = hayBotones;
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

    // gestor de Eventos
    private GestorEventos gestorEventos;

    /**
     * @return the gestorEventos
     */
    public GestorEventos getGestorEventos() {
        return gestorEventos;
    }

    /**
     * @param aGestorEventos the gestorEventos to set
     */
    public void setGestorEventos(GestorEventos aGestorEventos) {
        gestorEventos = aGestorEventos;
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

    private int minAltura;

    /**
     * @return the minAltura
     */
    public int getMinAltura() {
        return minAltura;
    }

    /**
     * @param minAltura the minAltura to set
     */
    public void setMinAltura(int minAltura) {
        this.minAltura = minAltura;
    }

    private int minAnchura;

    /**
     * @return the minAnchura
     */
    public int getMinAnchura() {
        return minAnchura;
    }

    /**
     * @param minAnchura the minAnchura to set
     */
    public void setMinAnchura(int minAnchura) {
        this.minAnchura = minAnchura;
    }

    /**
     * constructor por defecto crea el panel de botones Aceptar y Cancelar
     */
    public FormularioExtensible() {
        this.minAnchura = 0;
        this.minAltura = 0;
        initComponents();
        this.panelBotones = new PanelBotones();
        panelBotones.nuevoActionListener(this);

    }

    /**
     * configurar el formulario
     *
     * @param hayBotones
     * @return Boolean
     */
    public Boolean configurarFormulario() {

        if (getHayBotones()) {
            addPanelBotones();
        }
        // this.setLocationRelativeTo(null);
        Dimension minimumSize = new Dimension();
        minimumSize.setSize(getMinAnchura(), getMinAltura() + 50);
        this.setMinimumSize(minimumSize);
        this.setPreferredSize(minimumSize);

        this.setSize(getMinAnchura(), getMinAltura() + 50);
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
        EventoValidar evtVal = this.validar();
        this.gestorEventos.notificarEvento(evtVal);

    }

    @Override
    public void cancelar() {
        System.out.println("cancelar " + this.getClass() + " " + this.getName());

        JOptionPane.showMessageDialog(this, "Operacion Cancelada");
        this.limpiar();
    }

    @Override
    public EventoValidar validar() {
        System.out.println("validar " + this.getClass() + " " + this.getName());

        EventoValidar evtVal;

        if (this.validarCampos()) {
            // recorrer los hijos
            for (int x = 0; x < getHijosExtensibles().size(); x++) {
                FormularioExtensible hijo = (FormularioExtensible) getHijosExtensibles().get(x);
                evtVal = hijo.validar();
                if (!evtVal.esCorrecto()) {
                    return (evtVal);
                }
            }
            evtVal = new EventoValidar(this);
            evtVal.setEsCorrecto(true);
            return (evtVal);
        } else {
            evtVal = new EventoValidar(this);
            evtVal.setEsCorrecto(false);
            return (evtVal);
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
            FormularioExtensible hijo = (FormularioExtensible) getHijosExtensibles().get(x);
            hijo.guardar();

        }

    }

    @Override
    public void limpiar() {
        System.out.println("limpiar " + this.getClass() + " " + this.getName());

        // recorrer los hijos
        for (int x = 0; x < getHijosExtensibles().size(); x++) {
            FormularioExtensible hijo = (FormularioExtensible) getHijosExtensibles().get(x);
            hijo.limpiar();

        }
        this.dispose();
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

    /**
     * metodos de gestion de eventos
     *
     * @param evt
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Botón pulsado: " + evt.getActionCommand());
        if (evt.getActionCommand().equals("Aceptar")) {
            aceptar();
        } else if (evt.getActionCommand().equals("Cancelar")) {
            cancelar();
        }
    }

    @Override
    public void stateChanged(ChangeEvent evt) {
        System.out.println("evento cambio");
    }

    @Override
    public void valueChanged(TreeSelectionEvent evt) {

        System.out.println("selecion nodo");

    }

    @Override
    public void procesarEvento(Evento evt) {

        if (evt instanceof EventoValidar) {
            EventoValidar evtVal;
            evtVal = (EventoValidar) evt;
            if (evtVal.esCorrecto()) {
                this.guardar();
                JOptionPane.showMessageDialog(this, "Operacion Realizada");
                this.limpiar();

            } else {
                JOptionPane.showMessageDialog(this, "Validacion Incorrecta");
            }

        } else if (evt instanceof EventoPulsarBoton) {
            JButton boton = (JButton) evt.getOrigen();

            if (boton.getActionCommand().equals("Aceptar")) {
                aceptar();
            } else if (boton.getActionCommand().equals("Cancelar")) {
                cancelar();
            }

        } else {
            throw new UnsupportedOperationException("Not supported yet.");

        }

    }

}
