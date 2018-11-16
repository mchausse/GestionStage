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
public class UtilisateurmessagePK {

    private String idMessage;
    private String idDestinataire;

    public UtilisateurmessagePK() {}

    public UtilisateurmessagePK(String idMessage, String idDestinataire) {
        this.idMessage = idMessage;
        this.idDestinataire = idDestinataire;
    }

    public String getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(String idMessage) {
        this.idMessage = idMessage;
    }

    public String getIdDestinataire() {
        return idDestinataire;
    }

    public void setIdDestinataire(String idDestinataire) {
        this.idDestinataire = idDestinataire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessage != null ? idMessage.hashCode() : 0);
        hash += (idDestinataire != null ? idDestinataire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UtilisateurmessagePK)) {
            return false;
        }
        UtilisateurmessagePK other = (UtilisateurmessagePK) object;
        if ((this.idMessage == null && other.idMessage != null) || (this.idMessage != null && !this.idMessage.equals(other.idMessage))) {
            return false;
        }
        if ((this.idDestinataire == null && other.idDestinataire != null) || (this.idDestinataire != null && !this.idDestinataire.equals(other.idDestinataire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.UtilisateurmessagePK[ idMessage=" + idMessage + ", idDestinataire=" + idDestinataire + " ]";
    }
    
}
