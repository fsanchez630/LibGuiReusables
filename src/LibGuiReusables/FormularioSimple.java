/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Javi
 */
public class FormularioSimple extends FormularioExtensible implements Comunicable, Validable, Observador {
    
    private JPanel panelPrincipal;
    static final Integer MAXHIJOS = 2;

    /**
     * Constructor por defecto crea el panel principal
     */
    public FormularioSimple() {
        initComponents();
        panelPrincipal = new JPanel();
        this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
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
     * incluye un nuevo hijo
     *
     * @param hijo
     * @param titulo
     * @throws java.lang.Exception cuando se supera el maximo de hijos = 2 ,en
     * Formulario Simple
     */
    @Override
    public void addHijoExtensible(FormularioExtensible hijo, String titulo) throws Exception {
        
        if ((getHijosExtensibles().size() + 1) > FormularioSimple.MAXHIJOS) {
            Exception err = new Exception("maximos de hijos alcanzado");
            throw err;
        }
        hijo.setFormularioPadre(this);
        hijo.setMinAltura(hijo.getHeight());
        hijo.setMinAnchura(hijo.getWidth());
        hijo.setnombreContenedor(titulo);
        
        getHijosExtensibles().add((FormularioExtensible) hijo);
        
        JPanel panelHijo = (JPanel) hijo.getContentPane();
        
        panelPrincipal.setLayout(new GridLayout(0, 1));
        panelPrincipal.add(panelHijo, BorderLayout.CENTER);
        
        if (this.getMinAnchura() < hijo.getMinAnchura()) {
            this.setMinAnchura(hijo.getMinAnchura());
        }
        
        this.setMinAltura(this.getMinAltura() + hijo.getMinAltura());
        
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
        if (titulo.isEmpty() || titulo.equals(getnombreContenedor())) {
        } else {
            setnombreContenedor(titulo);
        }
        
        for (FormularioExtensible hijo : listaHijos) {
            
            if ((getHijosExtensibles().size() + 1) > FormularioSimple.MAXHIJOS) {
                Exception err = new Exception("maximos de hijos alcanzado");
                
                throw err;
            }
            hijo.setFormularioPadre(this);
            hijo.setMinAltura(hijo.getHeight());
            hijo.setMinAnchura(hijo.getWidth());
            
            getHijosExtensibles().add((FormularioExtensible) hijo);
            
            JPanel panelHijo = (JPanel) hijo.getContentPane();
            
            panelPrincipal.setLayout(new GridLayout(0, 1));
            panelPrincipal.add(panelHijo, BorderLayout.CENTER);
            
            if (this.getMinAnchura() < hijo.getMinAnchura()) {
                this.setMinAnchura(hijo.getMinAnchura());
            }
            
            this.setMinAltura(this.getMinAltura() + hijo.getMinAltura());
            
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
    
}
