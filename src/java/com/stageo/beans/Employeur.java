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
public class Employeur extends Utilisateur{
    private String idEmployeur;
    private String tel;
    private String idCompagnie;

    public Employeur() {}

    public Employeur(String idEmployeur) {
        this.idEmployeur = idEmployeur;
    }

    public Employeur(String idEmployeur, String tel, String idCompagnie) {
        this.idEmployeur = idEmployeur;
        this.tel = tel;
        this.idCompagnie = idCompagnie;
    }

    public String getIdEmployeur() {
        return idEmployeur;
    }

    public void setIdEmployeur(String idEmployeur) {
        this.idEmployeur = idEmployeur;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdCompagnie() {
        return idCompagnie;
    }

    public void setIdCompagnie(String idCompagnie) {
        this.idCompagnie = idCompagnie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployeur != null ? idEmployeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employeur)) {
            return false;
        }
        Employeur other = (Employeur) object;
        if ((this.idEmployeur == null && other.idEmployeur != null) || (this.idEmployeur != null && !this.idEmployeur.equals(other.idEmployeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Employeur[ idEmployeur=" + idEmployeur + " ]";
    }
    
}
