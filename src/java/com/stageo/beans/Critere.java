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
public class Critere {

    private String idCritere;
    private String nom;

    public Critere() {}

    public Critere(String idCritere) {
        this.idCritere = idCritere;
    }

    public Critere(String idCritere, String nom) {
        this.idCritere = idCritere;
        this.nom = nom;
    }

    public String getIdCritere() {
        return idCritere;
    }

    public void setIdCritere(String idCritere) {
        this.idCritere = idCritere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCritere != null ? idCritere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Critere)) {
            return false;
        }
        Critere other = (Critere) object;
        if ((this.idCritere == null && other.idCritere != null) || (this.idCritere != null && !this.idCritere.equals(other.idCritere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Critere[ idCritere=" + idCritere + " ]";
    }
    
}
