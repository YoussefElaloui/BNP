package com.example.spinner;

import java.io.Serializable;

public class Pays implements Serializable {

    private String nom;
    private String capital;
    private String continent;
    private int population;
    private int image;

    public Pays() {

    }

    public Pays(String nom, String capital, String continent, int population, int image) {
        this.nom = nom;
        this.capital = capital;
        this.continent = continent;
        this.population = population;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
