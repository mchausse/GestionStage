/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.beans;

/**
 *
 * @author mchausse
 */
public class EtudiantcriterePK {

    private String idEtudiant;
    private String idCritere;

    public EtudiantcriterePK() {}

    public EtudiantcriterePK(String idEtudiant, String idCritere) {
        this.idEtudiant = idEtudiant;
        this.idCritere = idCritere;
    }

    public String getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getIdCritere() {
        return idCritere;
    }

    public void setIdCritere(String idCritere) {
        this.idCritere = idCritere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtudiant != null ? idEtudiant.hashCode() : 0);
        hash += (idCritere != null ? idCritere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtudiantcriterePK)) {
            return false;
        }
        EtudiantcriterePK other = (EtudiantcriterePK) object;
        if ((this.idEtudiant == null && other.idEtudiant != null) || (this.idEtudiant != null && !this.idEtudiant.equals(other.idEtudiant))) {
            return false;
        }
        if ((this.idCritere == null && other.idCritere != null) || (this.idCritere != null && !this.idCritere.equals(other.idCritere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.EtudiantcriterePK[ idEtudiant=" + idEtudiant + ", idCritere=" + idCritere + " ]";
    }
    
}
