/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.beans;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import javax.servlet.http.Part;

/**
 *
 * @author mchausse
 */
public class Cv {

    private String idCv;
    private Part fichier;
    private InputStream lien;
    private String langue;
    private int nbVues;
    private String idEtudiant;
    private Date date;

    public Cv() {}

    public Cv(String idCv) {
        this.idCv = idCv;
    }

    public Cv(String idCv,InputStream lien, String langue, int nbVues, String idEtudiant, Date date) {
        this.idCv = idCv;
        this.fichier = fichier;
        this.lien = lien;
        this.langue = langue;
        this.nbVues = nbVues;
        this.idEtudiant = idEtudiant;
        this.date = date;
    }

    public String getIdCv() {
        return idCv;
    }

    public void setIdCv(String idCv) {
        this.idCv = idCv;
    }

    public Part getFichier() {
        return fichier;
    }

    public void setFichier(Part fichier) {
        this.fichier = fichier;
    }
    

    public InputStream getLien() {
        return lien;
    }

    public void setLien(InputStream lien) {
        this.lien = lien;
    }
    
    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public int getNbVues() {
        return nbVues;
    }

    public void setNbVues(int nbVues) {
        this.nbVues = nbVues;
    }

    public String getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(String idEtudiant) {
        this.idEtudiant = idEtudiant;
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
        hash += (idCv != null ? idCv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cv)) {
            return false;
        }
        Cv other = (Cv) object;
        if ((this.idCv == null && other.idCv != null) || (this.idCv != null && !this.idCv.equals(other.idCv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Cv[ idCv=" + idCv + " ]";
    }
    
}
