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

    private ArrayList<Observador> Observadores;

    public void GestorEventos() {
        this.Observadores = new ArrayList<Observador>();
    }

    /**
     * agregar observador a la lista de Observadores
     *
     * @param obs observador que se agrega
     */
    public void addObservador(Observador obs) {
        if (!this.Observadores.contains(obs)) {
            this.Observadores.add(obs);

        }
    }

    /**
     * quitar observador a la lista de Observadores
     *
     * @param obs observador que se quita
     */
    public void removeObservador(Observador obs) {
        if (this.Observadores.contains(obs)) {
            this.Observadores.remove(obs);

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
