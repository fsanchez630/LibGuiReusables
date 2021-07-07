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
public abstract class Evento {

/**
     * tipo del Evento
     */    
    protected String tipoEvento;
    
    
    
    /**
     * origen del Evento
     */
    private Object origen;
    
    /**
     * @return the tipoEvento
     */
    public String getTipoEvento() {
        return tipoEvento;
    }
    

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
