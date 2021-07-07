/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

/**
 *
 * @author User
 */
public interface Observador {
    
    /**
     *  procesar Evento recuperardo
     * @param evt Evento
     * 
     */
   
    public void procesarEventoValidar(EventoValidar evt) ;
    public void procesarEventoPulsarBoton(EventoPulsarBoton evt) ;
    public void procesarEventoCambiarValor(EventoCambiarValor evt) ;
    
}
