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
@Table(name = "adresse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a")
    , @NamedQuery(name = "Adresse.findByIdAdresse", query = "SELECT a FROM Adresse a WHERE a.idAdresse = :idAdresse")
    , @NamedQuery(name = "Adresse.findByNumeroCivique", query = "SELECT a FROM Adresse a WHERE a.numeroCivique = :numeroCivique")
    , @NamedQuery(name = "Adresse.findByRue", query = "SELECT a FROM Adresse a WHERE a.rue = :rue")
    , @NamedQuery(name = "Adresse.findByBureau", query = "SELECT a FROM Adresse a WHERE a.bureau = :bureau")
    , @NamedQuery(name = "Adresse.findByVille", query = "SELECT a FROM Adresse a WHERE a.ville = :ville")
    , @NamedQuery(name = "Adresse.findByCodePostal", query = "SELECT a FROM Adresse a WHERE a.codePostal = :codePostal")
    , @NamedQuery(name = "Adresse.findByProvince", query = "SELECT a FROM Adresse a WHERE a.province = :province")
    , @NamedQuery(name = "Adresse.findByPays", query = "SELECT a FROM Adresse a WHERE a.pays = :pays")
    , @NamedQuery(name = "Adresse.findByTel", query = "SELECT a FROM Adresse a WHERE a.tel = :tel")})
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ADRESSE")
    private String idAdresse;
    @Basic(optional = false)
    @Column(name = "NUMERO_CIVIQUE")
    private String numeroCivique;
    @Basic(optional = false)
    @Column(name = "RUE")
    private String rue;
    @Basic(optional = false)
    @Column(name = "BUREAU")
    private String bureau;
    @Basic(optional = false)
    @Column(name = "VILLE")
    private String ville;
    @Basic(optional = false)
    @Column(name = "CODE_POSTAL")
    private String codePostal;
    @Basic(optional = false)
    @Column(name = "PROVINCE")
    private String province;
    @Basic(optional = false)
    @Column(name = "PAYS")
    private String pays;
    @Basic(optional = false)
    @Column(name = "TEL")
    private String tel;

    public Adresse() {
    }

    public Adresse(String idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Adresse(String idAdresse, String numeroCivique, String rue, String bureau, String ville, String codePostal, String province, String pays, String tel) {
        this.idAdresse = idAdresse;
        this.numeroCivique = numeroCivique;
        this.rue = rue;
        this.bureau = bureau;
        this.ville = ville;
        this.codePostal = codePostal;
        this.province = province;
        this.pays = pays;
        this.tel = tel;
    }

    public String getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(String idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getNumeroCivique() {
        return numeroCivique;
    }

    public void setNumeroCivique(String numeroCivique) {
        this.numeroCivique = numeroCivique;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getBureau() {
        return bureau;
    }

    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdresse != null ? idAdresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.idAdresse == null && other.idAdresse != null) || (this.idAdresse != null && !this.idAdresse.equals(other.idAdresse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stageo.modele.Adresse[ idAdresse=" + idAdresse + " ]";
    }
    
}
