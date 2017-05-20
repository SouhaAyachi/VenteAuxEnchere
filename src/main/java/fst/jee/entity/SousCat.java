/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author souha
 */
@Entity
@Table(name = "sous_cat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SousCat.findAll", query = "SELECT s FROM SousCat s"),
    @NamedQuery(name = "SousCat.findById", query = "SELECT s FROM SousCat s WHERE s.id = :id"),
    @NamedQuery(name = "SousCat.findByDesignation", query = "SELECT s FROM SousCat s WHERE s.designation = :designation"),
    @NamedQuery(name = "SousCat.findByDescription", query = "SELECT s FROM SousCat s WHERE s.description = :description")
    })
public class SousCat implements Serializable {

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
    
    
    public SousCat() {
    }
    
    
     public SousCat(int id,String des,String desc) {
         this.id=id;
        designation=des;
        description=desc;
    }
    public SousCat(String des,String desc) {
        designation=des;
        description=desc;
    }
    public SousCat(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousCat)) {
            return false;
        }
        SousCat other = (SousCat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fst.jee.entity.SousCat[ id=" + id + " ]";
    }
    
}
