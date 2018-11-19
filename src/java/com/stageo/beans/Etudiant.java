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
//public class Etudiant extends Utilisateur{
public class Etudiant { //Etudiant ne devrait pas dessendre de utilisateur
    private String idEtudiant;
    private String statutRecherche;

    public Etudiant() {
        super();
    }

    public Etudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public Etudiant(String idEtudiant, String statutRecherche) {
        this.idEtudiant = idEtudiant;
        this.statutRecherche = statutRecherche;
    }

    public String getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getStatutRecherche() {
        return statutRecherche;
    }

    public void setStatutRecherche(String statutRecherche) {
        this.statutRecherche = statutRecherche;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtudiant != null ? idEtudiant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.idEtudiant == null && other.idEtudiant != null) || (this.idEtudiant != null && !this.idEtudiant.equals(other.idEtudiant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Etudiant[ idEtudiant=" + idEtudiant + " ]";
    }
    
}
