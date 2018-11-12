/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.beans;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mchausse
 */
@Entity
@Table(name = "offrestagecritere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offrestagecritere.findAll", query = "SELECT o FROM Offrestagecritere o")
    , @NamedQuery(name = "Offrestagecritere.findByIdOffre", query = "SELECT o FROM Offrestagecritere o WHERE o.offrestagecriterePK.idOffre = :idOffre")
    , @NamedQuery(name = "Offrestagecritere.findByIdCritere", query = "SELECT o FROM Offrestagecritere o WHERE o.offrestagecriterePK.idCritere = :idCritere")})
public class Offrestagecritere implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OffrestagecriterePK offrestagecriterePK;

    public Offrestagecritere() {
    }

    public Offrestagecritere(OffrestagecriterePK offrestagecriterePK) {
        this.offrestagecriterePK = offrestagecriterePK;
    }

    public Offrestagecritere(String idOffre, String idCritere) {
        this.offrestagecriterePK = new OffrestagecriterePK(idOffre, idCritere);
    }

    public OffrestagecriterePK getOffrestagecriterePK() {
        return offrestagecriterePK;
    }

    public void setOffrestagecriterePK(OffrestagecriterePK offrestagecriterePK) {
        this.offrestagecriterePK = offrestagecriterePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (offrestagecriterePK != null ? offrestagecriterePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offrestagecritere)) {
            return false;
        }
        Offrestagecritere other = (Offrestagecritere) object;
        if ((this.offrestagecriterePK == null && other.offrestagecriterePK != null) || (this.offrestagecriterePK != null && !this.offrestagecriterePK.equals(other.offrestagecriterePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Offrestagecritere[ offrestagecriterePK=" + offrestagecriterePK + " ]";
    }
    
}
