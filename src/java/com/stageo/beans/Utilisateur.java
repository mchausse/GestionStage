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
public class Utilisateur {
    private String idUtilisateur;
    private String courriel;
    private String motDePasse;
    private String nom;
    private String prenom;
    private String typeUtilisateur;

    public Utilisateur() {}

    public Utilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Utilisateur(String idUtilisateur, String courriel, String motDePasse, String nom, String prenom, String typeUtilisateur) {
        this.idUtilisateur = idUtilisateur;
        this.courriel = courriel;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.typeUtilisateur = typeUtilisateur;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(String typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Utilisateur[ idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
