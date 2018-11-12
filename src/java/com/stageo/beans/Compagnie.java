/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mchausse
 */
@Entity
@Table(name = "compagnie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compagnie.findAll", query = "SELECT c FROM Compagnie c")
    , @NamedQuery(name = "Compagnie.findByIdCompagnie", query = "SELECT c FROM Compagnie c WHERE c.idCompagnie = :idCompagnie")
    , @NamedQuery(name = "Compagnie.findByNom", query = "SELECT c FROM Compagnie c WHERE c.nom = :nom")
    , @NamedQuery(name = "Compagnie.findBySiteWeb", query = "SELECT c FROM Compagnie c WHERE c.siteWeb = :siteWeb")
    , @NamedQuery(name = "Compagnie.findByIdAdresse", query = "SELECT c FROM Compagnie c WHERE c.idAdresse = :idAdresse")})
public class Compagnie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_COMPAGNIE")
    private String idCompagnie;
    @Basic(optional = false)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @Column(name = "SITE_WEB")
    private String siteWeb;
    @Basic(optional = false)
    @Column(name = "ID_ADRESSE")
    private String idAdresse;

    public Compagnie() {
    }

    public Compagnie(String idCompagnie) {
        this.idCompagnie = idCompagnie;
    }

    public Compagnie(String idCompagnie, String nom, String siteWeb, String idAdresse) {
        this.idCompagnie = idCompagnie;
        this.nom = nom;
        this.siteWeb = siteWeb;
        this.idAdresse = idAdresse;
    }

    public String getIdCompagnie() {
        return idCompagnie;
    }

    public void setIdCompagnie(String idCompagnie) {
        this.idCompagnie = idCompagnie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(String idAdresse) {
        this.idAdresse = idAdresse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompagnie != null ? idCompagnie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compagnie)) {
            return false;
        }
        Compagnie other = (Compagnie) object;
        if ((this.idCompagnie == null && other.idCompagnie != null) || (this.idCompagnie != null && !this.idCompagnie.equals(other.idCompagnie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Compagnie[ idCompagnie=" + idCompagnie + " ]";
    }
    
}
