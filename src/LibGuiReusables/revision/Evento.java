/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables.revision;

/**
 *
 * @author Javi
 */
public class Evento {

    /**
     * origen del Evento
     */
    private Object origen;

    /**
     *
     * @param ori
     */
    public Evento(Object ori){
        this.origen = ori;
    }
    /**
     * @return the origen
     */
    public Object getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(Object origen) {
        this.origen = origen;
    }
    
    
    
    
    
}
