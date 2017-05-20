package fst.jee.entity;

import fst.jee.entity.Produit;
import fst.jee.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T06:55:34")
@StaticMetamodel(Enchere.class)
public class Enchere_ { 

    public static volatile SingularAttribute<Enchere, Produit> idprod;
    public static volatile SingularAttribute<Enchere, User> iduser;
    public static volatile SingularAttribute<Enchere, Float> montant;
    public static volatile SingularAttribute<Enchere, Integer> id;
    public static volatile SingularAttribute<Enchere, Date> datemodif;

}