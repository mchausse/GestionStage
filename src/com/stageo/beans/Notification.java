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
@Table(name = "notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")
    , @NamedQuery(name = "Notification.findByIdNotification", query = "SELECT n FROM Notification n WHERE n.idNotification = :idNotification")
    , @NamedQuery(name = "Notification.findByType", query = "SELECT n FROM Notification n WHERE n.type = :type")
    , @NamedQuery(name = "Notification.findByMessage", query = "SELECT n FROM Notification n WHERE n.message = :message")
    , @NamedQuery(name = "Notification.findByVue", query = "SELECT n FROM Notification n WHERE n.vue = :vue")
    , @NamedQuery(name = "Notification.findByIdCoordonnateur", query = "SELECT n FROM Notification n WHERE n.idCoordonnateur = :idCoordonnateur")
    , @NamedQuery(name = "Notification.findByDate", query = "SELECT n FROM Notification n WHERE n.date = :date")
    , @NamedQuery(name = "Notification.findByHeure", query = "SELECT n FROM Notification n WHERE n.heure = :heure")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_NOTIFICATION")
    private String idNotification;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @Column(name = "MESSAGE")
    private String message;
    @Basic(optional = false)
    @Column(name = "VUE")
    private short vue;
    @Basic(optional = false)
    @Column(name = "ID_COORDONNATEUR")
    private String idCoordonnateur;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "HEURE")
    @Temporal(TemporalType.TIME)
    private Date heure;

    public Notification() {
    }

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
