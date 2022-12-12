/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emprunteur;

/**
 *
 * @author nheli
 */
public class emprunteurs {

    private int id, idGroupe;
    private String nom, nom_proprietaire, prenom, sexe, adresse, telephone, type_piece, num_piece, date_creation, description;

    public emprunteurs() {
    }

    public emprunteurs(int id, int idGroupe, String nom, String nom_proprietaire, String prenom, String sexe, String adresse, String telephone, String type_piece, String num_piece, String date_creation, String description) {
        this.id = id;
        this.idGroupe = idGroupe;
        this.nom = nom;
        this.nom_proprietaire = nom_proprietaire;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.telephone = telephone;
        this.type_piece = type_piece;
        this.num_piece = num_piece;
        this.date_creation = date_creation;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom_proprietaire() {
        return nom_proprietaire;
    }

    public void setNom_proprietaire(String nom_proprietaire) {
        this.nom_proprietaire = nom_proprietaire;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType_piece() {
        return type_piece;
    }

    public void setType_piece(String type_piece) {
        this.type_piece = type_piece;
    }

    public String getNum_piece() {
        return num_piece;
    }

    public void setNum_piece(String num_piece) {
        this.num_piece = num_piece;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  

}
