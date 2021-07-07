/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

public class EventoCambiarValor extends Evento {
    
    /**
     * valor del objeto
     */
    private Object valor;

    /**
     *
     * @param ori
     */
    public EventoCambiarValor(Object ori) {
        super(ori);
        this.tipoEvento = "CambiarValor";
    }

   

    

   

}
