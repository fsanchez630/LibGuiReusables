package LibGuiReusables;

import LibGuiReusables.FormularioExtensible.TipoFormulario;

public final class FactoriaFormularioExtensible {

    /**
     * Crea y devuelve un Formulario del tipo indicado
     *
     * @param tipo El tipo de formulario que se quiere crear
     *
     * @return el formulario creado, o null en caso de que no se haya creado
     * correctamente
     */
    public final FormularioExtensible crearFormulario(TipoFormulario tipo) {

        final FormularioExtensible formulario;

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
                formulario = null;
        }

        return formulario;
    }

    /**
     * Crea, en caso de no existir, una instancia de la factoría, y la devuelve.
     *
     * @return El singleton existente (o creado) para la factoría
     */
    public static final FactoriaFormularioExtensible getInstancia() {

        if (FABRICA == null) {
            crearInstancia();
        }

        return FABRICA;
    }

   

    /**
     * Instancia única de la clase (Singleton).
     */
    private static FactoriaFormularioExtensible FABRICA = null;

    /**
     * Constructor privado, para evitar que se pueda instanciar.
     */
    private FactoriaFormularioExtensible() {
    }

    /**
     * Si no existe una instancia de la Factoría, la crea. Se trata de un método
     * con acceso interno sincronizado con el fin de evitar problemas en el caso
     * de ejecución concurrente o multi-hilo.
     */
    private static void crearInstancia() {

        synchronized (FactoriaFormularioExtensible.class) {
            if (FABRICA == null) {
                FABRICA = new FactoriaFormularioExtensible();
            }
        }
    }

}
