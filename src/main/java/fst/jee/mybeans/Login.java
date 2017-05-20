/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.mybeans;

import fst.jee.entity.User;
import fst.jee.services.UserService;
import java.io.IOException;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author souha
 */
@Named(value = "login")
@RequestScoped
public class Login {

    /**
     * Creates a new instance of Login
     * 
     */
    UserService uService = new UserService();
    private String login;
     private String pwd;
     
     //Getters and setters

    public UserService getuService() {
        return uService;
    }

    public void setuService(UserService uService) {
        this.uService = uService;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
   
    public Login() {
    }
    
  
    
    public void verifLogin() throws IOException{
       User u= uService.findByLoginPwd(login, pwd);
       //System.out.println("Nom verif login *******"+u.getNom());
       if(u!=null){
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("user", u);
              ExternalContext ectx = facesContext.getExternalContext();
            Cookie[] cookies = ((HttpServletRequest)ectx .getRequest()).getCookies();
            if(cookies!=null){
                 System.out.println("size cookies  "+cookies.length);
            for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("lastAccessDate")){
                   System.out.println("cooooooooki******** "+cookie.getValue());
                     session.setAttribute("lastAccess", cookie.getValue());
                    }
                }
            }
	 // facesContext.getExternalContext().redirect("/GestionProduit/faces/resources/glammy/pages/product-page.xhtml");
         if(session.getAttribute("page") !=null){
             String page=(String) session.getAttribute("page") ;
             session.removeAttribute("page");
             facesContext.getExternalContext().redirect("/GestionProduit/faces/"+page);
         } 
         facesContext.getExternalContext().redirect("/GestionProduit/faces/index.xhtml");
	} else {
		FacesContext.getCurrentInstance().addMessage(
		null,new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			//facesContext.getExternalContext().redirect("index.html"); "l";
		}
       
         
        
    }
    
    //logout event, invalidate session
	public void logout() throws IOException {
		 FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
               
                ExternalContext ectx = facesContext.getExternalContext();
                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
               Cookie cookie = new Cookie("lastAccessDate", new Date().toString());
                 response.addCookie(cookie);
                Cookie[] cookies = ((HttpServletRequest)ectx .getRequest()).getCookies();
                if(cookies == null){
                    System.out.println("Cooki nuuuul");
                
               cookie.setDomain("localhost");
                cookie.setPath("/");
                cookie.setMaxAge(1000000000); 
                }
                System.out.println("5rajt mnull");
                 System.out.println("size: "+cookies.length);
                for (Cookie c : cookies) {
                      System.out.println("Naaaaaaaaaaaame "+c.getName());
                      System.out.println("Date "+c.getValue());
                    if (c.getName().equals("lastAccessDate")){
                      
                         System.out.println("Logouttt set lastaceess");
                         
                   c.setValue(new Date().toString());
                    }
                    else {
                                System.out.println("nom cookie incorrecte !"); }
                }
		session.invalidate();
                 facesContext.getExternalContext().redirect("/GestionProduit/faces/my-account.xhtml");
		//return "my-account.xhtml";
	}
    
}
