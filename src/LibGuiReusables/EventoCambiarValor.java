/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

/**
 *  clase para el Evento de Cambio de valor 
 * @author Francisco Javier Sánchez Lozano
 */
public class EventoCambiarValor extends Evento {
    
   
    /**
     *constructor
     * @param ori ojeto origen
     */
    public EventoCambiarValor(Object ori) {
        super(ori);
        this.tipoEvento = "CambiarValor";
    }

   

    

   

}
