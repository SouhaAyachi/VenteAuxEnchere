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
import javax.inject.Named;
import javax.persistence.Basic;
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
@Named(value="enchere")
@RequestScoped


@SqlResultSetMapping(
    name = "enchereMapping",
    entities = {
        @EntityResult(
            entityClass = Enchere.class,
            fields = {
                @FieldResult(name = "id", column = "id"),
                @FieldResult(name = "iduser", column = "iduser"),
                @FieldResult(name = "idprod", column = "idprod"),
                
                @FieldResult(name = "montant", column = "montant"),
                @FieldResult(name = "datemodif", column = "datemodif")
            
            
            })}
        
)

@Entity
@Table(name = "enchere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enchere.findAll", query = "SELECT e FROM Enchere e"),
    @NamedQuery(name = "Enchere.findById", query = "SELECT e FROM Enchere e WHERE e.id = :id"),
    @NamedQuery(name = "Enchere.findByIduser", query = "SELECT e FROM Enchere e WHERE e.iduser = :iduser"),
    @NamedQuery(name = "Enchere.findByIdprod", query = "SELECT e FROM Enchere e WHERE e.idprod.id = :idprod"),
    @NamedQuery(name = "Enchere.findByMontant", query = "SELECT e FROM Enchere e WHERE e.montant = :montant"),
    @NamedQuery(name = "Enchere.findByDatemodif", query = "SELECT e FROM Enchere e WHERE e.datemodif = :datemodif"),
    @NamedQuery(name = "Enchere.MaxEnch", query = "SELECT max(e.montant) FROM Enchere e WHERE e.id = :id"),

})
public class Enchere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="iduser", referencedColumnName="id")
    private User iduser;
     @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idprod", referencedColumnName="id")
    private Produit idprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant", precision = 12)
    private Float montant;
    @Column(name = "datemodif")
    @Temporal(TemporalType.DATE)
    private Date datemodif;

    public Enchere() {
    }

    public Enchere(Integer id) {
        this.id = id;
    }

    public Enchere(Integer id, User iduser, Produit idprod) {
        this.id = id;
        this.iduser = iduser;
        this.idprod = idprod;
    }
    
     public Enchere(User iduser, Produit idprod) {
         
        this.iduser = iduser;
        this.idprod = idprod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public Produit getIdprod() {
        return idprod;
    }

    public void setIdprod(Produit idprod) {
        this.idprod = idprod;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Date getDatemodif() {
        return datemodif;
    }

    public void setDatemodif(Date datemodif) {
        this.datemodif = datemodif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enchere)) {
            return false;
        }
        Enchere other = (Enchere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fst.jee.entity.Enchere[ id=" + id + " ]";
    }
    
}
