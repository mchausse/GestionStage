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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "candidature")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidature.findAll", query = "SELECT c FROM Candidature c")
    , @NamedQuery(name = "Candidature.findByIdEtudiant", query = "SELECT c FROM Candidature c WHERE c.candidaturePK.idEtudiant = :idEtudiant")
    , @NamedQuery(name = "Candidature.findByIdOffre", query = "SELECT c FROM Candidature c WHERE c.candidaturePK.idOffre = :idOffre")
    , @NamedQuery(name = "Candidature.findByDate", query = "SELECT c FROM Candidature c WHERE c.date = :date")
    , @NamedQuery(name = "Candidature.findByStatut", query = "SELECT c FROM Candidature c WHERE c.statut = :statut")})
public class Candidature implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CandidaturePK candidaturePK;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "STATUT")
    private String statut;

    public Candidature() {
    }

    public Candidature(CandidaturePK candidaturePK) {
        this.candidaturePK = candidaturePK;
    }

    public Candidature(CandidaturePK candidaturePK, Date date, String statut) {
        this.candidaturePK = candidaturePK;
        this.date = date;
        this.statut = statut;
    }

    public Candidature(String idEtudiant, String idOffre) {
        this.candidaturePK = new CandidaturePK(idEtudiant, idOffre);
    }

    public CandidaturePK getCandidaturePK() {
        return candidaturePK;
    }

    public void setCandidaturePK(CandidaturePK candidaturePK) {
        this.candidaturePK = candidaturePK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (candidaturePK != null ? candidaturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidature)) {
            return false;
        }
        Candidature other = (Candidature) object;
        if ((this.candidaturePK == null && other.candidaturePK != null) || (this.candidaturePK != null && !this.candidaturePK.equals(other.candidaturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Candidature[ candidaturePK=" + candidaturePK + " ]";
    }
    
}
