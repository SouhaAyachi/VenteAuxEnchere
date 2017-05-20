/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Autowired annotation to inject an entitymanagerfactory

package fst.jee.services;


import fst.jee.entity.Produit;
import fst.jee.entity.SousCat;
import fst.jee.entity.User;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author souha
 * https://www.tutorialspoint.com/jpa/jpa_entity_managers.htm
 */
public class ProdService {
   private static final String JPA_UNIT_NAME = "com.fst.if4.PFA.Ecole_GestionProduit_war_1.0-SNAPSHOTPU";
   private EntityManager entityManager;
    
      protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}
      
      public List<Produit> selectAll() {
		List<Produit> products = getEntityManager().createQuery(
				"select p from Produit p").getResultList();  
		return products;
	}
      
      public List<User> selectAllUsers() {
		List<User> users = getEntityManager().createQuery(
				"select p from User p").getResultList();
                 
		return users;
	}

    public void saveProduit(Produit p){
        getEntityManager().getTransaction( ).begin( );
        getEntityManager().persist( p);
        getEntityManager().getTransaction( ).commit( );
        //getEntityManager().close( );
   }
    public Produit findById(int id) {
		Produit p = (Produit) (getEntityManager().createNamedQuery("Produit.findById").setParameter("id",id ).getSingleResult());
                 return p;
	}
    
    
    public List<Produit> findByCatByTypeByQttNotNull(int cat,int type) {
                //getEntityManager().getTransaction( ).begin( );
                String requete="select * from produit where cat="+cat +" and typeachat="+type+" and qtt>0 order by dateajout desc;";
		List<Produit> p =  getEntityManager().createNativeQuery(requete,"ProduitMapping").getResultList();
                //getEntityManager().getTransaction( ).commit( ); 
               return p;
	}
    
    
    
    public List<Produit> findByIdUserByTypeByQttNotNull(int user,int type) {
                //getEntityManager().getTransaction( ).begin( );
                String requete="select * from produit where user="+user +" and typeachat="+type+" and qtt>0 order by dateajout desc;";
		List<Produit> p =  getEntityManager().createNativeQuery(requete,"ProduitMapping").getResultList();
                //getEntityManager().getTransaction( ).commit( ); 
               return p;
	}
    
    public List<Produit> findByIdUserByTypeByQttNull(int user,int type) {
                
                String requete="select * from produit where user="+user +" and typeachat="+type+" and qtt=0 order by dateajout;";
		List<Produit> p =  getEntityManager().createNativeQuery(requete,"ProduitMapping").getResultList();
                 return p;
	}
    
     public List<Produit> findByIdUserByType(int user,int type) {
                
                String requete="select * from Produit where user=user and typeachat=type and qtt>0;";
		List<Produit> p =  getEntityManager().createNativeQuery(requete,"ProduitMapping").getResultList();
                 return p;
	}
    
    public List<Produit> findByCat(int id){
        String requete="select * FROM produit where cat="+id+" and qtt>0 and dateajout in(select dateajout from produit group by dateajout) order by dateajout desc,note desc ";
        //select * from produit where cat=3 and qtt>0 order by dateajout desc,note desc 
        //select * from produit where cat=3 and qtt>0 and dateajout in(select dateajout from produit group by dateajout) order by dateajout desc,note desc 
       
        
        List<Produit>p= getEntityManager().createNativeQuery(requete,"ProduitMapping").getResultList();
        
       /*INSERT INTO `produit` (`id`, `designation`, `description`, `cat`, `prix`, `solde`, `qtt`, `user`, `dateajout`, `vente`, `livraison`, `paiment`, `note`, `img1`, `img2`, `img3`, `img4`, `marque`, `etat`, `Genre`, `matiere`) VALUES (NULL, 'fbgvb', 'bgvb', '3', '45', NULL, '12', NULL, '2017-04-20', NULL, NULL, NULL, '60', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);*/      
	/*for(Produit prod: p){
            System.out.println("des***: "+prod.getDesignation());
            System.out.println("Class***: "+prod.getClass());
        }*/
       return p;
    }
    public void updateProd(Produit p){
         getEntityManager().getTransaction( ).begin( );
          //Produit upProd = getEntityManager().find( Produit.class, p.getId());
        getEntityManager().merge(p);
        getEntityManager().getTransaction( ).commit( );
       getEntityManager().close( );
    }
    
    public void deleteProd(int id){
        getEntityManager().getTransaction( ).begin( );
        Produit p = getEntityManager().find( Produit.class, id );
        getEntityManager().remove( p );
        getEntityManager().getTransaction( ).commit( );
       getEntityManager().close( );
       // prodfactory.close( );
    }
    public void updateQtt(int id,int qtt){
        getEntityManager().getTransaction( ).begin( );
        Produit p=this.findById(id);
        p.setQtt(qtt);
        getEntityManager().merge(p);
        getEntityManager().getTransaction( ).commit( );
    }
    
     public static void main( String[ ] args ) {
         
         ProdService gerer=new ProdService();
         Produit p=new Produit("aaaa","cdhchdchdjvh");
         gerer.selectAll();
        /* gerer.selectAllUsers();
         gerer.saveProduit(p);*/
         
        /*List<Produit> ps=gerer.findByCat(2);
        System.out.println("Size: Products: "+ps.size());
        
        Produit p2=gerer.findById(28);
        System.out.println("des: "+p2.getDesignation());*/
        
        
        System.out.println("sizzzzzzze: "+(gerer.findByIdUserByTypeByQttNotNull(1,0)).size());
     }
}
