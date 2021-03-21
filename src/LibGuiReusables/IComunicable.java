/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

/**
 *
 * @author Javi
 */
public interface IComunicable {
    
    /**
     *  cambiar valor a un componente
     * @param nombreComponente
     * @param valor
     */
    public void cambiarValor(String nombreComponente , Object valor );

  
    /**
     *  obtiene valor de un componente externo
     * @param nombreComponente
     * @param valor
     */
    public void recuperarValorExterno(String nombreComponente , Object valor);
    
}
