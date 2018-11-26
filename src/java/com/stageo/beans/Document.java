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
public class Document {
    private String idDocument;
    private String titre;
    private String lien;
    private String type;
    private int nbVues;
    private String idCoordonnateur;
    private Date date;

    public Document() {}

    public Document(String idDocument) {
        this.idDocument = idDocument;
    }

    public Document(String idDocument, String titre, String lien, String type, int nbVues, String idCoordonnateur, Date date) {
        this.idDocument = idDocument;
        this.titre = titre;
        this.lien = lien;
        this.type = type;
        this.nbVues = nbVues;
        this.idCoordonnateur = idCoordonnateur;
        this.date = date;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String titre) {
        this.idDocument = titre;
    }
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNbVues() {
        return nbVues;
    }

    public void setNbVues(int nbVues) {
        this.nbVues = nbVues;
    }

    public String getIdCoordonnateur() {
        return idCoordonnateur;
    }

    public void setIdCoordonnateur(String idCoordonnateur) {
        this.idCoordonnateur = idCoordonnateur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocument != null ? idDocument.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Document[ idDocument=" + idDocument + " ]";
    }
    
}
