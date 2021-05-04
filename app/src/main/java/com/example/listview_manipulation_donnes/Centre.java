package com.example.listview_manipulation_donnes;

public class Centre {
    private int id ;
    private String nom,ville,latitude,longitude;

    public Centre(int id, String nom, String ville, String latitude, String longitude) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Centre( String nom, String ville, String latitude, String longitude) {
        this.nom = nom;
        this.ville = ville;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Centre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
