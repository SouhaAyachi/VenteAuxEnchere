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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@ManagedBean
@Named(value="cmd")
@RequestScoped
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cmd.findAll", query = "SELECT c FROM Cmd c order by c.dateCmd desc"),
    @NamedQuery(name = "Cmd.findByIdcmd", query = "SELECT c FROM Cmd c WHERE c.idcmd = :idcmd"),
    @NamedQuery(name = "Cmd.findByIdprod", query = "SELECT c FROM Cmd c WHERE c.idprod = :idprod"),
    @NamedQuery(name = "Cmd.findByIduser", query = "SELECT c FROM Cmd c WHERE c.iduser = :iduser"),
    @NamedQuery(name = "Cmd.findByDatecmd", query = "SELECT c FROM Cmd c WHERE c.datecmd = :datecmd"),
    @NamedQuery(name = "Cmd.findByColor", query = "SELECT c FROM Cmd c WHERE c.color = :color"),
    @NamedQuery(name = "Cmd.findByQtt", query = "SELECT c FROM Cmd c WHERE c.qtt = :qtt"),
    @NamedQuery(name = "Cmd.findByTaille", query = "SELECT c FROM Cmd c WHERE c.taille = :taille"),
    @NamedQuery(name = "Cmd.findByValide", query = "SELECT c FROM Cmd c WHERE c.valide = :valide"),
    @NamedQuery(name = "Cmd.findByDateCmd", query = "SELECT c FROM Cmd c WHERE c.dateCmd = :dateCmd"),
    @NamedQuery(name = "Cmd.findByDateValide", query = "SELECT c FROM Cmd c WHERE c.dateValide = :dateValide"),
    @NamedQuery(name = "Cmd.findByPays", query = "SELECT c FROM Cmd c WHERE c.pays = :pays"),
    @NamedQuery(name = "Cmd.findByCity", query = "SELECT c FROM Cmd c WHERE c.city = :city"),
    @NamedQuery(name = "Cmd.findByVille", query = "SELECT c FROM Cmd c WHERE c.ville = :ville"),
    @NamedQuery(name = "Cmd.findByCodePostale", query = "SELECT c FROM Cmd c WHERE c.codePostale = :codePostale"),
    @NamedQuery(name = "Cmd.findByStreet", query = "SELECT c FROM Cmd c WHERE c.street = :street"),
    @NamedQuery(name = "Cmd.findByNom", query = "SELECT c FROM Cmd c WHERE c.nom = :nom"),
    @NamedQuery(name = "Cmd.findByPrenom", query = "SELECT c FROM Cmd c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Cmd.findByTel", query = "SELECT c FROM Cmd c WHERE c.tel = :tel"),
    @NamedQuery(name = "Cmd.findByMail", query = "SELECT c FROM Cmd c WHERE c.mail = :mail")})
public class Cmd implements Serializable {

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
   
    @Basic(optional = false)
    @NotNull
    @Column(name = "datecmd", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datecmd;
    @Column(name = "color")
    private Integer color;
    @Column(name = "qtt")
    private Integer qtt;
    @Column(name = "taille")
    private Integer taille;
    @Column(name = "valide")
    private Boolean valide;
    @Column(name = "date_cmd")
    @Temporal(TemporalType.DATE)
    private Date dateCmd;
    @Column(name = "dateValide")
    @Temporal(TemporalType.DATE)
    private Date dateValide;
    @Column(name = "pays")
    private Integer pays;
    @Size(max = 30)
    @Column(name = "city", length = 30)
    private String city;
    @Size(max = 30)
    @Column(name = "ville", length = 30)
    private String ville;
    @Column(name = "code_postale")
    private Integer codePostale;
    @Size(max = 30)
    @Column(name = "street", length = 30)
    private String street;
    @Size(max = 30)
    @Column(name = "nom", length = 30)
    private String nom;
    @Size(max = 30)
    @Column(name = "prenom", length = 30)
    private String prenom;
    @Column(name = "tel")
    private Integer tel;
    @Size(max = 30)
    @Column(name = "mail", length = 30)
    private String mail;

    public Cmd() {
    }

    public Cmd(Integer idcmd) {
        this.idcmd = idcmd;
    }

    public Cmd(Integer idcmd, Produit idprod, User iduser, Date datecmd) {
        this.idcmd = idcmd;
        this.idprod = idprod;
        this.iduser = iduser;
        this.datecmd = datecmd;
    }
    public Cmd(Produit idprod, User iduser, Date datecmd) {
       
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

    public Boolean getValide() {
        return valide;
    }

    public void setValide(Boolean valide) {
        this.valide = valide;
    }

    public Date getDateCmd() {
        return dateCmd;
    }

    public void setDateCmd(Date dateCmd) {
        this.dateCmd = dateCmd;
    }

    public Date getDateValide() {
        return dateValide;
    }

    public void setDateValide(Date dateValide) {
        this.dateValide = dateValide;
    }

    public Integer getPays() {
        return pays;
    }

    public void setPays(Integer pays) {
        this.pays = pays;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Integer getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(Integer codePostale) {
        this.codePostale = codePostale;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        if (!(object instanceof Cmd)) {
            return false;
        }
        Cmd other = (Cmd) object;
        if ((this.idcmd == null && other.idcmd != null) || (this.idcmd != null && !this.idcmd.equals(other.idcmd))) {
            return false;
        }
        return true;
    }
   public  Cmd(Produit p,User u,int qtt,int color,int taille){
       this.idprod=p;
       this.iduser=u;
       this.qtt=qtt;
       this.taille=taille;
   }
    
    @Override
    public String toString() {
        return "fst.jee.entity.Cmd[ idcmd=" + idcmd + " ]";
    }
    
}
