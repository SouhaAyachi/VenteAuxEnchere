/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.entity;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author souha
 */

@ManagedBean
@Named(value="panier")
@SessionScoped

@Entity
@Table(name = "panier")
@XmlRootElement

@SqlResultSetMapping(
    name = "paniereMapping",
    entities = {
        @EntityResult(
            entityClass = Panier.class,
            fields = {
                @FieldResult(name = "idcmd", column = "idcmd"),
                @FieldResult(name = "iduser", column = "iduser"),
                @FieldResult(name = "idprod", column = "idprod"),
                @FieldResult(name = "datecmd", column = "datecmd"),
                @FieldResult(name = "color", column = "color"),
                @FieldResult(name = "qtt", column = "qtt"),
                @FieldResult(name = "taille", column = "taille"),
                @FieldResult(name = "payer", column = "payer")
            
            
            })}
        
)


@NamedQueries({
    @NamedQuery(name = "Panier.findAll", query = "SELECT c FROM Panier c"),
    @NamedQuery(name = "Panier.findByIdcmd", query = "SELECT c FROM Panier c WHERE c.idcmd = :idcmd"),
    @NamedQuery(name = "Panier.findByIdprod", query = "SELECT c FROM Panier c WHERE c.idprod.id = :idprod"),
    @NamedQuery(name = "Panier.findByIduser", query = "SELECT c FROM Panier c WHERE c.iduser.id = :iduser"),
    @NamedQuery(name = "Panier.findByDatecmd", query = "SELECT c FROM Panier c WHERE c.datecmd = :datecmd"),
    @NamedQuery(name = "Panier.findByColor", query = "SELECT c FROM Panier c WHERE c.color = :color"),
    @NamedQuery(name = "Panier.findByQtt", query = "SELECT c FROM Panier c WHERE c.qtt = :qtt"),
    @NamedQuery(name = "Panier.findByTaille", query = "SELECT c FROM Panier c WHERE c.taille = :taille"),
    @NamedQuery(name = "Panier.findByValide", query = "SELECT c FROM Panier c WHERE c.payer = :payer")})
public class Panier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcmd", nullable = false)
    private Integer idcmd;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idprod", referencedColumnName="id")
    private Produit idprod;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="iduser", referencedColumnName="id")
    private User iduser;
    
    @Column(name = "datecmd")
    @Temporal(TemporalType.DATE)
    private Date datecmd;
    @Column(name = "color")
    private Integer color;
    @Column(name = "qtt")
    private Integer qtt;
    @Column(name = "taille")
    private Integer taille;
    @Column(name = "payer")
    private Integer payer;

    public Panier() {
    }

    public Panier(Integer idcmd) {
        this.idcmd = idcmd;
    }
    
    public Panier( Produit idprod, User iduser, Date datecmd) {
        this.idprod = idprod;
        this.iduser = iduser;
        this.datecmd = datecmd;
    }
    
    public Panier(Integer idcmd, Produit idprod, User iduser, Date datecmd) {
        this.idcmd = idcmd;
        this.idprod = idprod;
        this.iduser = iduser;
        this.datecmd = datecmd;
    }

    public Integer getIdcmd() {
        return idcmd;
    }

    public void setIdcmd(Integer idcmd) {
        this.idcmd = idcmd;
    }

    public Produit getIdprod() {
        return idprod;
    }

    public void setIdprod(Produit idprod) {
        this.idprod = idprod;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public Date getDatecmd() {
        return datecmd;
    }

    public void setDatecmd(Date datecmd) {
        this.datecmd = datecmd;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getQtt() {
        return qtt;
    }

    public void setQtt(Integer qtt) {
        this.qtt = qtt;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public Integer getPayer() {
        return payer;
    }

    public void setPayer(Integer payer) {
        this.payer = payer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcmd != null ? idcmd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Panier)) {
            return false;
        }
        Panier other = (Panier) object;
        if ((this.idcmd == null && other.idcmd != null) || (this.idcmd != null && !this.idcmd.equals(other.idcmd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fst.jee.entity.Commande[ idcmd=" + idcmd + " ]";
    }
    
}
