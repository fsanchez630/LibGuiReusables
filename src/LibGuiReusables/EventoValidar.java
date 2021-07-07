/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

public class EventoValidar extends Evento {

    /**
     *
     */
    private boolean correcto;

    /**
     *
     * @param ori
     */
    public EventoValidar(Object ori) {
        super(ori);
        this.tipoEvento = "Validar";
    }

    /**
     * @return the esCorrecto
     */
    public boolean esCorrecto() {
        return correcto;
    }

    /**
     * @param correc
     */
    public void setEsCorrecto(boolean correc) {
        this.correcto = correc;
    }

}
