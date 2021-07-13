/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables.interfaces;

/**
 *interface para comunicar componentes de los formularios
 * Definee los metodos que se deben implementar
 * @author Francisco Javier Sánchez Lozano
 */
public interface Comunicable {
    
    /**
     *  cambiar valor a un componente
     * @param nombreComponente cadena con el nomc=bre del componente
     * @param valor valor a signar
     */
    public void cambiarValor(String nombreComponente , Object valor );

  
    /**
     *  obtiene valor de un componente externo
     * @param nombreComponente cadena con el nomc=bre del componente
     * @param valor vaor a asignar
     */
    public void recuperarValorExterno(String nombreComponente , Object valor);
    
    /**
     * obtiene el valor de un componente propio
     * @param nombreComponente cadena con el nomc=bre del componente
     * @return Object componente 
     */
    public Object obtenerValor(String nombreComponente);
}
