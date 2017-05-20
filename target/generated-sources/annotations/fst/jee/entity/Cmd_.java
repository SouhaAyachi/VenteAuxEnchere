package fst.jee.entity;

import fst.jee.entity.Produit;
import fst.jee.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-08T06:55:34")
@StaticMetamodel(Cmd.class)
public class Cmd_ { 

    public static volatile SingularAttribute<Cmd, User> iduser;
    public static volatile SingularAttribute<Cmd, String> ville;
    public static volatile SingularAttribute<Cmd, Integer> color;
    public static volatile SingularAttribute<Cmd, String> mail;
    public static volatile SingularAttribute<Cmd, String> city;
    public static volatile SingularAttribute<Cmd, Integer> idcmd;
    public static volatile SingularAttribute<Cmd, Date> dateCmd;
    public static volatile SingularAttribute<Cmd, Date> datecmd;
    public static volatile SingularAttribute<Cmd, Boolean> valide;
    public static volatile SingularAttribute<Cmd, String> nom;
    public static volatile SingularAttribute<Cmd, Integer> codePostale;
    public static volatile SingularAttribute<Cmd, Produit> idprod;
    public static volatile SingularAttribute<Cmd, Integer> qtt;
    public static volatile SingularAttribute<Cmd, Date> dateValide;
    public static volatile SingularAttribute<Cmd, Integer> taille;
    public static volatile SingularAttribute<Cmd, String> street;
    public static volatile SingularAttribute<Cmd, Integer> tel;
    public static volatile SingularAttribute<Cmd, String> prenom;
    public static volatile SingularAttribute<Cmd, Integer> pays;

}