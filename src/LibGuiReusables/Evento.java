/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

/**
 * clase abstracta que defien la propiedades basicas  de un evento
 * @author Francisco Javier Sánchez Lozano
 */
public abstract class Evento {

/**
     * tipo del Evento
     */    
    protected String tipoEvento;
    
    
    
    /**
     * origen del Evento
     */
    protected Object origen;
    
    
    
    
    /**
     * @return  tipoEvento
     */
    public String getTipoEvento() {
        return tipoEvento;
    }
    

    /**
     * constructor
     * @param ori objeto origen
     */
    public Evento(Object ori){
        this.origen = ori;
    }
    /**
     * @return objeto origen
     */
    public Object getOrigen() {
        return origen;
    }

    /**
     * @param origen objecto origen
     */
    public void setOrigen(Object origen) {
        this.origen = origen;
    }

    
    
    
    
    
}
