/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

/**
 *interface para counicar componentees de los formularios
 * Definee el patron de los metodos que se deben implementar
 * @author Javi
 */
public interface Comunicable {
    
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
    
    /**
     * obtiene el valor de un componente propio
     * @param nombreComponente the value of nombreComponente
          * @return the Object
     */
    public Object obtenerValor(String nombreComponente);
}
