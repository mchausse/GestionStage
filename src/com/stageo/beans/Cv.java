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
@Table(name = "cv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cv.findAll", query = "SELECT c FROM Cv c")
    , @NamedQuery(name = "Cv.findByIdCv", query = "SELECT c FROM Cv c WHERE c.idCv = :idCv")
    , @NamedQuery(name = "Cv.findByLien", query = "SELECT c FROM Cv c WHERE c.lien = :lien")
    , @NamedQuery(name = "Cv.findByLangue", query = "SELECT c FROM Cv c WHERE c.langue = :langue")
    , @NamedQuery(name = "Cv.findByNbVues", query = "SELECT c FROM Cv c WHERE c.nbVues = :nbVues")
    , @NamedQuery(name = "Cv.findByIdEtudiant", query = "SELECT c FROM Cv c WHERE c.idEtudiant = :idEtudiant")
    , @NamedQuery(name = "Cv.findByDate", query = "SELECT c FROM Cv c WHERE c.date = :date")})
public class Cv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CV")
    private String idCv;
    @Basic(optional = false)
    @Column(name = "LIEN")
    private String lien;
    @Basic(optional = false)
    @Column(name = "LANGUE")
    private String langue;
    @Basic(optional = false)
    @Column(name = "NB_VUES")
    private int nbVues;
    @Basic(optional = false)
    @Column(name = "ID_ETUDIANT")
    private String idEtudiant;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Cv() {
    }

    public Cv(String idCv) {
        this.idCv = idCv;
    }

    public Cv(String idCv, String lien, String langue, int nbVues, String idEtudiant, Date date) {
        this.idCv = idCv;
        this.lien = lien;
        this.langue = langue;
        this.nbVues = nbVues;
        this.idEtudiant = idEtudiant;
        this.date = date;
    }

    public String getIdCv() {
        return idCv;
    }

    public void setIdCv(String idCv) {
        this.idCv = idCv;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public int getNbVues() {
        return nbVues;
    }

    public void setNbVues(int nbVues) {
        this.nbVues = nbVues;
    }

    public String getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCv != null ? idCv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cv)) {
            return false;
        }
        Cv other = (Cv) object;
        if ((this.idCv == null && other.idCv != null) || (this.idCv != null && !this.idCv.equals(other.idCv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Cv[ idCv=" + idCv + " ]";
    }
    
}
