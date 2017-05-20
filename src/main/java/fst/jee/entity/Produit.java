/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author souha
 */



@SqlResultSetMapping(
    name = "ProduitMapping",
    entities = {
        @EntityResult(
            entityClass = Produit.class,
            fields = {
                @FieldResult(name = "id", column = "id"),
                @FieldResult(name = "designation", column = "designation"),
                @FieldResult(name = "description", column = "description"),
                @FieldResult(name = "cat", column = "cat"),
                @FieldResult(name = "prix", column = "prix"),
                @FieldResult(name = "solde", column = "solde"),
                @FieldResult(name = "qtt", column = "qtt"),
                @FieldResult(name = "user", column = "user"),
                
                @FieldResult(name = "dateajout", column = "dateajout"),
                @FieldResult(name = "typeachat", column = "typeachat"),
                @FieldResult(name = "datelimite", column = "datelimite"),
                
                @FieldResult(name = "note", column = "note"),
                @FieldResult(name = "img1", column = "img1"),
                @FieldResult(name = "img1", column = "img2"),
                @FieldResult(name = "img1", column = "img3"),
                @FieldResult(name = "img1", column = "img4"),
                @FieldResult(name = "marque", column = "marque"),
                @FieldResult(name = "etat", column = "etat"),
                @FieldResult(name = "genre", column = "genre"),
                @FieldResult(name = "matiere", column = "matiere"),
              // @FieldResult(name = "starting_price", column = "starting_price"),
                //@FieldResult(name = "prix_enchere", column = "prix_enchere")
            
            
            })}
        
)


@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findById", query = "SELECT p FROM Produit p WHERE p.id = :id"),
    @NamedQuery(name = "Produit.findByDesignation", query = "SELECT p FROM Produit p WHERE p.designation = :designation"),
    @NamedQuery(name = "Produit.findByDescription", query = "SELECT p FROM Produit p WHERE p.description = :description"),
    @NamedQuery(name = "Produit.findByCat", query = "SELECT p FROM Produit p WHERE p.cat = :cat"),
    @NamedQuery(name = "Produit.findByPrix", query = "SELECT p FROM Produit p WHERE p.prix = :prix"),
    @NamedQuery(name = "Produit.findBySolde", query = "SELECT p FROM Produit p WHERE p.solde = :solde"),
    @NamedQuery(name = "Produit.findByQtt", query = "SELECT p FROM Produit p WHERE p.qtt = :qtt"),
    @NamedQuery(name = "Produit.findByUser", query = "SELECT p FROM Produit p WHERE p.user = :user"),
    @NamedQuery(name = "Produit.findByDateajout", query = "SELECT p FROM Produit p WHERE p.dateajout = :dateajout"),
    @NamedQuery(name = "Produit.findByTypeachat", query = "SELECT p FROM Produit p WHERE p.typeachat = :typeachat"),
    @NamedQuery(name = "Produit.findByDatelimite", query = "SELECT p FROM Produit p WHERE p.datelimite = :datelimite"),
    @NamedQuery(name = "Produit.findByLivraison", query = "SELECT p FROM Produit p WHERE p.livraison = :livraison"),
    @NamedQuery(name = "Produit.findByPaiment", query = "SELECT p FROM Produit p WHERE p.paiment = :paiment"),
    @NamedQuery(name = "Produit.findByNote", query = "SELECT p FROM Produit p WHERE p.note = :note"),
    @NamedQuery(name = "Produit.findByImg1", query = "SELECT p FROM Produit p WHERE p.img1 = :img1"),
    @NamedQuery(name = "Produit.findByImg2", query = "SELECT p FROM Produit p WHERE p.img2 = :img2"),
    @NamedQuery(name = "Produit.findByImg3", query = "SELECT p FROM Produit p WHERE p.img3 = :img3"),
    @NamedQuery(name = "Produit.findByImg4", query = "SELECT p FROM Produit p WHERE p.img4 = :img4"),
    @NamedQuery(name = "Produit.findByMarque", query = "SELECT p FROM Produit p WHERE p.marque = :marque"),
    @NamedQuery(name = "Produit.findByEtat", query = "SELECT p FROM Produit p WHERE p.etat = :etat"),
    @NamedQuery(name = "Produit.findByGenre", query = "SELECT p FROM Produit p WHERE p.genre = :genre"),
    @NamedQuery(name = "Produit.findByMatiere", query = "SELECT p FROM Produit p WHERE p.matiere = :matiere")})

