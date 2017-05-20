/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.mybeans;

import fst.jee.entity.User;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author souha
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable{

    /**
     * Creates a new instance of SessionBean
     */
     FacesContext facesContext = FacesContext.getCurrentInstance();
      HttpSession  session = (HttpSession) facesContext.getExternalContext().getSession(false);
    private boolean sessionBool;
    public SessionBean() {
         
    }
    private User user;

    public User getUser() {
        if((user=(User)session.getAttribute("user"))!=null) {
            System.out.println("getUser"+user.getId());
            return user;
       }
        return null;
    }

    public void setU(User u) {
        this.user = u;
    }
    public boolean isSessionBool(){
      //  System.out.println("sessssssssion");
       
       if(session.getAttribute("user")==null) {
           // System.out.println("nuuuuuul");
            return false;
       }
       else{
         //   System.out.println("not uuuuuul");
        return true;
       }
    }
}
