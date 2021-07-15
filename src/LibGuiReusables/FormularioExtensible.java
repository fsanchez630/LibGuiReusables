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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * clase abstracta que contiene las mayoria de la funcionalidad de sus clases
 * derivadas simple, PorFichas y Arbol implementa interface Observador para
 * manejar eventos implementa interface Validable para validacion de datos ,
 * guardar y limpiar implementa interface Comunicable para comunicacion entre
 * componentes
 *
 * @author Francisco Javier Sánchez Lozano
 */
public abstract class FormularioExtensible extends Formulario implements Comunicable, Validable, Observador {

    // nombre del contenedor
    private String nombreContenedor;

    // indica si tiene botones
    private Boolean hayBotones;

    // lista de hijos
    private ArrayList<FormularioExtensible> hijosExtensibles = new ArrayList<FormularioExtensible>();

    // gestor de Eventos
    private GestorEventos gestorEventos;

    // panel con los botones 
    private PanelBotonesEventos panelBotones;

    // minima altura
    private int minAltura;

    // minima anchura
    private int minAnchura;

    /**
     * enumeracion con los tipos de Contenedor
     */
    public enum TipoFormulario {
        SIMPLE, PORFICHAS, ARBOL
    }

    // agrega el panel botonoes con los botones aceptar y cancelar
    private void addPanelBotones() {

        this.getContentPane().add(panelBotones, BorderLayout.PAGE_END);
    }

    /**
     * procesar la accion para el boton aceptar
     */
    protected final void aceptar() {
        System.out.println("aceptar " + this.getClass() + " " + this.getName());
        EventoValidar evtVal = this.validar();
        getGestorEventos().notificarEvento("Validar", evtVal);

    }

    /**
     * procesar la accion para el boton cancelar
     */
    protected final void cancelar() {
        System.out.println("cancelar " + this.getClass() + " " + this.getName());

        JOptionPane.showMessageDialog(this, "Operacion Cancelada");
        this.limpiar();
    }

    /**
     * validacion recursiva de los formularios
     *
     * @return Evnto validar con valor verdadero o falso
     */
    protected final EventoValidar validar() {
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

    /**
     * guardado recursivo de los formularios
     */
    protected final void guardar() {
        System.out.println("guardar " + this.getClass() + " " + this.getName());

        // recorrer los hijos
        for (int x = 0; x < getHijosExtensibles().size(); x++) {
            FormularioExtensible hijo = (FormularioExtensible) getHijosExtensibles().get(x);
            hijo.guardar();

        }
        this.guardarFormulario();
    }

    /**
     * limpieza recursiba de los formularios
     */
    protected final void limpiar() {
        System.out.println("limpiar " + this.getClass() + " " + this.getName());

        // recorrer los hijos
        for (int x = 0; x < getHijosExtensibles().size(); x++) {
            FormularioExtensible hijo = (FormularioExtensible) getHijosExtensibles().get(x);
            hijo.limpiar();

        }

        this.limpiarFormulario();
    }

    /**
     * constructor por defecto
     */
    public FormularioExtensible() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.formularioPadre = null;
        this.minAnchura = 0;
        this.minAltura = 0;
        this.hayBotones = false;
        initComponents();

    }

    /**
     * configurar el formulario
     *
     * @return Boolean
     */
    public Boolean configurarFormulario() {
// crear el panel botones si el flag es verdadero
        if (getHayBotones()) {
            this.panelBotones = new PanelBotonesEventos();
            panelBotones.addObservador(this);
            addPanelBotones();
            getGestorEventos().addObservador("Validar", this);
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
     * @param hijo Formulario Hijo a agregar
     * @param titulo titulo del Formulario
     * @throws java.lang.Exception cuando se supera el maximo de hijos = 2 ,en
     * Formulario Simple
     */
    public void addHijoExtensible(FormularioExtensible hijo, String titulo) throws Exception {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Template

    }

    /**
     * inclye los hijos de una lista
     *
     * @param listaHijos Lista de Formularios Hijos a agregar 
     * @param titulo titulo del Formulario
     * @throws java.lang.Exception cuando se supera el maximo de hijos = 2 ,en
     * Formulario Simple
     */
    public void addListaHijosExtensibles(ArrayList<FormularioExtensible> listaHijos, String titulo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Template
    }

    /**
     * metodos de la Interface Validable
     */
    @Override
    public Boolean validarCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Template
    }

    @Override
    public void guardarFormulario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Template    
    }

    @Override
    public void limpiarFormulario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Template     
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

    @Override
    public Object obtenerValor(String nombreComponente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodos de la Interface Observador
     */
    @Override
    final public void procesarEventoValidar(EventoValidar evt) {
        EventoValidar evtVal;
        evtVal = (EventoValidar) evt;
        if (evtVal.esCorrecto()) {
            this.guardar();
            JOptionPane.showMessageDialog(this, "Operacion Realizada");
            this.limpiar();

        } else {
            JOptionPane.showMessageDialog(this, "Validacion Incorrecta");
        }
    }

    @Override
    final public void procesarEventoPulsarBoton(EventoPulsarBoton evt) {
        JButton boton = (JButton) evt.getOrigen();

        if (boton.getActionCommand().equals("Aceptar")) {
            aceptar();
        } else if (boton.getActionCommand().equals("Cancelar")) {
            cancelar();
        }
    }

    @Override
    public void procesarEventoCambiarValor(EventoCambiarValor evt) {

    }

    @Override
    public void procesarEventoSelNodo(EventoSelNodo evt) {

    }

   
    /**
     * @return the hijosExtensibles
     */
    protected ArrayList<FormularioExtensible> getHijosExtensibles() {
        return hijosExtensibles;
    }

    /**
     * @param hijosExtensibles asigna la Lista de Formularios Hijos
     */
    protected void setHijosExtensibles(ArrayList<FormularioExtensible> hijosExtensibles) {
        this.hijosExtensibles = hijosExtensibles;
    }

    

    /**
     * @return the minAltura
     */
    protected int getMinAltura() {
        return minAltura;
    }

    /**
     * @param minAltura minima altura a asignar
     */
    protected void setMinAltura(int minAltura) {
        this.minAltura = minAltura;
    }

    /**
     * @return minima altura
     */
    protected int getMinAnchura() {
        return minAnchura;
    }

    /**
     * @param minAnchura niminima anchura a asignar
     */
    protected void setMinAnchura(int minAnchura) {
        this.minAnchura = minAnchura;
    }

    
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
     * @param nombre nombre del Contenerdo a asignar
     */
    public void setnombreContenedor(String nombre) {
        nombreContenedor = nombre;
        this.setTitle(nombreContenedor);
    }

    /**
     * @return the hayBotones
     */
    public Boolean getHayBotones() {
        return hayBotones;
    }

    /**
     * @param hayBotones asigna el valor booleano de HayBotones
     */
    public void setHayBotones(Boolean hayBotones) {
        this.hayBotones = hayBotones;
    }

    /**
     * @return  gestorEventos
     */
    public GestorEventos getGestorEventos() {
        return gestorEventos;
    }

    /**
     *
     * @param gE Gestor de Eventos a asignar
     */
    public void setGestorEventos(GestorEventos gE) {
        gestorEventos = gE;
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
