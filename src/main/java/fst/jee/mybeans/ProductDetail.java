/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.mybeans;

import fst.jee.entity.Produit;
import fst.jee.services.EnchereService;
import fst.jee.services.ProdService;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 
 * @author souha
 */
@Named(value = "productDetail")
@RequestScoped
public class ProductDetail implements Serializable{
   
    ProdService pServ=new ProdService();
    EnchereService ench=new EnchereService();
    Produit p=new Produit();
    List<Produit> listProducts;
    //@ManagedProperty(value="#{param.id}")
    //private String id;
 private boolean testImm;
 private boolean testEnch;

 public ProductDetail() {
       listProducts= pServ.selectAll();
 }
    public boolean isTestEnch() {
         //if(getP().getTypeachat()==1)
            return true;
       // return false;
    }

    public void setTestEnch(boolean testEnch) {
        this.testEnch = testEnch;
    }

    public boolean isTestImm() {
      //  if(getP().getTypeachat()==0)
            return (getP().getTypeachat()==0);
       // return false;
    }

    public void setTestImm(boolean test) {
        this.testImm = test;
    }
    public ProdService getpServ() {
        return pServ;
    }

    public void setpServ(ProdService pServ) {
        this.pServ = pServ;
    }

    public Produit getP() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String id = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
        //System.out.println("ProductDetail Bean: "+id);
        int idiya=Integer.parseInt(id);
       // System.out.println("ProductDetail Bean: idiya $$$$: "+idiya);
        p=pServ.findById(idiya);
        //System.out.println("ProductDetail Bean :p.designation $$$$: "+p.getDesignation());
        return p;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    /*public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/
    /**
     * Creates a new instance of ProductDetail
     */
    
    
    /*@PostConstruct
    public void init (){
        testImm=(getP().getTypeachat()==0);
        testEnch=(getP().getTypeachat()==1);
        p=getP();
        
    }*/
    public void  moveToThePage() throws IOException{
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String id = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
        System.out.println("id $$$: "+id);
        int idiya=Integer.parseInt(id);
        System.out.println("idiya $$$$: "+idiya);
        p=pServ.findById(idiya);
          System.out.println("p.designation $$$$: "+p.getDesignation());
        facesContext.getExternalContext().redirect("resources/glammy/pages/product-page.xhtml");
        //return "resources/glammy/pages/product-page.xhtml";
    }
    
    public float getPrixMaxEnch(){
       return ench.maxPrixParProd(p.getId());
    }
        
    
}
