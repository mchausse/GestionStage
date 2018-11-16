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
public class OffrestagecriterePK {

    private String idOffre;
    private String idCritere;

    public OffrestagecriterePK() {}

    public OffrestagecriterePK(String idOffre, String idCritere) {
        this.idOffre = idOffre;
        this.idCritere = idCritere;
    }

    public String getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(String idOffre) {
        this.idOffre = idOffre;
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
        hash += (idOffre != null ? idOffre.hashCode() : 0);
        hash += (idCritere != null ? idCritere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OffrestagecriterePK)) {
            return false;
        }
        OffrestagecriterePK other = (OffrestagecriterePK) object;
        if ((this.idOffre == null && other.idOffre != null) || (this.idOffre != null && !this.idOffre.equals(other.idOffre))) {
            return false;
        }
        if ((this.idCritere == null && other.idCritere != null) || (this.idCritere != null && !this.idCritere.equals(other.idCritere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.OffrestagecriterePK[ idOffre=" + idOffre + ", idCritere=" + idCritere + " ]";
    }
    
}
