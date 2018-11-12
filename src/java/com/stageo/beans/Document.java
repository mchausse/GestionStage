/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mchausse
 */
@Entity
@Table(name = "document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
    , @NamedQuery(name = "Document.findByIdDocument", query = "SELECT d FROM Document d WHERE d.idDocument = :idDocument")
    , @NamedQuery(name = "Document.findByLien", query = "SELECT d FROM Document d WHERE d.lien = :lien")
    , @NamedQuery(name = "Document.findByType", query = "SELECT d FROM Document d WHERE d.type = :type")
    , @NamedQuery(name = "Document.findByNbVues", query = "SELECT d FROM Document d WHERE d.nbVues = :nbVues")
    , @NamedQuery(name = "Document.findByIdCoordonnateur", query = "SELECT d FROM Document d WHERE d.idCoordonnateur = :idCoordonnateur")
    , @NamedQuery(name = "Document.findByDate", query = "SELECT d FROM Document d WHERE d.date = :date")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DOCUMENT")
    private String idDocument;
    @Basic(optional = false)
    @Column(name = "LIEN")
    private String lien;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @Column(name = "NB_VUES")
    private int nbVues;
    @Basic(optional = false)
    @Column(name = "ID_COORDONNATEUR")
    private String idCoordonnateur;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Document() {
    }

    public Document(String idDocument) {
        this.idDocument = idDocument;
    }

    public Document(String idDocument, String lien, String type, int nbVues, String idCoordonnateur, Date date) {
        this.idDocument = idDocument;
        this.lien = lien;
        this.type = type;
        this.nbVues = nbVues;
        this.idCoordonnateur = idCoordonnateur;
        this.date = date;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
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
