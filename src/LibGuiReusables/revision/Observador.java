/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables.revision;

/**
 *
 * @author User
 */
public interface Observador {
    
    /**
     *  procesar Evento recuperardo
     * @param evt Evento
     */
    public void procesarEvento(Evento evt);
    
}