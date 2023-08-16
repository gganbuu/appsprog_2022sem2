package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import model.Membership;
import model.Memberships;
import model.SuperMarket;


public class MembershipController extends Controller<SuperMarket> {
    public SuperMarket getSuperMarket() {
        return model;
    }
    
    @FXML private TextField emailTf;
    public final String getEmail() {
        return emailTf.getText();
    }
    
    @FXML private TextField nameTf;
    public final  String getName() {
        return emailTf.getText();
    }
    
    @FXML private TextField phoneTf;
    public final String getPhone() {
        return emailTf.getText();
    }
    
    @FXML private TextField addressTf;
    public final String getAddress() {
        return emailTf.getText();
    }
    
    @FXML private TextField idTf;
    public final String getID() {
        return emailTf.getText();
    }
    @FXML private TextField expenseTf;
    public final double getExpense() {
        return Double.parseDouble(expenseTf.getText());
    }
    
    public void addMembership(ActionEvent e) throws IOException {
        Membership newMembership = new Membership(getName(),getEmail(),getPhone(),getAddress(),getID(),getExpense());
        getSuperMarket().addMembership(newMembership);
    }
    
    public void handleClose(ActionEvent e) throws IOException {
        stage.close();
    }
    
    @FXML private void initialize() {
       stage.getIcons().add(new Image("view/edit.png"));
    }

}
