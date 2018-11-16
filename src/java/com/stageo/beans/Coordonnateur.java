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
public class Coordonnateur extends Utilisateur{

    private String idCoordonnateur;

    public Coordonnateur() {}

    public Coordonnateur(String idCoordonnateur) {
        this.idCoordonnateur = idCoordonnateur;
    }

    public String getIdCoordonnateur() {
        return idCoordonnateur;
    }

    public void setIdCoordonnateur(String idCoordonnateur) {
        this.idCoordonnateur = idCoordonnateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCoordonnateur != null ? idCoordonnateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordonnateur)) {
            return false;
        }
        Coordonnateur other = (Coordonnateur) object;
        if ((this.idCoordonnateur == null && other.idCoordonnateur != null) || (this.idCoordonnateur != null && !this.idCoordonnateur.equals(other.idCoordonnateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Coordonnateur[ idCoordonnateur=" + idCoordonnateur + " ]";
    }
    
}
