package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


//added imports
import model.SuperMarkets;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import model.SuperMarket;
import model.Session;


public class MMSLoginController extends Controller<Session>  {
    public String email;
    public String password;
    public Session getSession() {
        return model;
    }
   
            
    @FXML private Label loginLbl;
    @FXML private Label emailLbl;
    
    @FXML private TextField emailTf;
    public final String getEmail() {
        return emailTf.getText();
    }
    public final void clearEmail() {
        emailTf.setText("");
    }
    
    @FXML private PasswordField passwordPf;
    public final String getPassword() {
        return passwordPf.getText();
    }
    private void clearPassword() {
        passwordPf.setText("");
    }
    
    @FXML private Label resultTxt;
    public final void setResult(String message) {
        resultTxt.setText(message);
    }
    
    
    @FXML private Button okBtn;
    public void handleLogin(ActionEvent event) throws IOException {
        email = getEmail();     
        password = getPassword();
       
        if (getSession().getSuperMarket(email, password) != null) {
            getSession().setSuperMarket(getSession().getSuperMarket(email, password));
            String name = getSession().getSuperMarket(email, password).getName();
            ViewLoader.showStage(getSession().getSuperMarket(email, password), "/view/SuperMarket.fxml", "Session Admin: " + name, stage);
            
        }
        else {
            setResult("Incorrect Login Details");
            clearPassword();
            clearEmail();
        }
        
    }
    
    @FXML private void initialize() {
       stage.getIcons().add(new Image("view/book.png"));
    }
    
    @FXML private Button cancelBtn;
    @FXML private void handleCancel(ActionEvent event) {
        stage.close();
    }
    
    
}

