package com.example.spinner;

import java.io.Serializable;
import java.util.Date;

public class Utilisateur implements Serializable {

    private int image;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private Date datenaissance;

    public Utilisateur() {
    }

    public Utilisateur(int image, String nom, String prenom, String email, String tel, Date datenaissance) {
        this.image = image;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.datenaissance = datenaissance;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }
}
