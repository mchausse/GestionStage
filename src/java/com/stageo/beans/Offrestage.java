/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mchausse
 */
@Entity
@Table(name = "offrestage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offrestage.findAll", query = "SELECT o FROM Offrestage o")
    , @NamedQuery(name = "Offrestage.findByIdOffre", query = "SELECT o FROM Offrestage o WHERE o.idOffre = :idOffre")
    , @NamedQuery(name = "Offrestage.findByTitre", query = "SELECT o FROM Offrestage o WHERE o.titre = :titre")
    , @NamedQuery(name = "Offrestage.findByLienWeb", query = "SELECT o FROM Offrestage o WHERE o.lienWeb = :lienWeb")
    , @NamedQuery(name = "Offrestage.findByLienDocument", query = "SELECT o FROM Offrestage o WHERE o.lienDocument = :lienDocument")
    , @NamedQuery(name = "Offrestage.findByDate", query = "SELECT o FROM Offrestage o WHERE o.date = :date")
    , @NamedQuery(name = "Offrestage.findByNbVues", query = "SELECT o FROM Offrestage o WHERE o.nbVues = :nbVues")
    , @NamedQuery(name = "Offrestage.findByActive", query = "SELECT o FROM Offrestage o WHERE o.active = :active")
    , @NamedQuery(name = "Offrestage.findByIdEmployeur", query = "SELECT o FROM Offrestage o WHERE o.idEmployeur = :idEmployeur")})
public class Offrestage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_OFFRE")
    private String idOffre;
    @Basic(optional = false)
    @Column(name = "TITRE")
    private String titre;
    @Basic(optional = false)
    @Lob
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "LIEN_WEB")
    private String lienWeb;
    @Basic(optional = false)
    @Column(name = "LIEN_DOCUMENT")
    private String lienDocument;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "NB_VUES")
    private int nbVues;
    @Basic(optional = false)
    @Column(name = "ACTIVE")
    private short active;
    @Basic(optional = false)
    @Column(name = "ID_EMPLOYEUR")
    private String idEmployeur;

    public Offrestage() {
    }

    public Offrestage(String idOffre) {
        this.idOffre = idOffre;
    }

    public Offrestage(String idOffre, String titre, String description, String lienWeb, String lienDocument, Date date, int nbVues, short active, String idEmployeur) {
        this.idOffre = idOffre;
        this.titre = titre;
        this.description = description;
        this.lienWeb = lienWeb;
        this.lienDocument = lienDocument;
        this.date = date;
        this.nbVues = nbVues;
        this.active = active;
        this.idEmployeur = idEmployeur;
    }

    public String getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(String idOffre) {
        this.idOffre = idOffre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLienWeb() {
        return lienWeb;
    }

    public void setLienWeb(String lienWeb) {
        this.lienWeb = lienWeb;
    }

    public String getLienDocument() {
        return lienDocument;
    }

    public void setLienDocument(String lienDocument) {
        this.lienDocument = lienDocument;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNbVues() {
        return nbVues;
    }

    public void setNbVues(int nbVues) {
        this.nbVues = nbVues;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public String getIdEmployeur() {
        return idEmployeur;
    }

    public void setIdEmployeur(String idEmployeur) {
        this.idEmployeur = idEmployeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOffre != null ? idOffre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offrestage)) {
            return false;
        }
        Offrestage other = (Offrestage) object;
        if ((this.idOffre == null && other.idOffre != null) || (this.idOffre != null && !this.idOffre.equals(other.idOffre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Offrestage[ idOffre=" + idOffre + " ]";
    }
    
}
