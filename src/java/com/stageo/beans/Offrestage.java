/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.beans;

import java.util.Date;

/**
 *
 * @author mchausse
 */
public class Offrestage {

    private String idOffre;
    private String titre;
    private String description;
    private String lienWeb;
    private String lienDocument;
    private Date date;
    private int nbVues;
    private short active;
    private String idEmployeur;

    public Offrestage() {}

    public Offrestage(String idOffre) {
        this.idOffre = idOffre;
    }

    public Offrestage(String idOffre, String titre, String description, String lienWeb, String lienDocument, Date date, int nbVues, short active, String idEmployeur) {
        this.idOffre = idOffre;
        this.titre = titre;
        this.description = description;
        this.lienWeb = lienWeb;
        this.lienDocument = lienDocument;
        this.date = date;
        this.nbVues = nbVues;
        this.active = active;
        this.idEmployeur = idEmployeur;
    }

    public String getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(String idOffre) {
        this.idOffre = idOffre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLienWeb() {
        return lienWeb;
    }

    public void setLienWeb(String lienWeb) {
        this.lienWeb = lienWeb;
    }

    public String getLienDocument() {
        return lienDocument;
    }

    public void setLienDocument(String lienDocument) {
        this.lienDocument = lienDocument;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNbVues() {
        return nbVues;
    }

    public void setNbVues(int nbVues) {
        this.nbVues = nbVues;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public String getIdEmployeur() {
        return idEmployeur;
    }

    public void setIdEmployeur(String idEmployeur) {
        this.idEmployeur = idEmployeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOffre != null ? idOffre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offrestage)) {
            return false;
        }
        Offrestage other = (Offrestage) object;
        if ((this.idOffre == null && other.idOffre != null) || (this.idOffre != null && !this.idOffre.equals(other.idOffre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Offrestage[ idOffre=" + idOffre + " ]";
    }
    
}
