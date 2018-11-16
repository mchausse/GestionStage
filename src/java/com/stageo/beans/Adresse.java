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
public class Adresse{
    private String idAdresse;
    private String numeroCivique;
    private String rue;
    private String bureau;
    private String ville;
    private String codePostal;
    private String province;
    private String pays;
    private String tel;

    public Adresse() {}

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
