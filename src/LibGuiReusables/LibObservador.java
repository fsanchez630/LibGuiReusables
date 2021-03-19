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
 *
 * @author Javi
 */
public class LibObservador {

    private EventListenerList listeners;

    public LibObservador() {
        listeners = new EventListenerList();

    }

    public void nuevoChangeListener(ChangeListener listener) {
        listeners.add(ChangeListener.class, listener);
    }

    public void nuevoActionListener(ActionListener listener) {
        listeners.add(ActionListener.class, listener);
    }

    public void disparaStateChanged(ChangeEvent evt) {
        ChangeListener[] listenerLista = listeners.getListeners(ChangeListener.class);
        for (int i = listenerLista.length - 1; i >= 0; --i) {
            listenerLista[i].stateChanged(evt);
        }

    }

    public void disparaActionEvent(ActionEvent evt) {
        ActionListener[] listenerLista = listeners.getListeners(ActionListener.class);
        for (int i = listenerLista.length - 1; i >= 0; --i) {
            listenerLista[i].actionPerformed(evt);
        }

    }
}
