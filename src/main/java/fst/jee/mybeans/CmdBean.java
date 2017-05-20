/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.mybeans;

import fst.jee.entity.Cmd;
import fst.jee.entity.Panier;
import fst.jee.entity.Produit;
import fst.jee.entity.User;
import fst.jee.services.CmdService;
import fst.jee.services.ProdService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author souha
 */
@Named(value = "cmdBean")
@RequestScoped
public class CmdBean {

    /**
     * Creates a new instance of AchatBean
     */
    FacesContext facesContext = FacesContext.getCurrentInstance();
    CmdService cS=new CmdService();
    private User user;
    private List<Cmd> all;
    
    private List<Cmd> cmdNonValidImm;
    private List<Cmd> cmdNonValidEnch;

    public List<Cmd> getCmdNonValidImm() {
        for(Cmd c: all){
            if(c.getValide()&&((c.getIdprod()).getUser()).getId()==user.getId() && c.getIdprod().getTypeachat()==0){
               cmdNonValidImm.add(c);
            }
        }
        return cmdNonValidImm;
    }

    public void setCmdNonValidImm(List<Cmd> cmdNonValidImm) {
        this.cmdNonValidImm = cmdNonValidImm;
    }

    public List<Cmd> getMesVentesEnch() {
        for(Cmd c: all){
            if(c.getValide()&&((c.getIdprod()).getUser()).getId()==user.getId() && c.getIdprod().getTypeachat()==1){
                mesVentesEnch.add(c);
            }
        }
        return mesVentesEnch;
    }

    public void setMesVentesEnch(List<Cmd> mesVentesEnch) {
        this.mesVentesEnch = mesVentesEnch;
    }
    private List<Cmd> mesVentesImm;
    private List<Cmd> mesVentesEnch;
    public User getUser() {
        return user;
    }

    public List<Cmd> getCmdNonValidEnch() {
        for(Cmd c: all){
            if(!c.getValide()&&((c.getIdprod()).getUser()).getId()==user.getId() && c.getIdprod().getTypeachat()==1){
                cmdNonValidEnch.add(c);
            }
        }
        return cmdNonValidEnch;
    }

    public void setCmdNonValidEnch(List<Cmd> cmdNonValid) {
        this.cmdNonValidEnch = cmdNonValid;
    }

    public List<Cmd> getMesVentesImm() {
         for(Cmd c: all){
            if(c.getValide() && ((c.getIdprod()).getUser()).getId()==user.getId() && c.getIdprod().getTypeachat()==0){
                mesVentesImm.add(c);
            }
        }
        return mesVentesImm;
    }

    public void setMesVentesImm(List<Cmd> mesVentes) {
        this.mesVentesImm = mesVentes;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public List<Cmd> getAll() {
        return all;
    }

    public void setAll(List<Cmd> all) {
        this.all = all;
    }

   private List<Cmd> achatImm;
   private List<Cmd> achatEnch;

    public List<Cmd> getAchatImm() {
        for(Cmd c: all){
            if(c.getValide() && ((c.getIduser()).getId())==user.getId() && c.getIdprod().getTypeachat()==0){
                achatImm.add(c);
            }
        }
        return achatImm;
    }

    public void setAchatImm(List<Cmd> achatImm) {
        this.achatImm = achatImm;
    }

    public List<Cmd> getAchatEnch() {
         for(Cmd c: all){
            if(c.getValide() && ((c.getIduser()).getId())==user.getId() && c.getIdprod().getTypeachat()==1){
                achatEnch.add(c);
            }
        }
        return achatEnch;
    }

    public void setAchatEnch(List<Cmd> achatEnch) {
        this.achatEnch = achatEnch;
    }
   
    private List<Cmd> achatAttenteImm;
    
    //sayé walet mte3i ama nestana validation vendeur
    private List<Cmd> achatAttenteEnch;

    public List<Cmd> getAchatAttenteImm() {
        for(Cmd c: all){
            if(!c.getValide() && ((c.getIduser()).getId())==user.getId() && c.getIdprod().getTypeachat()==0){
                achatEnch.add(c);
            }
        }
        return achatAttenteImm;
    }

    public void setAchatAttenteImm(List<Cmd> achatAttenteImm) {
        this.achatAttenteImm = achatAttenteImm;
    }

    public List<Cmd> getAchatAttenteEnch() {
        for(Cmd c: all){
            if(!c.getValide() && ((c.getIduser()).getId())==user.getId() && c.getIdprod().getTypeachat()==1){
                achatEnch.add(c);
            }
        }
        
        
        return achatAttenteEnch;
    }

    public void setAchatAttenteEnch(List<Cmd> achatAttenteEnch) {
        this.achatAttenteEnch = achatAttenteEnch;
    }
    
    public void delete(Cmd p){
        cS.deleteCmd(p.getIdcmd());
    }
    
    
    public CmdBean() {
        
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
       // user=(User)session.getAttribute("user");
        /*String id = (String) facesContext.getExternalContext().getRequestParameterMap().get("idProd");
        if(id!=null){
            ProdService p=new ProdService();
            prod=p.findById(Integer.parseInt(id));
        }*/
        user=new User(1);
        cmdNonValidImm=new ArrayList();
        cmdNonValidEnch=new ArrayList();
        mesVentesEnch=new ArrayList();
        mesVentesImm=new ArrayList();
        
         achatAttenteEnch=new ArrayList();
         achatAttenteImm=new ArrayList();
         achatEnch=new ArrayList();
         achatImm=new ArrayList();
        all=cS.selectAll();
        
    }
   
 public void verifCnx(String page,Panier p) throws IOException{
     System.out.println("verifCn");
     System.out.println("panierrr"+p.getQtt());
      HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            if(session.getAttribute("user")==null){
                 page=page+"?id="+p.getIdprod().getId();
                session.setAttribute("page", page);
                
                facesContext.getExternalContext().redirect("my-account.xhtml");
            
            }
            else save2(p,session);
 }
 
        public void save2(Panier p,HttpSession session) throws IOException{
            System.out.println("Save2");
            User u=(User) session.getAttribute("user");
            Cmd c=new Cmd(p.getIdprod(),u,p.getQtt(),p.getColor(),p.getTaille());
            session.setAttribute("cmd",c);
            facesContext.getExternalContext().redirect("checkout.xhtml");
        }   
 
    public void cmdSave(Cmd c) throws IOException{
        System.out.println("CMDSAVE");
        /*
        ProdService pServ=new ProdService();String id = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
        System.out.println("ProductDetail Bean: "+id);
        int idiya=Integer.parseInt(id);
        System.out.println("ProductDetail Bean: idiya $$$$: "+idiya);
       Produit p=pServ.findById(idiya);
        c.setIduser(user);
        c.setIdprod(p);*/
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
       Cmd temp=(Cmd)     session.getAttribute("cmd");
       c.setIdprod(temp.getIdprod());
       c.setIduser(temp.getIduser());
       c.setQtt(temp.getQtt());
       c.setColor(temp.getColor());
       c.setTaille(temp.getTaille());
               
        cS.saveCmd(c);
        facesContext.getExternalContext().redirect("checkout2.xhtml");
        
    }
    public void validerCmd(Cmd c){
        cS.valider(c);
    }
}
