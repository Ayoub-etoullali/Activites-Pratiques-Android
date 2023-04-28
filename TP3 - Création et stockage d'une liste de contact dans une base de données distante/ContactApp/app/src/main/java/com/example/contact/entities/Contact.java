package com.example.contact.entities;

import com.example.contact.enums.SIM;

public class Contact {
    private Long id;
    private String prenom;
    private String nom;
    private String email;
    private String tele;
    private SIM sim;

    public Contact(){
        id=0L;
         prenom ="";
         nom ="";
         email="";
         tele ="";
         sim =SIM.SIM_1;
    }
    public Contact(long id, String prenom, String nom, String email, String tele, SIM sim) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.tele = tele;
        this.sim = sim;
    }

    public Contact(Contact contact) {
        this.id = contact.getId();
        this.prenom =  contact.getPrenom();
        this.nom =  contact.getNom();
        this.email =  contact.getEmail();
        this.tele =  contact.getTele();
        this.sim =  contact.getSim();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public SIM getSim() {
        return sim;
    }

    public void setSim(SIM sim) {
        this.sim = sim;
    }
}