/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mchausse
 */
public class Candidature {

    protected CandidaturePK candidaturePK;
    private Date date;
    private String statut;

    public Candidature() {}

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
    public String getDateStr() {
        Date dateCand = this.date;
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        return ft.format(dateCand);
    }
    
}
