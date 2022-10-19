/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import entites.Categorie;
import utiles.DataDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ServiceCategorie {
    Connection cnx = DataDB.getInstance().getCnx();
    
    
    public void ajouter_categorie (Categorie C ) {
        try {
            String requete = "INSERT INTO Categorie (nomCategorie) VALUES ('" + C.getNomCategorie() + "')";
            System.out.println("1C");
            Statement st = cnx.createStatement();
            System.out.println("2C");
            st.executeUpdate(requete);
            System.out.println("Categorie ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("problème IcI");
        }
        
        
    }
    
    
    public void modifier_categorie (Categorie C) {
        try {
            
            String requete = "UPDATE Categorie SET nomCategorie='" +C.getNomCategorie()  + "' WHERE idCategorie=" + C.getIdCategorie() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Categorie modifiée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimer_categorie(Categorie C ) {
        try {
            String requete = "DELETE FROM Categorie WHERE idCategorie=" + C.getIdCategorie() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println(" Categorie supprimée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Categorie> afficher() {
        List<Categorie> list = new ArrayList<>();

        try {
            String requete = "SELECT idCategorie,nomCategorie FROM Categorie ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Categorie(rs.getLong(1),rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    
}