/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

/**
 * Clase que maneja la lista de observadores de eventos
 * @author Javi
 */
public class ListaObservadoresEventos {

    // lista de observadores de eventos
    private EventListenerList listeners;

    /**
     * crea una nueva lista de observadores de eventos
     */
    public ListaObservadoresEventos() {
        listeners = new EventListenerList();

    }

    /**
     * incluye un nuevo observador de cambios en la lista
     * @param listener
     */
    public void nuevoChangeListener(ChangeListener listener) {
        listeners.add(ChangeListener.class, listener);
    }

    /**
     * incluye un nuevo observador de acciones en la lista
     * @param listener
     */
    public void nuevoActionListener(ActionListener listener) {
        listeners.add(ActionListener.class, listener);
    }

    /**
     * notifica el evento cambio a los observaores de la lista
     * @param evt
     */
    public void disparaStateChanged(ChangeEvent evt) {
        ChangeListener[] listenerLista = listeners.getListeners(ChangeListener.class);
        for (int i = listenerLista.length - 1; i >= 0; --i) {
            listenerLista[i].stateChanged(evt);
        }

    }

    /**
     * notifica el evento  accion a los observadores  de la lista
     * @param evt
     */
    public void disparaActionEvent(ActionEvent evt) {
        ActionListener[] listenerLista = listeners.getListeners(ActionListener.class);
        for (int i = listenerLista.length - 1; i >= 0; --i) {
            listenerLista[i].actionPerformed(evt);
        }

    }
}
