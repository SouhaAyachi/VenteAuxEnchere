/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.services;
import fst.jee.entity.Produit;
import fst.jee.entity.User;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

/**
 *
 * @author souha
 */
public class UserService {
    
   private static final String JPA_UNIT_NAME = "com.fst.if4.PFA.Ecole_GestionProduit_war_1.0-SNAPSHOTPU";
   private EntityManager entityManager;
    
      protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}
      
      public List<User> selectAll() {
		List<User> users = getEntityManager().createQuery(
				"select p from User p").getResultList();
                 
		return users;
	}
      
      public List<Produit> selectAllProduct() {
		List<Produit> products = getEntityManager().createQuery(
				"select p from Produit p").getResultList();
                 
		return products;
	}


    public void saveUser(User p){
        getEntityManager().getTransaction( ).begin( );
        getEntityManager().persist( p);
        getEntityManager().getTransaction( ).commit( );
        FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("user", p);
        //getEntityManager().close( );
   }
    
    void modifProd(){
        
    }
    public User findByLoginPwd(String login,String pwd){
       User user=null;
        System.out.println("login "+login);
         System.out.println("pwd "+pwd);
        String requete="select * from user where mdp='"+pwd+"' and login='"+login+"';";
        try{
          
        user = (User)  getEntityManager().createNativeQuery(requete,User.class).getSingleResult();
        }catch(Exception e){
           e.printStackTrace();
        }
        // System.out.println(user.getNom());
        return user;
        
    }
    
    void deleteProd(int id){
        getEntityManager().getTransaction( ).begin( );
        User p = getEntityManager().find( User.class, id );
        getEntityManager().remove( p );
        getEntityManager().getTransaction( ).commit( );
       getEntityManager().close( );
       // prodfactory.close( );
    }
    
    
     public static void main( String[ ] args ) {
         
         
        UserService gerer=new UserService();
         User p=new User(5,"rahma");
         gerer.saveUser(p);
         
         User u=gerer.findByLoginPwd("miloucha", "milou");
         System.out.println(u.getNom());
     }
    
}
