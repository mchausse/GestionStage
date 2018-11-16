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
public class Etudiantcritere {
    protected EtudiantcriterePK etudiantcriterePK;

    public Etudiantcritere() {}

    public Etudiantcritere(EtudiantcriterePK etudiantcriterePK) {
        this.etudiantcriterePK = etudiantcriterePK;
    }

    public Etudiantcritere(String idEtudiant, String idCritere) {
        this.etudiantcriterePK = new EtudiantcriterePK(idEtudiant, idCritere);
    }

    public EtudiantcriterePK getEtudiantcriterePK() {
        return etudiantcriterePK;
    }

    public void setEtudiantcriterePK(EtudiantcriterePK etudiantcriterePK) {
        this.etudiantcriterePK = etudiantcriterePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etudiantcriterePK != null ? etudiantcriterePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiantcritere)) {
            return false;
        }
        Etudiantcritere other = (Etudiantcritere) object;
        if ((this.etudiantcriterePK == null && other.etudiantcriterePK != null) || (this.etudiantcriterePK != null && !this.etudiantcriterePK.equals(other.etudiantcriterePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Etudiantcritere[ etudiantcriterePK=" + etudiantcriterePK + " ]";
    }
    
}
