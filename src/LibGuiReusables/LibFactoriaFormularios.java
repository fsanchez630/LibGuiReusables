/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import LibGuiReusables.LibFormularioExtensible.TipoContenedor;
import javax.swing.JFrame;

/**
 *
 * @author Javi
 */
public class LibFactoriaFormularios {

    /**
     *
     * @param tipo
     * @param extension
     * @param nombre
     * @return
     */
    public LibFormularioExtensible crearFormulario(TipoContenedor tipo, JFrame extension, String nombre) {

        LibFormularioExtensible formulario = crearFormulario(tipo);

                
        formulario.setExtension(extension);
        formulario.setnombreContenedor(nombre);

        return formulario;
    }

    /**
     *
     * @param tipo
     * @return
     */
    public LibFormularioExtensible crearFormulario(TipoContenedor tipo) {

        LibFormularioExtensible formulario ;

        switch (tipo) {
            case SIMPLE:
             formulario = new LibFormularioSimple();
             break;
            case PORFICHAS:
                formulario = new LibFormularioPorFichas();
                break;
            case ARBOL:
                formulario = new LibFormularioSimple();
                break;
            default:
                formulario = new LibFormularioSimple();
                break;
                            
        }

        

        return formulario;
    }
}
