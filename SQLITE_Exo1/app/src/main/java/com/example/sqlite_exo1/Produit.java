package com.example.sqlite_exo1;

public class Produit {
    private int id;
    private String libelle;
    private String famille;
    private double prix_achat;
    private double prix_vente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produit(int id, String libelle, String famille, double prix_achat, double prix_vente) {
        this.id = id;
        this.libelle = libelle;
        this.famille = famille;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public double getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(double prix_achat) {
        this.prix_achat = prix_achat;
    }

    public double getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }

    public Produit() {
    }

    public Produit(String libelle, String famille, double prix_achat, double prix_vente) {
        this.libelle = libelle;
        this.famille = famille;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
    }
}
