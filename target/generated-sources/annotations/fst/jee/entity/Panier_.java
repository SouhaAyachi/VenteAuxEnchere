package fst.jee.entity;

import fst.jee.entity.Produit;
import fst.jee.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T06:55:34")
@StaticMetamodel(Panier.class)
public class Panier_ { 

    public static volatile SingularAttribute<Panier, Produit> idprod;
    public static volatile SingularAttribute<Panier, Integer> qtt;
    public static volatile SingularAttribute<Panier, User> iduser;
    public static volatile SingularAttribute<Panier, Integer> taille;
    public static volatile SingularAttribute<Panier, Integer> color;
    public static volatile SingularAttribute<Panier, Integer> idcmd;
    public static volatile SingularAttribute<Panier, Date> datecmd;
    public static volatile SingularAttribute<Panier, Integer> payer;

}