@ManagedBean
@Named(value="produit")
@SessionScoped
@Entity
@Table(name = "produit")
public class Produit implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "designation")
    private String designation;
    @Size(max = 30)
    @Column(name = "description")
    private String description;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cat", referencedColumnName="id")
    private SousCat cat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix")
    private Double prix;
    /*@Column(name = "prix_enchere")
    private Double prix_enchere;*/
   

    /*public Double getPrix_enchere() {
        return prix_enchere;
    }

    public void setPrix_enchere(Double prix_enchere) {
        this.prix_enchere = prix_enchere;
    }*/
    
   /* @Column(name = "starting_price")
    private Double starting_price;*/
    
    @Column(name = "solde")
    private Integer solde;

    /*public Double getStarting_price() {
        return starting_price;
    }

    public void setStarting_price(Double starting_price) {
        this.starting_price = starting_price;
    }*/
    @Column(name = "qtt")
    private Integer qtt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user", referencedColumnName="id")
    private User user;
    @Column(name = "dateajout")
    @Temporal(TemporalType.DATE)
    private Date dateajout;
    @NotNull
    @Column(name = "typeachat")
    private Integer typeachat;
    @Column(name = "datelimite")
    @Temporal(TemporalType.DATE)
    private Date datelimite;
    @Size(max = 100)
    @Column(name = "livraison")
    private String livraison;
    @Size(max = 100)
    @Column(name = "paiment")
    private String paiment;
    @Column(name = "note")
    private Integer note;
    @Size(max = 500)
    @Column(name = "img1")
    private String img1;
    @Size(max = 500)
    @Column(name = "img2")
    private String img2;
    @Size(max = 500)
    @Column(name = "img3")
    private String img3;
    @Size(max = 500)
    @Column(name = "img4")
    private String img4;
    @Size(max = 10)
    @Column(name = "marque")
    private String marque;
    @Size(max = 30)
    @Column(name = "etat")
    private String etat;
    @Size(max = 30)
    @Column(name = "Genre")
    private String genre;
    @Size(max = 30)
    @Column(name = "matiere")
    private String matiere;

    public Produit() {
    }

    public Produit(Integer id) {
        this.id = id;
    }
    
    public void UpdateProduit(Produit p) {
        this.id =p. id;
        this.designation=p.designation;
        this.description=p.description;
        this.prix=p.prix;
        //this.prix_enchere=p.prix_enchere;
        this.qtt=p.qtt;
        this.user=p.user;
        this.typeachat=p.typeachat;
        this.dateajout=p.dateajout;
        this.datelimite=p.datelimite;
        this.note=p.note;
        this.img1=p.img1;
        this.img2=p.img2;
        this.img3=p.img3;
        this.img4=p.img4;   
        this.marque=p.marque;
        this.etat=p.etat;
        this.genre=p.genre;
        this.matiere=p.matiere;
    }
    
    public Integer getId() {
        return id;
    }
    public Produit(String des,String desc) {
        designation=des;
        description=desc;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SousCat getCat() {
        return cat;
    }

    public void setCat(SousCat cat) {
        this.cat = cat;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public Integer getQtt() {
        return qtt;
    }

    public void setQtt(Integer qtt) {
        this.qtt = qtt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateajout() {
        return dateajout;
    }

    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }

    public Integer getTypeachat() {
        return typeachat;
    }

    public void setTypeachat(Integer typeachat) {
        this.typeachat = typeachat;
    }

    public Date getDatelimite() {
        return datelimite;
    }

    public void setDatelimite(Date datelimite) {
        this.datelimite = datelimite;
    }

    public String getLivraison() {
        return livraison;
    }

    public void setLivraison(String livraison) {
        this.livraison = livraison;
    }

    public String getPaiment() {
        return paiment;
    }

    public void setPaiment(String paiment) {
        this.paiment = paiment;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fst.jee.entity.Produit[ id=" + id + " ]";
    }
    
}
