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
public class Notification {

    private String idNotification;
    private String type;
    private String message;
    private short vue;
    private String idCoordonnateur;
    private Date date;
    private Date heure;

    public Notification() {}

    public Notification(String idNotification) {
        this.idNotification = idNotification;
    }

    public Notification(String idNotification, String type, String message, short vue, String idCoordonnateur, Date date, Date heure) {
        this.idNotification = idNotification;
        this.type = type;
        this.message = message;
        this.vue = vue;
        this.idCoordonnateur = idCoordonnateur;
        this.date = date;
        this.heure = heure;
    }

    public String getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(String idNotification) {
        this.idNotification = idNotification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public short getVue() {
        return vue;
    }

    public void setVue(short vue) {
        this.vue = vue;
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

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotification != null ? idNotification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.idNotification == null && other.idNotification != null) || (this.idNotification != null && !this.idNotification.equals(other.idNotification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Notification[ idNotification=" + idNotification + " ]";
    }
    
}
