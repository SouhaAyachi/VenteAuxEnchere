/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.services;

import fst.jee.entity.Enchere;
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
public class EnchereService {
    
    private static final String JPA_UNIT_NAME = "com.fst.if4.PFA.Ecole_GestionProduit_war_1.0-SNAPSHOTPU";
   private EntityManager entityManager;
    
      protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}
      
      public List<Enchere> selectAll() {
		List<Enchere> cmds = getEntityManager().createNamedQuery("Enchere.findAll").getResultList();
                 
		return cmds;
	}
    public float maxPrixParProd(int id){
        try{
        Enchere p = (Enchere) (getEntityManager().createNativeQuery("select * from enchere where montant=(select max(montant) from enchere where idprod="+id+") and idprod="+id+";","enchereMapping").getSingleResult());
        return p.getMontant();
        }catch(Exception e){
        
          return -1;
        }
    }
      
    public Enchere maxPrixParProdReturnEnch(int id){
        try{
        Enchere p = (Enchere) (getEntityManager().createNativeQuery("select * from enchere where montant=(select max(montant) from enchere where idprod="+id+") and idprod="+id+";","enchereMapping").getSingleResult());
        return p;
        }catch(Exception e){
        
          return null;
        }
    }
      public Enchere findByid(int id){
          Enchere p = (Enchere) (getEntityManager().createNamedQuery("Enchere.findById").setParameter("id",id ).getSingleResult());
          return p;
      }
      
      public List<Enchere> findByUser(int id){
          List<Enchere> p =  getEntityManager().createNamedQuery("Enchere.findByIduser").setParameter("iduser",id ).getResultList();
          return p;
      }
      
      public List<Enchere> findByProd(int id){
          List<Enchere> p = getEntityManager().createNamedQuery("Enchere.findByIdprod").setParameter("idprod",id ).getResultList();
          return p;
      }
      public void updateMontant(int id,float m){
          getEntityManager().getTransaction( ).begin( );
          Enchere e=getEntityManager().find(Enchere.class,id);
          e.setMontant(m);
           getEntityManager().getTransaction( ).commit( );
      }
     public void deleteEnchere(int id){
        getEntityManager().getTransaction( ).begin( );
        Enchere p = getEntityManager().find(Enchere.class, id );
        getEntityManager().remove( p );
        getEntityManager().getTransaction( ).commit( );
       getEntityManager().close( );
       // prodfactory.close( );
    }
      
    public void saveEnchere(Enchere p){
        getEntityManager().getTransaction( ).begin( );
        getEntityManager().persist( p);
        getEntityManager().getTransaction( ).commit( );
        //getEntityManager().close( );
   }  
    
    public float maxEnch(int p){
        return (float)getEntityManager().createNamedQuery("Enchere.MaxEnch").setParameter("id",p).getSingleResult();
        
    }
      public static void main( String[ ] args ) {
         
         EnchereService gerer=new EnchereService();
       /* Produit p=new Produit(30);
          User u=new User(1);
         //save
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); 
         Enchere c=new Enchere(u,p);
         gerer.saveEnchere(c);*/
       System.out.println("montant avant change"+gerer.findByid(1).getMontant());
         gerer.updateMontant(1, 60);
         System.out.println("montant after change"+gerer.findByid(1).getMontant());
         System.out.println("Maax"+gerer.maxPrixParProd(30));
         
         System.out.println("Maax "+gerer.maxEnch(30));
         //save
        /* List<Enchere>e=gerer.selectAll();
         for(Enchere i: e){
             System.out.println("All Enchere: "+i.getIduser().getNom());
         }
         //By prod
        
         List<Enchere> c2=gerer.findByProd(30);
         for(Enchere i: c2){
             System.out.println("find by enchere"+i.getIduser().getNom());
         }
         
         //User
         List<Enchere> c3=gerer.findByUser(1);
         for(Enchere i: c3){
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
