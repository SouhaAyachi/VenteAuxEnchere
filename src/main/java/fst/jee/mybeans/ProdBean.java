/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.mybeans;

import fst.jee.entity.Produit;
import fst.jee.entity.SousCat;
import fst.jee.entity.User;
import fst.jee.services.ProdService;
import fst.jee.services.SousCatService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author souha
 */
@Named(value = "prodBean")
@RequestScoped
public class ProdBean implements Serializable {

    /**
     * Creates a new instance of ProdBean
     */
    
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ProdService pGerer=new ProdService();
   // Produit prod=new Produit();
    private List<Produit> products;
    
    private List<Produit> prodByCatImm;
    private List<Produit> prodByCatEnch;

    public List<Produit> getProdByCatImm() {
        System.out.println("lhamdellah");
         String p = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
        int id=Integer.parseInt(p);
        return pGerer.findByCatByTypeByQttNotNull(id,0);
    }

    public void setProdByCatImm(List<Produit> prodByCatImm) {
        this.prodByCatImm = prodByCatImm;
    }

    public List<Produit> getProdByCatEnch() {
         String p = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
         int id=Integer.parseInt(p);
        return pGerer.findByCatByTypeByQttNotNull(id,1);
    }

    public void setProdByCatEnch(List<Produit> prodByCatEnch) {
        this.prodByCatEnch = prodByCatEnch;
    }

    public List<Produit> getProductActifEnch() {
        
        System.out.println("siiiiiiiize actif ench*******: "+pGerer.findByIdUserByTypeByQttNotNull(1,1).size());
        
        return pGerer.findByIdUserByTypeByQttNotNull(user.getId(),1);
//user.getId()
       
    }

    public void setProductActifEnch(List<Produit> productActifEnch) {
        this.productActifEnch = productActifEnch;
    }

    
    private UploadedFile uploadedFile;
    
    private List<Produit> productActifImm;

    public Produit getProd() {
        return prod;
    }

    public void setProd(Produit prod) {
        this.prod = prod;
    }
    private List<Produit> productActifEnch;
   
    //@ManagedProperty(value="#{produit}")
    private Produit prodToUpdate;//=new Produit();
    
    //@ManagedProperty(value="#{produit}")
    private  Produit prod;

    public Produit getProdToUpdate() {
        
        System.out.println("get DEb******");
        prodToUpdate=new Produit();
        String p = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
        int id=Integer.parseInt(p);
      //  prodToUpdate.UpdateProduit(pGerer.findById(id));
        
       // System.out.println("dessss"+prodToUpdate.getDesignation());
        System.out.println("get fin ******");
        System.out.println("Class :  "+(pGerer.findById(id)).getClass());
       //  prodToUpdate.setDesignation("ya allah ya rabi");
        return pGerer.findById(id);
    }

    public void setProdToUpdate(Produit prod) {
        System.out.println("$$$$$ seeeeeeet $$$$$$$");
        this.prodToUpdate = prod;
    }
    
    
    //private List<Produit> productActifImm;
    User user;
    
    public ProdBean() {
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        user=(User)session.getAttribute("user");
        // user=new User(1);
         prodToUpdate=new Produit();
         products = pGerer.selectAll();
         productActifImm=new ArrayList();
    }
    
    public void getProdByCatPrice(){
        List<Produit> list=new ArrayList();
        for(Produit p :products){
           // if(p.cat=cat && p.prix>=min && p.prix<=max)
                list.add(p);
        }
    }
    
     public void getProdByCatColor(){
        for(Produit p :products){
            
        }
    }
     
    public void getProdByCatTaille(){
        /* String id = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
        int cat=Integer.parseInt(id);
        String taille= (String) facesContext.getExternalContext().getRequestParameterMap().get("taille");       
        for(Produit p :products){
            if(p.getCat().getId()==cat && p.get)
        }*/
    } 
     
     public List<Produit> getProdByCatMarque(){
         System.out.println("Bonjour");
       List<Produit> list=new ArrayList();
        String id = (String) facesContext.getExternalContext().getRequestParameterMap().get("id");
        int cat=Integer.parseInt(id);
        //System.out.println("cat "+cat);
        String marque= (String) facesContext.getExternalContext().getRequestParameterMap().get("marque");       
        //System.out.println("marque "+marque);
        for(Produit p :products){
            if(p.getCat().getId()==cat && p.getMarque().equals(marque))
                list.add(p);
        }
        return list;
        
    } 
    
    public void aaa() throws IOException{
        System.out.println("hhhhh");
        facesContext.getExternalContext().redirect("myActifProducts.xhtml");
    }
    
    public void update() throws IOException{
        //this.setProdToUpdate(p);
        System.out.println("uppppppppppdddddddddaaaaaaaaate");
        pGerer.updateProd(prodToUpdate);
        //facesContext.getExternalContext().redirect("myActifProducts.xhtml");
    }
    
    public List<Produit> getProductActifImm(){
        System.out.println("siiiiiiii*******: "+pGerer.findByIdUserByTypeByQttNotNull(1,0).size());
        
        return pGerer.findByIdUserByTypeByQttNotNull(user.getId(),0);//user.getId()
    }
    
    public void deleteProd(Produit p) throws IOException{
        
        pGerer.deleteProd(p.getId());
        System.out.println("deeteeeeeeeeee");
        facesContext.getExternalContext().redirect("myActifProducts.xhtml");
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public List<Produit> getProducts() {
        if(products==null){
            System.out.println("proooooooood");
		products = pGerer.selectAll();
        }
        return products;
    }
    
    
    private int idCat=-1;

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }
    public void save(Produit prod){
        String pathDisque="/home/souha/GestionProduit/src/main/webapp/resources/img/";
        String pathBase="http://localhost:8086/GestionProduit/faces/resources/img/";
        //FacesContext facesContext = FacesContext.getCurrentInstance();
      HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
      
        
        if(uploadedFile != null && idCat!=-1) {
            System.out.println("uploaaaaaaad");
            FacesMessage message = new FacesMessage("Succesful", uploadedFile.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
             try {
        
        InputStream in = uploadedFile.getInputstream();
        String fileName = uploadedFile.getFileName();
        System.out.println("filename: "+fileName);

        // write the inputStream to a FileOutputStream            
        OutputStream out = new FileOutputStream(new File(pathDisque + fileName));
        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = in.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        in.close();
        out.flush();
        out.close();
        System.err.println("New file created!");
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
             
             SousCatService sCat=new SousCatService();
             SousCat c=sCat.findById(idCat);
             prod.setCat(c);
             prod.setUser(user);
    }
        prod.setDateajout(new Date());
        prod.setImg1(pathBase+uploadedFile.getFileName());
        prod.setUser((User)session.getAttribute("user"));
        
        
        if(prod.getDatelimite()!=null)
            prod.setTypeachat(1);// 1 ==>  enchere
        else prod.setTypeachat(0); //0 ==> immédiat
        
        pGerer.saveProduit(prod);
        
    }

    public void setProducts(List<Produit> products) {
        this.products = products;
    }
    
}
