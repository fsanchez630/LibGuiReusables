/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

/**
 *interface para validacion de datos de los formularios
 * define el patron los metodos que se deben implementar
 * @author Javi
 */
public interface IValidable {
    
    /**
     *  aceptar datos formulario
     */
    public void aceptar();

    /**
     *  cancelar datos formulario
     */
    public void cancelar();
    
    /**
     *  validar datos formulario
     * @return verdadero cuando cumple correctamente las validaciones
     */
   Boolean validar();
    
    /**
     *  guardar datos formulario
     */
    public void guardar();
    
    /**
     *  limpiar datos formulario
     */
    public void limpiar();
    
}
