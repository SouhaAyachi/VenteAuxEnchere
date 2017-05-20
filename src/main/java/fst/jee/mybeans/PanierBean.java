/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.mybeans;

import fst.jee.entity.Panier;
import fst.jee.entity.Produit;
import fst.jee.entity.User;
import fst.jee.services.PanierService;
import fst.jee.services.ProdService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author souha
 */
@Named(value = "panierBean")
@RequestScoped
public class PanierBean {

    /**
     * Creates a new instance of PanierBean
     */
    FacesContext facesContext = FacesContext.getCurrentInstance();
     PanierService panServ=new PanierService();
    List<Panier> prod;
    private float totale=0;
    private int nb;
    
    

    public int getNb() {
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        if(session!=null)
        return getProd().size();
        else
        return 0;
    }

    public void setNb(int nb) {
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        this.nb = nb;
    }

    public float getTotale() {
        return totale;
    }

    public void setTotale(float totale) {
        this.totale = totale;
    }
   public void add(float x){
        totale+=x;
    }
    public List<Panier> getProd() {
        
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        prod=panServ.findByUser(((User)session.getAttribute("user")).getId());//((User)session.getAttribute("user")).getId()
        return prod;
    }

    public void setProd(List<Panier> prod) {
        this.prod = prod;
    }
   
    public PanierBean() {
    }
    public void delete(Panier p) throws IOException{
        panServ.deleteCmd(p.getIdcmd());
        facesContext.getExternalContext().redirect("shopping_bag.xhtml");
    }
   
    
    public void save(Panier c,String page,int idp) throws IOException{
        
        
        System.out.println("***************commmmmmmande ************");
        System.out.println("id save panier: "+idp);
        //c.setIdprod(new Produit(30));
        
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            if(session.getAttribute("user")==null){
                page=page+"?id="+idp;
                session.setAttribute("page", page);
                
                facesContext.getExternalContext().redirect("my-account.xhtml");
            
            }
            else{
                 String p = (String) facesContext.getExternalContext().getRequestParameterMap().get("prod");
                int id=Integer.parseInt(p);
                ProdService pserv=new ProdService();
                Produit prod=pserv.findById(id);
                c.setIdprod(prod);
                User user=(User) session.getAttribute("user");
            c.setIduser(user);//(User)session.getAttribute("user")
            c.setDatecmd(new Date());
            c.setPayer(0);
            
           /* FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("panier", c.toString(), null);
            Map<String, Object> requestCookieMap = FacesContext.getCurrentInstance()
            .getExternalContext()
            .getRequestCookieMap();
            System.out.println(((Panier)requestCookieMap.get("panier")).getQtt());*/
 
            panServ.saveCmd(c);
            facesContext.getExternalContext().redirect("shopping_bag.xhtml");
     }
        
    }
}
