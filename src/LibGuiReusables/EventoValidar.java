/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

/**
 *  clase para el Evento de validacion de Formulario
 * @author Francisco Javier Sánchez Lozano
 */
public class EventoValidar extends Evento {

    /**
     *  booleano que indica si es corecto o no
     */
    protected boolean correcto;

    /**
     *
     * @param ori objeto origen
     */
    public EventoValidar(Object ori) {
        super(ori);
        this.tipoEvento = "Validar";
    }

    /**
     * @return correcto
     */
    public boolean esCorrecto() {
        return correcto;
    }

    /**
     * @param correc valor booleano
     */
    public void setEsCorrecto(boolean correc) {
        this.correcto = correc;
    }

}
