/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.mybeans;

import fst.jee.entity.User;
import fst.jee.services.UserService;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author souha
 */
@Named(value = "userBean")
@RequestScoped
public class UserBean {

    /**
     * Creates a new instance of UserBean
     */
    //private User u =null; 

    /*public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }*/
    private UserService uService=new UserService() ;
    
    public UserBean() {
    }
    
    public void saveUser(User u ) throws IOException{
        System.out.println("***********************saaaaaave");
        uService.saveUser(u);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("/GestionProduit/faces/index.xhtml");
    
    
    }
    
    
    
}
