/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables.interfaces;

import LibGuiReusables.EventoCambiarValor;
import LibGuiReusables.EventoPulsarBoton;
import LibGuiReusables.EventoSelNodo;
import LibGuiReusables.EventoValidar;

/**
 * interface que define los metodos basicos de un objeto
 * observador de Eventos
 * @author Francisco Javier Sánchez Lozano
 */
public interface Observador {
    
    /**
     *  procesar Evento recuperardo de tipo Evento validar
     * @param evt Evento validar
     * 
     */
   
    public void procesarEventoValidar(EventoValidar evt) ;
    
     /**
     *  procesar Evento recuperardo de tipo Evento pulsar boton
     * @param evt Evento validar
     * 
     */
    public void procesarEventoPulsarBoton(EventoPulsarBoton evt) ;
     /**
     *  procesar Evento recuperardo de tipo Evento cambiar valor boton
     * @param evt Evento validar
     * 
     */
    public void procesarEventoCambiarValor(EventoCambiarValor evt) ;
     /**
     *  procesar Evento recuperardo de tipo Evento seleccion nodo arbol
     * @param evt Evento validar
     * 
     */
    public void procesarEventoSelNodo(EventoSelNodo evt) ;
    
}
