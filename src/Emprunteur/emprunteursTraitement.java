/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Emprunteur;

import Pret.Pret;
import devoir_mydreams.outilsBase.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author nheli
 */
public class emprunteursTraitement implements emprunteur_i<emprunteurs> {

    Connection con = null;
    PreparedStatement ps = null;
    StringBuilder sb = null;
    ResultSet rs = null;

    emprunteurs m = new emprunteurs();

    @Override
    public void enregistrer(emprunteurs e) {
        con = DBConnection.getCon();
        sb = new StringBuilder();
        sb.append("INSERT INTO emprunts VALUES( ");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ",");
        sb.append("?" + ")");

        try {
            ps = con.prepareStatement(sb.toString());
            ps.setInt(1, 0);
            ps.setInt(2, e.getIdGroupe());
            ps.setString(3, e.getNom());
            ps.setString(4, e.getNom_proprietaire());
            ps.setString(5, e.getPrenom());
            ps.setString(6, e.getSexe());
            ps.setString(7, e.getAdresse());
            ps.setString(8, e.getTelephone());
            ps.setString(9, e.getType_piece());
            ps.setString(10, e.getNum_piece());
            ps.setString(11, e.getDate_creation());
            ps.setString(12, e.getDescription());

            int conteur = ps.executeUpdate();
            if (conteur == 1) {
                JOptionPane.showMessageDialog(null, "OKE!", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Non Reussi", "Message", JOptionPane.ERROR_MESSAGE);
            }

            if (ps != null) {
                ps.close();
            }

            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Empr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(emprunteurs e) {
        sb = new StringBuilder();
        sb.append(" UPDATE EMPRUNTS SET ");
        sb.append("idGroupe=?" + ",");
        sb.append("nom=?" + ",");
        sb.append("nom_proprietaire=?" + ",");
        sb.append("prenom=?" + ",");
        sb.append("sexe=?" + ",");
        sb.append("adresse=?" + ",");
        sb.append("telephone=?" + ",");
        sb.append("type_piece=?" + ",");
        sb.append("num_piece=?" + ",");
        sb.append("date_creation=?" + ",");
        sb.append("description=?");
        sb.append(" WHERE ID=? ");

        con = DBConnection.getCon();
        try {
            ps = con.prepareStatement(sb.toString());
            ps.setInt(1, e.getIdGroupe());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getNom_proprietaire());
            ps.setString(4, e.getPrenom());
            ps.setString(5, e.getSexe());
            ps.setString(6, e.getAdresse());
            ps.setString(7, e.getTelephone());
            ps.setString(8, e.getType_piece());
            ps.setString(9, e.getNum_piece());
            ps.setString(10, e.getDate_creation());
            ps.setString(11, e.getDescription());
            ps.setInt(12, e.getId());

          int reponse = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment modifier cet emprunt?", "Message", JOptionPane.YES_NO_OPTION);
            if (reponse == JOptionPane.YES_OPTION) {
                  int pM = ps.executeUpdate();
                    if (pM == 1) {
                        JOptionPane.showMessageDialog(null, "Cet emprunt est modifierr avec succes", "Message", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Echec de la modification de cet emprunt", "Message", JOptionPane.ERROR_MESSAGE);
                }


            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(emprunteursTraitement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(String id) {
        sb = new StringBuilder();
        sb.append("DELETE FROM EMPRUNTS ");
        sb.append(" WHERE ID=? ");
        con = DBConnection.getCon();
        try {
            ps = con.prepareStatement(sb.toString());
            ps.setString(1, id);

            int reponse = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer cet emprunt?", "Message", JOptionPane.YES_NO_OPTION);
            if (reponse == JOptionPane.YES_OPTION) {
                int p = ps.executeUpdate();
                if (reponse > 0) {
                    JOptionPane.showMessageDialog(null, "Cet emprunt est supprime avec succes", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Echec de la suppression de cet emprunt", "Message", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(emprunteursTraitement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<emprunteurs> afficher() {
        ArrayList<emprunteurs> aff = new ArrayList<emprunteurs>();
        con = DBConnection.getCon();
        String req = " SELECT* FROM emprunts; ";
        try {
            ps = con.prepareStatement(req.toString());
            rs = ps.executeQuery();
            emprunteurs m = null;
            while (rs.next()) {
                m = new emprunteurs();
                m.setId(rs.getInt(1));
                m.setIdGroupe(rs.getInt(2));
                m.setNom(rs.getString(3));
                m.setNom_proprietaire(rs.getString(4));
                m.setPrenom(rs.getString(5));
                m.setSexe(rs.getString(6));
                m.setAdresse(rs.getString(7));
                m.setTelephone(rs.getString(8));
                m.setType_piece(rs.getString(9));
                m.setNum_piece(rs.getString(10));
                m.setDate_creation(rs.getString(11));
                m.setDescription(rs.getString(12));
                aff.add(m);
            }

            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(emprunteursTraitement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aff;
    }

    public emprunteurs rechercher(String code) {
        emprunteurs ep = new emprunteurs();
        sb = new StringBuilder();
        sb.append(" SELECT* FROM emprunts ");
        sb.append(" WHERE ID=? ");
        con = DBConnection.getCon();
        try {
            ps = con.prepareStatement(sb.toString());
            ps.setString(1, code);
            rs = ps.executeQuery();
            if (rs.next()) {
                ep.setId(rs.getInt(1));
                ep.setIdGroupe(rs.getInt(2));
                ep.setNom(rs.getString(3));
                ep.setNom_proprietaire(rs.getString(4));
                ep.setPrenom(rs.getString(5));
                ep.setSexe(rs.getString(6));
                ep.setAdresse(rs.getString(7));
                ep.setTelephone(rs.getString(8));
                ep.setType_piece(rs.getString(9));
                ep.setNum_piece(rs.getString(10));
                ep.setDate_creation(rs.getString(11));
                ep.setDescription(rs.getString(12));

            }
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(emprunteursTraitement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ep;
    }

    public ArrayList<emprunteurs> getAllCritere(String critere) {
        ArrayList<emprunteurs> emp = new ArrayList<emprunteurs>();
        sb = new StringBuilder();
        sb.append(" SELECT* FROM EMPRUNTS ");
        sb.append(" WHERE (ID like ? ");
        sb.append(" OR IDGROUPE like ? ");
        sb.append(" OR NOM like ? ");
        sb.append(" OR NOM_PROPRIETAIRE like ? ");
        sb.append(" OR PRENOM like ? ");
        sb.append(" OR SEXE like ? ");
        sb.append(" OR ADRESSE like ? ");
        sb.append(" OR TELEPHONE like ? ");
        sb.append(" OR TYPE_PIECE like ? ");
        sb.append(" OR NUM_PIECE like ? ");
        sb.append(" OR DATE_CREATION like ? ");
        sb.append(" OR DESCRIPTION like ?) ");
        con = DBConnection.getCon();
        try {
            ps = con.prepareStatement(sb.toString());
            ps.setString(1, "%" + critere + "%");
            ps.setString(2, "%" + critere + "%");
            ps.setString(3, "%" + critere + "%");
            ps.setString(4, "%" + critere + "%");
            ps.setString(5, "%" + critere + "%");
            ps.setString(6, "%" + critere + "%");
            ps.setString(7, "%" + critere + "%");
            ps.setString(8, "%" + critere + "%");
            ps.setString(9, "%" + critere + "%");
            ps.setString(10, "%" + critere + "%");
            ps.setString(11, "%" + critere + "%");
            ps.setString(12, "%" + critere + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                emprunteurs e = new emprunteurs();
                e.setId(rs.getInt(1));
                e.setIdGroupe(rs.getInt(2));
                e.setNom(rs.getString(3));
                e.setNom_proprietaire(rs.getString(4));
                e.setPrenom(rs.getString(5));
                e.setSexe(rs.getString(6));
                e.setAdresse(rs.getString(7));
                e.setTelephone(rs.getString(8));
                e.setType_piece(rs.getString(9));
                e.setNum_piece(rs.getString(10));
                e.setDate_creation(rs.getString(11));
                e.setDescription(rs.getString(12));
                emp.add(e);

            }
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(emprunteursTraitement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emp;
    }

    @Override
    public double RechercheMontantZero(emprunteurs reZero) {
             double retZero = 0.0;
        sb = new StringBuilder();
        sb.append(" SELECT * FROM PRET ");
        sb.append(" WHERE IDGROUPE=? ");
        con = DBConnection.getCon();
        try {
            ps = con.prepareStatement(sb.toString());
            ps.setInt(1, reZero.getIdGroupe());
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("IDGROUPE") == reZero.getIdGroupe()) {
                    retZero = rs.getDouble("interet");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(emprunteursTraitement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retZero;
    }

    @Override
    public int RechercheIdGroupeExiste(emprunteurs i) {
       int n = 0;
        sb = new StringBuilder();
        sb.append(" SELECT * FROM EMPRUNTS ");
        sb.append(" WHERE IDGROUPE=? ");
        con = DBConnection.getCon();
        try {
            ps = con.prepareStatement(sb.toString());
            ps.setInt(1, i.getIdGroupe());
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("IDGROUPE") == i.getIdGroupe()) {
                    n = rs.getInt("IDGROUPE");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(emprunteursTraitement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
