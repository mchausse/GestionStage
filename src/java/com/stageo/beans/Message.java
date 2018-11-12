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
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
    , @NamedQuery(name = "Message.findByIdMessage", query = "SELECT m FROM Message m WHERE m.idMessage = :idMessage")
    , @NamedQuery(name = "Message.findByTitre", query = "SELECT m FROM Message m WHERE m.titre = :titre")
    , @NamedQuery(name = "Message.findByMessage", query = "SELECT m FROM Message m WHERE m.message = :message")
    , @NamedQuery(name = "Message.findByVu", query = "SELECT m FROM Message m WHERE m.vu = :vu")
    , @NamedQuery(name = "Message.findByDate", query = "SELECT m FROM Message m WHERE m.date = :date")
    , @NamedQuery(name = "Message.findByHeure", query = "SELECT m FROM Message m WHERE m.heure = :heure")
    , @NamedQuery(name = "Message.findByIdExpediteur", query = "SELECT m FROM Message m WHERE m.idExpediteur = :idExpediteur")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MESSAGE")
    private String idMessage;
    @Basic(optional = false)
    @Column(name = "TITRE")
    private String titre;
    @Basic(optional = false)
    @Column(name = "MESSAGE")
    private String message;
    @Basic(optional = false)
    @Column(name = "VU")
    private short vu;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "HEURE")
    @Temporal(TemporalType.TIME)
    private Date heure;
    @Basic(optional = false)
    @Column(name = "ID_EXPEDITEUR")
    private String idExpediteur;

    public Message() {
    }

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
