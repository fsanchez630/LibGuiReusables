/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables.interfaces;

/**
 * interface para validacion de datos de los formularios define el patron de los
 * metodos que se deben implementar
 *
 * @author Francisco Javier Sánchez Lozano

 */
public interface Validable {

    /**
     * validar campos del Formulario
     * @return boolean 
     */
    public Boolean validarCampos();

    /**
     * guardar datos formulario
     */
    public void guardarFormulario();

    /**
     * limpiar datos formulario
     */
    public void limpiarFormulario();

}
