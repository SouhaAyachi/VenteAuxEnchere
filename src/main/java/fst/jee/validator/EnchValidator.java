/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
https://fnoufal.wordpress.com/2012/04/22/creer-un-validateur-jsf-personnalise-et-linserer-dans-un-formulaire/
 */
package fst.jee.validator;

import fst.jee.entity.Produit;
import fst.jee.services.EnchereService;
import fst.jee.services.ProdService;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author souha
 */

public class EnchValidator implements Validator {

    /**
     * Creates a new instance of EnchValidator
     */
        EnchereService ench=new EnchereService();
ProdService pServ=new ProdService();

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
System.out.println("Bonjouuuuuuuuur");        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /*FacesContext facesContext = FacesContext.getCurrentInstance();
        String id = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
        System.out.println("Ench Bean: "+id);
        int idiya=Integer.parseInt(id);*/
        Produit p=pServ.findById(30);
      float max=  ench.maxPrixParProd(p.getId());
        if(max >= (float) value){
            System.out.println("Solde suuup"); 
         /* FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "summary", "details");
        FacesContext.getCurrentInstance().addMessage("msg", facesMsg);*/
          FacesMessage yourFailure = new FacesMessage();
    yourFailure.setDetail("Really you need to promise to never do that again!");
    yourFailure.setSummary("Stop here, now!");
    yourFailure.setSeverity(FacesMessage.SEVERITY_FATAL);

    context.addMessage(component.getClientId(context),  yourFailure);
        }
    }
    
}
