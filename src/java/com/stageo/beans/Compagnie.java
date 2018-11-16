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
public class Compagnie {

    private String idCompagnie;
    private String nom;
    private String siteWeb;
    private String idAdresse;

    public Compagnie() {}

    public Compagnie(String idCompagnie) {
        this.idCompagnie = idCompagnie;
    }

    public Compagnie(String idCompagnie, String nom, String siteWeb, String idAdresse) {
        this.idCompagnie = idCompagnie;
        this.nom = nom;
        this.siteWeb = siteWeb;
        this.idAdresse = idAdresse;
    }

    public String getIdCompagnie() {
        return idCompagnie;
    }

    public void setIdCompagnie(String idCompagnie) {
        this.idCompagnie = idCompagnie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(String idAdresse) {
        this.idAdresse = idAdresse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompagnie != null ? idCompagnie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compagnie)) {
            return false;
        }
        Compagnie other = (Compagnie) object;
        if ((this.idCompagnie == null && other.idCompagnie != null) || (this.idCompagnie != null && !this.idCompagnie.equals(other.idCompagnie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Compagnie[ idCompagnie=" + idCompagnie + " ]";
    }
    
}
