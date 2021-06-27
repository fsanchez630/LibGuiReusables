/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibGuiReusables.revision;

/**
 *
 * @author Javi
 */
public abstract class FormExtensibleBuilder {

    protected FormExtensible formExtensible;

    public FormExtensible getFormExtensible() {
        return formExtensible;
    }

    public abstract void buildTipo();
    public abstract void buildX();
    public abstract void buildY();
    public abstract void buildZ();

}
