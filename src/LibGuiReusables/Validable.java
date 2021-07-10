/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

/**
 * interface para validacion de datos de los formularios define el patron los
 * metodos que se deben implementar
 *
 * @author Javi
 */
public interface Validable {

    /**
     * aceptar datos formulario
     */
    public void aceptar();

    /**
     * cancelar datos formulario
     */
    public void cancelar();

    /**
     * validar datos de todos los formulario
     *
     * @return EventoValidar con valor verdadero cuando cumple correctamente tosdas las validaciones
     */
    public EventoValidar validar();

    /**
     * validar datos de un formulario
     *
     * @return verdadero cuando cumple correctamente las validaciones de los
     * campso
     */
    public Boolean validarCampos();

    /**
     * guardar datos formulario
     */
    public void guardar();

    /**
     * limpiar datos formulario
     */
    public void limpiar();

}
