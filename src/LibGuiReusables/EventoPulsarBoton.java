/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

/**
 *  clase para el Evento de pulsar Boton 
 * @author Francisco Javier Sánchez Lozano
 */
public class EventoPulsarBoton extends Evento { 

    /**
     *
     * @param ori ojeto origen
     */
    public EventoPulsarBoton(Object ori) {
        super(ori);
        this.tipoEvento = "PulsarBoton";
    }
    
    
    
    
}
