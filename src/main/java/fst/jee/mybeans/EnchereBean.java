/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.mybeans;

import fst.jee.entity.Enchere;
import fst.jee.entity.Produit;
import fst.jee.entity.User;
import fst.jee.services.EnchereService;
import fst.jee.services.ProdService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author souha
 */
@Named(value = "enchereBean")
@RequestScoped
public class EnchereBean {

    /**
     * Creates a new instance of EnchereBean
     */
    FacesContext facesContext = FacesContext.getCurrentInstance();
     EnchereService  eS=new EnchereService();
    
    private float montant;
    private List<Enchere> listEnchParUser;
    private List<Enchere> listEnchParProd;
    
    private List<Enchere> listEnchParVendeur;
    private float prixMaxParProd;
    private List<Enchere> all;
    public List<Produit> getListEnchParVendeur() {
        ProdService pS=new ProdService();
       return pS.findByIdUserByType(u.getId(), 0);
    }

    public void setListEnchParVendeur(List<Enchere> listEnchParVendeur) {
        
        this.listEnchParVendeur = listEnchParVendeur;
    }
    
    private User u;
    private Produit prod;

    public void updateMontant(){
        eS.updateMontant(u.getId(), montant);
    }
    
    public EnchereBean() {
        
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        u=(User)session.getAttribute("user");
        String id = (String) facesContext.getExternalContext().getRequestParameterMap().get("idProd");
        if(id!=null){
            ProdService p=new ProdService();
            prod=p.findById(Integer.parseInt(id));
        }
        all=eS.selectAll();
        listEnchParUser=new ArrayList();
        listEnchParProd=new ArrayList();
       
    }
    public float maxMontantParUserParProd(int prod,int u){
        float max=-1;
    
        for(Enchere e : all){
           
            if(e.getIduser().getId()==u && e.getIdprod().getId()==prod){
                if(e.getMontant()>max)
                    max=e.getMontant();
            }
    }
    
    return max;
  }
    public List<Enchere> getListEnchParUser() {
        
        for(Enchere e : all){
            System.out.println("date limite"+e.getIdprod().getDatelimite());
            System.out.println("date Aujour"+new Date());
           Date date1=e.getIdprod().getDatelimite();
           Date date2=new Date();
            System.out.println("bool"+(date2.compareTo(date1)<0) );
            if(e.getIduser().getId()==u.getId() && date2.compareTo(date1)<0 ){
                listEnchParUser.add(e);
            }
        }
        return listEnchParUser;
    }

    public void setListEnchParUser(List<Enchere> listEnchParUser) {
        this.listEnchParUser = listEnchParUser;
    }

    public List<Enchere> getListEnchParProd(int id) {
        
        return eS.findByProd(id);
    }

    public void setListEnchParProd(List<Enchere> listEnchParProd) {
        this.listEnchParProd = listEnchParProd;
    }

    public float getPrixMaxParProd() {
        return eS.maxPrixParProd(prod.getId());
    }
    
    public Enchere getPrixMaxParam(Produit prod) {
         
                return eS.maxPrixParProdReturnEnch(prod.getId());
    }
    
    
    
    public void setPrixMaxParProd(int prixMaxParProd) {
        this.prixMaxParProd = prixMaxParProd;
    }
    
    
    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        System.out.println("seeeeeeeeeeeeeeeeeeeeeeeeet");
        this.montant = montant;
    }
   
    public void validateMontant(FacesContext context, UIComponent comp,
			Object value){
        System.out.println("inside validate method");
        if(montant <= getPrixMaxParProd()){
            
        }
    }
    
   
    public void save(String page,int idp) throws IOException{
        System.out.println("Save enchere");
        System.out.println("Montant"+montant);
        System.out.println("Max par prod: "+getPrixMaxParProd());
        
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            if(session.getAttribute("user")==null){
                page=page+"?id="+idp;
                session.setAttribute("page", page);
                
                facesContext.getExternalContext().redirect("my-account.xhtml");
            
            }
        
        
        /*if(montant <= getPrixMaxParProd()){
            System.out.println("77777777777777777777");
           
              
            
        }*/
        else{
               System.out.println("fl else");
        Enchere e=new Enchere();
        User u =new User(1);
        e.setIduser(u);
        e.setIdprod(prod);
        e.setMontant(montant);
        e.setDatemodif(new Date());
        eS.saveEnchere(e);
       facesContext.getExternalContext().redirect("/GestionProduit/faces/enchereDateLimiteMazel.xhtml");
            }
       //return 1;
       // }
        /*
             FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "summary", "details");
        FacesContext.getCurrentInstance().addMessage("msg", facesMsg);*/
  /* FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succée","Nouvelle solde: ");
  RequestContext.getCurrentInstance().showMessageInDialog(message);  */ 
    }
   public boolean compareDateTrueIfWfet(Date d){
        Date date1=new Date();
        if (date1.compareTo(d) > 0) {
            return true;
        } else if (date1.compareTo(d) <= 0) {
           return false;
        } 
        return false;
    }
    
        public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
    
    public void delete(Enchere e){
        eS.deleteEnchere(e.getId());
    }
}
