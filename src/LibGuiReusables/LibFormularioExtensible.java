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
 *
 * @author Javi
 */
public abstract class LibFormularioExtensible extends LibFormulario implements ActionListener, ChangeListener, IComunicable, IValidable {

    public LibFormularioExtensible() {
        initComponents();
        this.panelBotones = new LibPanelBotones();
        panelBotones.nuevoActionListener(this);
    }

    @Override
    public void aceptar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
     * @param Valor the value of Valor
     * @return the Object
     */
    @Override
    public Object obtenerValor(String nombreComponente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    public enum TipoContenedor {
        SIMPLE, PORFICHAS, ARBOL
    }

    private String nombreContenedor;

    private ArrayList<LibFormularioExtensible> hijosExtensibles = new ArrayList<>();

    /**
     *
     * @param nombre
     */
    public void setnombreContenedor(String nombre) {
        nombreContenedor = nombre;
        this.setTitle(nombreContenedor);
    }

    /**
     *
     * @return
     */
    public String getnombreContenedor() {
        return nombreContenedor;
    }

    /**
     *
     * @return
     */
    public Boolean configurarFormulario() {

        addPanelBotones();
        this.setLocationRelativeTo(null);
        return true;
    }

    /**
     *
     * @param hijo
     * @param titulo
     */
    public void addHijoExtensible(LibFormularioExtensible hijo, String titulo) {

        hijo.nombreContenedor = titulo;
        hijosExtensibles.add(hijo);

        if (this instanceof LibFormularioSimple) {

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
     *
     * @param listaHijos
     * @param titulo
     */
    public void addListaHijosExtensibles(ArrayList<LibFormularioExtensible> listaHijos, String titulo) {
        if (titulo.isEmpty() || titulo.equals(nombreContenedor)) {
        } else {
            nombreContenedor = titulo;
        }

        if (this instanceof LibFormularioSimple) {
            for (LibFormularioExtensible hijo : listaHijos) {
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

        this.getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }

}
