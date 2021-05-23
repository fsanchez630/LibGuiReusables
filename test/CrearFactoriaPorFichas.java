/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import LibGuiReusables.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Javi
 */
public class CrearFactoriaPorFichas extends FormularioPorFichas implements ActionListener, ChangeListener {

    private static FormularioExtensible formularioExtensible;
    private static FormularioExtensible formularioExtensible2;
    private static FormularioExtensible formularioExtensible3;

    private static FormSimpleDis0 formularioSimpleD0;
    private static FormSimpleDis1 formularioSimpleD1;
    private static FormSimpleDis2 formularioSimpleD2;
    private static FormSimpleDis3 formularioSimpleD3;
    private static FormSimpleDis4 formularioSimpleD4;
    private static FormSimpleDis5 formularioSimpleD5;
    private static ListaObservadoresEventos listaObs;

    
     /**
     * Creates new form CrearFactoriaSimple
     *
     * @return
     */
    public FormularioExtensible CrearFactoriaPorFichas() {
        initComponents();
        
        FormularioExtensible retorno = FactoriaFormularios.crearFormulario(FormularioExtensible.TipoContenedor.PORFICHAS);
        return retorno;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void crearGUI() {
        incializar();


        // formulario principal
        formularioExtensible = new CrearFactoriaPorFichas();
        formularioExtensible.setnombreContenedor("Factoria Por Fichas");
        
        // crear lista observadores de eventos e incluir el formulario
        listaObs = new ListaObservadoresEventos();

        listaObs.nuevoActionListener(formularioExtensible);
        listaObs.nuevoChangeListener(formularioExtensible);

        formularioExtensible.setListaObservadores(listaObs);

        // formularios simples
        formularioSimpleD0 = new FormSimpleDis0();
        formularioSimpleD0.setListaObservadores(listaObs);

        formularioSimpleD1 = new FormSimpleDis1();
        formularioSimpleD1.setListaObservadores(listaObs);

        // formulario por fichas
        formularioExtensible2 = FactoriaFormularios.crearFormulario(FormularioExtensible.TipoContenedor.PORFICHAS);
        formularioExtensible2.setnombreContenedor("Formulario Por Fichas");

        listaObs.nuevoActionListener(formularioExtensible2);
        listaObs.nuevoChangeListener(formularioExtensible2);

        formularioExtensible2.setListaObservadores(listaObs);

        formularioSimpleD2 = new FormSimpleDis2();
        formularioSimpleD2.setListaObservadores(listaObs);

        formularioSimpleD3 = new FormSimpleDis3();
        formularioSimpleD3.setListaObservadores(listaObs);

        try {
            formularioExtensible2.addHijoExtensible(formularioSimpleD2, "Formulario3");
            formularioExtensible2.addHijoExtensible(formularioSimpleD3, "Formulario4");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(formularioExtensible2, e.getMessage());
        }
        formularioExtensible2.configurarFormulario(false); //sin botones 

        // formulario arbol
        formularioExtensible3 = FactoriaFormularios.crearFormulario(FormularioExtensible.TipoContenedor.ARBOL);
        formularioExtensible3.setnombreContenedor("Formulario Arbol");

        listaObs.nuevoActionListener(formularioExtensible3);
        listaObs.nuevoChangeListener(formularioExtensible3);

        formularioExtensible3.setListaObservadores(listaObs);

        formularioSimpleD4 = new FormSimpleDis4();
        formularioSimpleD4.setListaObservadores(listaObs);

        formularioSimpleD5 = new FormSimpleDis5();
        formularioSimpleD5.setListaObservadores(listaObs);

        try {
            formularioExtensible3.addHijoExtensible(formularioSimpleD4, "Formulario5");
            formularioExtensible3.addHijoExtensible(formularioSimpleD5, "Formulario6");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(formularioExtensible3, e.getMessage());
        }
        formularioExtensible3.configurarFormulario(false); //sin botones 

        // añadir hijos al formulario principal
        try {
            formularioExtensible.addHijoExtensible(formularioSimpleD0, "Formulario1");
            formularioExtensible.addHijoExtensible(formularioSimpleD1, "Formulario2");
            formularioExtensible.addHijoExtensible(formularioExtensible2, formularioExtensible2.getnombreContenedor());
            formularioExtensible.addHijoExtensible(formularioExtensible3, formularioExtensible3.getnombreContenedor());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(formularioExtensible, e.getMessage());
        }

        formularioExtensible.configurarFormulario(true); // con botones
        formularioExtensible.setVisible(true);

    }

    private static void incializar() {
        formularioExtensible = null;
        formularioExtensible2 = null;
        formularioExtensible3 = null;

        formularioSimpleD0 = null;
        formularioSimpleD1 = null;
        formularioSimpleD2 = null;
        formularioSimpleD3 = null;
        formularioSimpleD4 = null;
        formularioSimpleD5 = null;
        // listaObs = null;;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void stateChanged(ChangeEvent evt) {
        JSpinner s = (JSpinner) evt.getSource();

        formularioSimpleD0.recuperarValorExterno("jSpinner1", s.getValue().toString());

    }

}
