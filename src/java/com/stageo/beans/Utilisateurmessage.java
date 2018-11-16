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
public class Utilisateurmessage {
    protected UtilisateurmessagePK utilisateurmessagePK;
    private short lu;

    public Utilisateurmessage() {}

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
