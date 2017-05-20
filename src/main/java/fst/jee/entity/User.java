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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByNom", query = "SELECT u FROM User u WHERE u.nom = :nom"),
    @NamedQuery(name = "User.findByPrenom", query = "SELECT u FROM User u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "User.findByDn", query = "SELECT u FROM User u WHERE u.dn = :dn"),
    @NamedQuery(name = "User.findByLieunaiss", query = "SELECT u FROM User u WHERE u.lieunaiss = :lieunaiss"),
    @NamedQuery(name = "User.findByNationnalite", query = "SELECT u FROM User u WHERE u.nationnalite = :nationnalite"),
    @NamedQuery(name = "User.findByMdp", query = "SELECT u FROM User u WHERE u.mdp = :mdp"),
    @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login"),
    @NamedQuery(name = "User.findByMail", query = "SELECT u FROM User u WHERE u.mail = :mail"),
    @NamedQuery(name = "User.findByTel", query = "SELECT u FROM User u WHERE u.tel = :tel"),
    @NamedQuery(name = "User.findByBoutique", query = "SELECT u FROM User u WHERE u.boutique = :boutique"),
    @NamedQuery(name = "User.findByAvis", query = "SELECT u FROM User u WHERE u.avis = :avis"),
    @NamedQuery(name = "User.findByDateinscri", query = "SELECT u FROM User u WHERE u.dateinscri = :dateinscri"),
    @NamedQuery(name = "User.findByDatelastaccess", query = "SELECT u FROM User u WHERE u.datelastaccess = :datelastaccess"),
    @NamedQuery(name = "User.findBySex", query = "SELECT u FROM User u WHERE u.sex = :sex")})

@ManagedBean
@Named(value="user")
@RequestScoped

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom")
    private String nom;
    @Size(max = 30)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 10)
    @Column(name = "dn")
    private String dn;
    @Size(max = 30)
    @Column(name = "lieunaiss")
    private String lieunaiss;
    @Size(max = 30)
    @Column(name = "nationnalite")
    private String nationnalite;
    @Size(max = 30)
    @Column(name = "mdp")
    private String mdp;
    @Size(max = 30)
    @Column(name = "login")
    private String login;
    @Size(max = 30)
    @Column(name = "mail")
    private String mail;
    @Column(name = "tel")
    private Integer tel;
    @Size(max = 30)
    @Column(name = "boutique")
    private String boutique;
    @Column(name = "avis")
    private Integer avis;
    @Column(name = "dateinscri")
    @Temporal(TemporalType.DATE)
    private Date dateinscri;
    @Column(name = "datelastaccess")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastaccess;
    @Size(max = 1)
    @Column(name = "sex")
    private String sex;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getLieunaiss() {
        return lieunaiss;
    }

    public void setLieunaiss(String lieunaiss) {
        this.lieunaiss = lieunaiss;
    }

    public String getNationnalite() {
        return nationnalite;
    }

    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getBoutique() {
        return boutique;
    }

    public void setBoutique(String boutique) {
        this.boutique = boutique;
    }

    public Integer getAvis() {
        return avis;
    }

    public void setAvis(Integer avis) {
        this.avis = avis;
    }

    public Date getDateinscri() {
        return dateinscri;
    }

    public void setDateinscri(Date dateinscri) {
        this.dateinscri = dateinscri;
    }

    public Date getDatelastaccess() {
        return datelastaccess;
    }

    public void setDatelastaccess(Date datelastaccess) {
        this.datelastaccess = datelastaccess;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fst.jee.entity.User[ id=" + id + " ]";
    }
    
}
