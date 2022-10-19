/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import entites.Competences;
import java.io.IOException;
import services.ServiceCompetences;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import utiles.DataDB;
import javafx.scene.control.cell.PropertyValueFactory ;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AjoutCompetencesController implements Initializable {

    @FXML
    private TextField tfnomComp;
    @FXML
    private Button btAjout;
    @FXML
    private Button btmodif;
    @FXML
    private Button btsupprimer;
    @FXML
    private TableView<Competences> tabcomp;
    @FXML
    private TableColumn<Competences, Long> colidcomp;
    @FXML
    private TableColumn<Competences, String> colnomcomp;
    Connection cnx = DataDB.getInstance().getCnx();
    @FXML
    private Button btret;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showcompetences();
        // TODO
    }    

    @FXML
    private void ajoutcomp(ActionEvent event) {
        ServiceCompetences sp = new ServiceCompetences();
        System.out.println("1");
        //Categorie C = new Categorie();
        System.out.println("2");
        //C.setNomCategorie(tfNomC.getText());
        //System.out.println("3");
        //sp.ajouter_categorie(new Competenecs(tfNomC.getText()));
        Competences Comp = new Competences ();
        System.out.println("object  competence Created");
        Comp.setNomCompetence(tfnomComp.getText());
        sp.ajouter_competence(Comp);
        System.out.println("ok ");
        JOptionPane.showMessageDialog(null,"Competence Ajoutée ! ");
        showcompetences();
    }

    @FXML
    private void modifcomp(ActionEvent event) {
        Competences Comp =tabcomp.getSelectionModel().getSelectedItem();
        ServiceCompetences sp = new ServiceCompetences();
        System.out.println("1");
         Comp.setNomCompetence(tfnomComp.getText());
         sp.modifier_competence(Comp);
         System.out.println("ok ");
        JOptionPane.showMessageDialog(null,"Competence Modifiée ! ");
        showcompetences();
    }

    @FXML
    private void supprimercat(ActionEvent event) {
        Competences Comp =tabcomp.getSelectionModel().getSelectedItem();
        ServiceCompetences sp = new ServiceCompetences();
        System.out.println("1");
        sp.supprimer_competence(Comp);
        JOptionPane.showMessageDialog(null,"Competence Modifiée ! ");
        showcompetences();
    }
    public ObservableList<Competences> afficher() {
        System.out.println("1");
        ObservableList<Competences> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT idCompetence,nomCompetence FROM Competences ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Competences(rs.getLong(1),rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    public void showcompetences(){
        ObservableList<Competences> ListCat =  afficher() ; 
        System.out.println("pas de probleme");
        
        colnomcomp.setCellValueFactory(new PropertyValueFactory<Competences,String>("nomCompetence"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        System.out.println("Pas de Soucis ");
        tabcomp.setItems(ListCat);
        System.out.println("pas de probleme2");
        
        
    }

    @FXML
    private void retourcomp(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
