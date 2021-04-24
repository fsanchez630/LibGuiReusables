/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import LibGuiReusables.FormularioExtensible.TipoContenedor;
import javax.swing.JFrame;

/**
 * Clase Factoria de los Formularios extensibles
 * 
 * @author Javi
 */
public abstract class FactoriaFormularios {

    /**
     * crea una nueva instancia del tipoContenedor 
     * @param tipo
     * @param extension
     * @param nombre
     * @return FormularioExtensible
     */
    public static FormularioExtensible crearFormulario(TipoContenedor tipo, JFrame extension, String nombre) {

        FormularioExtensible formulario = crearFormulario(tipo);

                
        formulario.setExtension(extension);
        formulario.setnombreContenedor(nombre);

        return formulario;
    }

    /**
     * crea una nueva instancia del tipoContenedor 
     * @param tipo
     * @param nombre
     * @return
     */
    public static FormularioExtensible crearFormulario(TipoContenedor tipo,  String nombre) {

        FormularioExtensible formulario = crearFormulario(tipo);          
        formulario.setnombreContenedor(nombre);

        return formulario;
    }
    /**
     * crea una nueva instancia del tipoContenedor 
     * @param tipo
     * @return
     */
    public static FormularioExtensible crearFormulario(TipoContenedor tipo) {

        FormularioExtensible formulario ;

        switch (tipo) {
            case SIMPLE:
             formulario = new FormularioSimple();
             break;
            case PORFICHAS:
                formulario = new FormularioPorFichas();
                break;
            case ARBOL:
                formulario = new FormularioArbol();
                break;
            default:
                formulario = new FormularioSimple();
                break;
                            
        }

        

        return formulario;
    }
}
