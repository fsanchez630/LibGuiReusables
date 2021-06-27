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
public class FactoriaFormExtensible {
    
    private FormExtensibleBuilder formExtensibleBuilder;
    
    public void setFormExtensibleBuilder(FormExtensibleBuilder fbuilder){
        formExtensibleBuilder = fbuilder;
    }
    
    public FormExtensible getFormExtensible(){
        return formExtensibleBuilder.getFormExtensible();
    }
    
    public void construirFormulario(){
        formExtensibleBuilder.buildTipo();
        formExtensibleBuilder.buildX();
        formExtensibleBuilder.buildY();
        formExtensibleBuilder.buildZ();
        
    }
    
}
