package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Membership;

import model.Session;
import model.SuperMarket;



public class SuperMarketController extends Controller<SuperMarket>  {
   public SuperMarket getSuperMarket() {
       return this.model;
   }
   
   @FXML private TableView<Membership> membershipsTv;
   @FXML private TextField emailTf;
   @FXML private TextField nameTf;
   
   @FXML private Button deleteBtn;
   @FXML private Button selectBtn;
   @FXML private Button slipBtn;
   
   public Membership getCurrentMembership() {
       return membershipsTv.getSelectionModel().getSelectedItem();
   }
   
   public void handleClose(ActionEvent e) throws IOException {
       stage.close();
   }
   
   public void addMembership(ActionEvent e) throws IOException {
       ViewLoader.showStage(getSuperMarket().getMemberships(), "/view/Membership.fxml", "Add Membership", new Stage());
   }
   
   public void createReport(ActionEvent e) throws IOException {
       //ViewLoader.showStage(getSuperMarket().)
   }
   
   public void selectMembership(ActionEvent e) throws IOException {
       Membership membership = getCurrentMembership();
       //ViewLoader.showStage(membership, fxml, title, stage);*//
   }
   
   @FXML private void initialize() {
       stage.getIcons().add(new Image("view/SuperMarket.png"));
       membershipsTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       membershipsTv.getSelectionModel().selectedItemProperty().addListener( 
               (observable, oldMembership, newMembership) ->
               deleteBtn.setDisable(newMembership == null)
       );
       membershipsTv.getSelectionModel().selectedItemProperty().addListener( 
               (observable, oldMembership, newMembership) ->
               selectBtn.setDisable(newMembership == null)
       );
       membershipsTv.getSelectionModel().selectedItemProperty().addListener( 
               (observable, oldMembership, newMembership) ->
               slipBtn.setDisable(newMembership == null)
       );
       
        
     
    
           
            
   }

   
    
}

