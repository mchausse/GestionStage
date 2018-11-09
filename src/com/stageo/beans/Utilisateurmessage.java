/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "utilisateurmessage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateurmessage.findAll", query = "SELECT u FROM Utilisateurmessage u")
    , @NamedQuery(name = "Utilisateurmessage.findByIdMessage", query = "SELECT u FROM Utilisateurmessage u WHERE u.utilisateurmessagePK.idMessage = :idMessage")
    , @NamedQuery(name = "Utilisateurmessage.findByIdDestinataire", query = "SELECT u FROM Utilisateurmessage u WHERE u.utilisateurmessagePK.idDestinataire = :idDestinataire")
    , @NamedQuery(name = "Utilisateurmessage.findByLu", query = "SELECT u FROM Utilisateurmessage u WHERE u.lu = :lu")})
public class Utilisateurmessage implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UtilisateurmessagePK utilisateurmessagePK;
    @Basic(optional = false)
    @Column(name = "LU")
    private short lu;

    public Utilisateurmessage() {
    }

    public Utilisateurmessage(UtilisateurmessagePK utilisateurmessagePK) {
        this.utilisateurmessagePK = utilisateurmessagePK;
    }

    public Utilisateurmessage(UtilisateurmessagePK utilisateurmessagePK, short lu) {
        this.utilisateurmessagePK = utilisateurmessagePK;
        this.lu = lu;
    }

    public Utilisateurmessage(String idMessage, String idDestinataire) {
        this.utilisateurmessagePK = new UtilisateurmessagePK(idMessage, idDestinataire);
    }

    public UtilisateurmessagePK getUtilisateurmessagePK() {
        return utilisateurmessagePK;
    }

    public void setUtilisateurmessagePK(UtilisateurmessagePK utilisateurmessagePK) {
        this.utilisateurmessagePK = utilisateurmessagePK;
    }

    public short getLu() {
        return lu;
    }

    public void setLu(short lu) {
        this.lu = lu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (utilisateurmessagePK != null ? utilisateurmessagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateurmessage)) {
            return false;
        }
        Utilisateurmessage other = (Utilisateurmessage) object;
        if ((this.utilisateurmessagePK == null && other.utilisateurmessagePK != null) || (this.utilisateurmessagePK != null && !this.utilisateurmessagePK.equals(other.utilisateurmessagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Utilisateurmessage[ utilisateurmessagePK=" + utilisateurmessagePK + " ]";
    }
    
}
