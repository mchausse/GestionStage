package com.stageo.beans;

import java.util.Date;

/**
 *
 * @author mchausse
 */
public class Message{
    private String idMessage;
    private String titre;
    private String message;
    private short vu;
    private Date date;
    private Date heure;
    private String idExpediteur;
    private String idDestinataire;
    private short lu;

    public String getIdDestinataire() {
        return idDestinataire;
    }

    public void setIdDestinataire(String idDestinataire) {
        this.idDestinataire = idDestinataire;
    }

    public short getLu() {
        return lu;
    }

    public void setLu(short lu) {
        this.lu = lu;
    }

    public Message() {}

    public Message(String idMessage) {
        this.idMessage = idMessage;
    }

    public Message(String idMessage, String titre, String message, short vu, Date date, Date heure, String idExpediteur) {
        this.idMessage = idMessage;
        this.titre = titre;
        this.message = message;
        this.vu = vu;
        this.date = date;
        this.heure = heure;
        this.idExpediteur = idExpediteur;
    }

    public String getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(String idMessage) {
        this.idMessage = idMessage;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public short getVu() {
        return vu;
    }

    public void setVu(short vu) {
        this.vu = vu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public String getIdExpediteur() {
        return idExpediteur;
    }

    public void setIdExpediteur(String idExpediteur) {
        this.idExpediteur = idExpediteur;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessage != null ? idMessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.idMessage == null && other.idMessage != null) || (this.idMessage != null && !this.idMessage.equals(other.idMessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Message[ idMessage=" + idMessage + " ]";
    }
    
}
