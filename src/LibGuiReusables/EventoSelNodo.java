/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

/**
 *  clase para el Evento de seleccion nodo arbol  
 * @author Francisco Javier Sánchez Lozano
 */
public class EventoSelNodo extends Evento {   
      /**
     *
     * @param ori objeto origen
     */
    public EventoSelNodo(Object ori) {
        super(ori);
        this.tipoEvento = "SelNodo";
    }

   

    

   

}
