/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.services;

import fst.jee.entity.Cmd;
import fst.jee.entity.Produit;
import fst.jee.entity.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author souha
 */
public class CmdService {
       private static final String JPA_UNIT_NAME = "com.fst.if4.PFA.Ecole_GestionProduit_war_1.0-SNAPSHOTPU";
   private EntityManager entityManager;
   ProdService ps=new ProdService();
    
      protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}
      
      public List<Cmd> selectAll() {
		List<Cmd> cmds = getEntityManager().createQuery(
				"select c from Cmd c").getResultList();
                 
		return cmds;
	}
    
      public Cmd findByid(int id){
          Cmd p = (Cmd) (getEntityManager().createNamedQuery("Cmd.findById").setParameter("id",id ).getSingleResult());
          return p;
      }
      
      public List<Cmd> findByUser(int id){
          List<Cmd> p =  getEntityManager().createNamedQuery("Cmd.findByIduser").setParameter("iduser",id ).getResultList();
          return p;
      }
      
      
      
      
      public List<Cmd> findByProd(int id){
          List<Cmd> p = getEntityManager().createNamedQuery("Cmd.findByIdprod").setParameter("idprod",id ).getResultList();
          return p;
      }
      
      
      public void deleteCmd(int id){
        getEntityManager().getTransaction( ).begin( );
        Cmd p = getEntityManager().find(Cmd.class, id );
        getEntityManager().remove( p );
        getEntityManager().getTransaction( ).commit( );
       getEntityManager().close( );
       // prodfactory.close( );
    }
      
    public void saveCmd(Cmd p){
        getEntityManager().getTransaction( ).begin( );
        getEntityManager().persist( p);
        getEntityManager().getTransaction( ).commit( );
        //getEntityManager().close( );
   }  
    
    public void valider(Cmd c){
          getEntityManager().getTransaction( ).begin( );
          c.setValide(true);
          c.setDateValide(new Date());
          int nouvoQtt=((c.getIdprod()).getQtt())-c.getQtt();
          int id=c.getIdprod().getId();
          ps.updateQtt(id, nouvoQtt);
          getEntityManager().merge(c);
          getEntityManager().getTransaction( ).commit( );
    } 
      public static void main( String[ ] args ) {
         
         CmdService gerer=new CmdService();
         Produit p=new Produit(30);
         User u=new User(1);
         //save
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date date = new Date();
         System.out.println(dateFormat.format(date));
         Cmd c=new Cmd(p,u,new Date());
         gerer.saveCmd(c);
         
         //save
         /*List<Achats>cmds=gerer.selectAll();
         for(Cmd i: cmds){
             System.out.println("All Achat: "+i.getIduser().getNom());
         }
         //By prod
        
         List<Achats> c2=gerer.findByProd(30);
         for(Cmd i: c2){
             System.out.println("find by prod"+i.getIduser().getNom());
         }
         
         //User
         List<Achats> c3=gerer.findByUser(1);
         for(Cmd i: c3){
             System.out.println("find by user"+i.getIduser().getNom());
         }
         
        /* gerer.selectAllUsers();
         gerer.saveProduit(p);*/
         
       /* List<Produit> ps=gerer.findByCat(2);
        System.out.println("Size: Products: "+ps.size());
        
        Produit p2=gerer.findById(28);
        System.out.println("des: "+p2.getDesignation());*/
     }
    
}
