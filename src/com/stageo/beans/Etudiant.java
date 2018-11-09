/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mchausse
 */
@Entity
@Table(name = "etudiant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e")
    , @NamedQuery(name = "Etudiant.findByIdEtudiant", query = "SELECT e FROM Etudiant e WHERE e.idEtudiant = :idEtudiant")
    , @NamedQuery(name = "Etudiant.findByStatutRecherche", query = "SELECT e FROM Etudiant e WHERE e.statutRecherche = :statutRecherche")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ETUDIANT")
    private String idEtudiant;
    @Basic(optional = false)
    @Column(name = "STATUT_RECHERCHE")
    private String statutRecherche;

    public Etudiant() {
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
