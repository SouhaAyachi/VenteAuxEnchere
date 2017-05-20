package fst.jee.entity;

import fst.jee.entity.SousCat;
import fst.jee.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T06:55:34")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, String> img4;
    public static volatile SingularAttribute<Produit, Integer> note;
    public static volatile SingularAttribute<Produit, String> img3;
    public static volatile SingularAttribute<Produit, Double> prix;
    public static volatile SingularAttribute<Produit, String> description;
    public static volatile SingularAttribute<Produit, String> paiment;
    public static volatile SingularAttribute<Produit, String> etat;
    public static volatile SingularAttribute<Produit, String> matiere;
    public static volatile SingularAttribute<Produit, String> marque;
    public static volatile SingularAttribute<Produit, Integer> qtt;
    public static volatile SingularAttribute<Produit, Date> dateajout;
    public static volatile SingularAttribute<Produit, Integer> typeachat;
    public static volatile SingularAttribute<Produit, SousCat> cat;
    public static volatile SingularAttribute<Produit, String> genre;
    public static volatile SingularAttribute<Produit, Integer> solde;
    public static volatile SingularAttribute<Produit, Date> datelimite;
    public static volatile SingularAttribute<Produit, Integer> id;
    public static volatile SingularAttribute<Produit, String> designation;
    public static volatile SingularAttribute<Produit, String> livraison;
    public static volatile SingularAttribute<Produit, User> user;
    public static volatile SingularAttribute<Produit, String> img2;
    public static volatile SingularAttribute<Produit, String> img1;

}