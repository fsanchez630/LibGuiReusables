/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import LibGuiReusables.interfaces.Observador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author javi
 */
public class GestorEventos {

    private final Map<String, ArrayList<Observador>> Observadores = new HashMap<>();

    /**
     * constructor
     */
    public GestorEventos() {

        this.Observadores.put("Validar", new ArrayList<>());
        this.Observadores.put("PulsarBoton", new ArrayList<>());
        this.Observadores.put("CambiarValor", new ArrayList<>());
        this.Observadores.put("SelNodo", new ArrayList<>());

    }

    /**
     * agregar observador a la lista de Observadores
     *
     * @param TipoEvento tipo evento
     * @param obs observador que se agrega
     */
    public void addObservador(String TipoEvento, Observador obs) {
        ArrayList<Observador> listaObs = Observadores.get(TipoEvento);

        if (!listaObs.contains(obs)) {
            listaObs.add(obs);
        }

    }

    /**
     * quitar observador a la lista de Observadores
     *
     * @param TipoEvento tipo de evento
     * @param obs observador que se quita
     */
    public void removeObservador(String TipoEvento, Observador obs) {
        ArrayList<Observador> listaObs = Observadores.get(TipoEvento);
        if (listaObs.contains(obs)) {
            listaObs.remove(obs);
        }

    }

    /**
     * quitar observador a la lista de Observadores
     *
     * @param obs observador que se quita
     */
    public void removeObservador(Observador obs) {
        ArrayList<Observador> listaObs = Observadores.get("Validar");
        if (listaObs.contains(obs)) {
            listaObs.remove(obs);
        }

        listaObs = Observadores.get("PulsarBoton");
        if (listaObs.contains(obs)) {
            listaObs.remove(obs);
        }

        listaObs = Observadores.get("CambiarValor");
        if (listaObs.contains(obs)) {
            listaObs.remove(obs);
        }

        listaObs = Observadores.get("SelNodo");
        if (listaObs.contains(obs)) {
            listaObs.remove(obs);
        }
    }

    /**
     * notificar evento a los observadores de la lista
     *
     * @param TipoEvento ei tipo de evento
     * @param evt evento a notificar
     */
    public void notificarEvento(String TipoEvento, Evento evt) {
        ArrayList<Observador> listaObs = Observadores.get(TipoEvento);
        for (Observador obs : listaObs) {

            switch (TipoEvento) {
                case "Validar":
                    obs.procesarEventoValidar((EventoValidar) evt);
                    break;
                case "PulsarBoton":
                    obs.procesarEventoPulsarBoton((EventoPulsarBoton) evt);
                    break;
                case "CambiarValor":
                    obs.procesarEventoCambiarValor((EventoCambiarValor) evt);
                    break;
                case "SelNodo":
                    obs.procesarEventoSelNodo((EventoSelNodo) evt);
                    break;
                default:
                    throw new UnsupportedOperationException("Not supported yet.");

            }

        }
    }

}
