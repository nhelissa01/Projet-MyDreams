/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emprunteur;

import java.util.ArrayList;

/**
 *
 * @author nheli
 */
public interface emprunteur_i<emprunteurs> {
    void enregistrer(emprunteurs e);
    void modifier(emprunteurs e);
    void supprimer(String id);
    ArrayList<emprunteurs> afficher();
    emprunteurs rechercher( String id);
     int RechercheIdGroupeExiste(emprunteurs i);
    double RechercheMontantZero(emprunteurs reZero);
}
