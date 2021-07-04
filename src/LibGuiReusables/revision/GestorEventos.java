/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables.revision;

import java.util.ArrayList;

/**
 *
 * @author javi
 */
public class GestorEventos {

    private ArrayList<Observador> Observadores = new ArrayList<Observador>();

    /**
     * constructor
     */
    public GestorEventos() {
        Observadores.clear();
    }

    /**
     * agregar observador a la lista de Observadores
     *
     * @param obs observador que se agrega
     */
    public void addObservador(Observador obs) {
        if (!Observadores.contains((Observador) obs)) {
            Observadores.add((Observador) obs);

        }
    }

    /**
     * quitar observador a la lista de Observadores
     *
     * @param obs observador que se quita
     */
    public void removeObservador(Observador obs) {
        if (this.Observadores.contains((Observador) obs)) {
            this.Observadores.remove((Observador) obs);

        }
    }

    /**
     * notificar evento a los observadores de la lista
     *
     * @param evt evento a notificar
     */
    public void notificarEvento(Evento evt) {
        for (Observador obs : this.Observadores) {

            obs.procesarEvento(evt);

        }
    }

}
