/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.services;

import fst.jee.entity.Panier;
import fst.jee.entity.Produit;
import fst.jee.entity.User;
//import java.sql.Date;
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
public class PanierService {
    
    private static final String JPA_UNIT_NAME = "com.fst.if4.PFA.Ecole_GestionProduit_war_1.0-SNAPSHOTPU";
   private EntityManager entityManager;
    
      protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}
      
      public List<Panier> selectAll() {
		List<Panier> cmds = getEntityManager().createQuery(
				"select c from Panier c").getResultList();
                 
		return cmds;
	}
    
      public Panier findByid(int id){
          Panier p = (Panier) (getEntityManager().createNamedQuery("Panier.findById").setParameter("id",id ).getSingleResult());
          return p;
      }
      
      public List<Panier> findByUser(int id){
          List<Panier> p =  getEntityManager().createNamedQuery("Panier.findByIduser").setParameter("iduser",id ).getResultList();
          return p;
      }
      
      public List<Panier> findByProd(int id){
          List<Panier> p = getEntityManager().createNamedQuery("Panier.findByIdprod").setParameter("idprod",id ).getResultList();
          return p;
      }
      
      public void deleteCmd(int id){
        getEntityManager().getTransaction( ).begin( );
        Panier p = getEntityManager().find(Panier.class, id );
        getEntityManager().remove( p );
        getEntityManager().getTransaction( ).commit( );
       // prodfactory.close( );
    }
      
    public void saveCmd(Panier p){
        getEntityManager().getTransaction( ).begin( );
        getEntityManager().persist( p);
        getEntityManager().getTransaction( ).commit( );
        //getEntityManager().close( );
   }  
      public static void main( String[ ] args ) {
         
         PanierService gerer=new PanierService();
         Produit p=new Produit(30);
          User u=new User(1);
         //save
         /*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); 
         User u=new User(1);
         Panier c=new Panier(p,u,date);
         gerer.saveProduit(c);*/
         
         //save
         List<Panier>cmds=gerer.selectAll();
         for(Panier i: cmds){
             System.out.println("All cmd: "+i.getIduser().getNom());
         }
         //By prod
        
         List<Panier> c2=gerer.findByProd(30);
         for(Panier i: c2){
             System.out.println("find by prod"+i.getIduser().getNom());
         }
         
         //User
         List<Panier> c3=gerer.findByUser(1);
         for(Panier i: c3){
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
