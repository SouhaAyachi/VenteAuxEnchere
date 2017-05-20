/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.services;

import fst.jee.entity.SousCat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author souha
 */
public class SousCatService {
    private static final String JPA_UNIT_NAME = "com.fst.if4.PFA.Ecole_GestionProduit_war_1.0-SNAPSHOTPU";
   private EntityManager entityManager;
    
      protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}
      
      public List<SousCat> selectAll() {
		List<SousCat> sousCats = getEntityManager().createQuery(
				"select c from SousCat c").getResultList();
                 
		return sousCats;
	}
      
       public SousCat findById(int id) {
		SousCat sous = (SousCat) (getEntityManager().createNamedQuery("SousCat.findById").setParameter("id",id ).getSingleResult());
                        
                 
		return sous;
	}
      
      public List<SousCat> findByCat(int c) {
		List<SousCat> sousCats = getEntityManager().createNamedQuery("SousCat.findByCat")
                        .setParameter("cat",c ).getResultList();
                 
		return sousCats;
	}
    public void saveCat(SousCat c){
        getEntityManager().getTransaction( ).begin( );
        getEntityManager().persist( c);
        getEntityManager().getTransaction( ).commit( );
        //getEntityManager().close( );
   }
    
    void modifCat(){
        
    }
    
    void deleteCat(int id){
        getEntityManager().getTransaction( ).begin( );
        SousCat c = getEntityManager().find( SousCat.class, id );
        getEntityManager().remove( c );
        getEntityManager().getTransaction( ).commit( );
       getEntityManager().close( );
       // prodfactory.close( );
    }
    
    
     public static void main( String[ ] args ) {
         
         SousCatService gerer=new SousCatService();
        //SousCat c=new SousCat("robe","d'été,soirée,...",1);
         //gerer.saveCat(c);
     }
}
