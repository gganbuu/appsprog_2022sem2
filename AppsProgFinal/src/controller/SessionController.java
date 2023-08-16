package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.image.*;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException; //for getSession()
import javafx.application.Platform;
import javafx.stage.Stage;
import model.Session;



public class SessionController extends Controller<Session>{
    
    public Session getSession() {
        return model; 
    }
    
    
    @FXML private ImageView sessionImgV;
    
    @FXML private Button exitBtn;
    @FXML private void handleExit(ActionEvent event) {
        Platform.exit();
    }
    
    @FXML private Button loginBtn;
    @FXML private void handleLogin(ActionEvent event) throws IOException {
        ViewLoader.showStage(getSession(), "/view/MMSlogin.fxml", "Sign In", new Stage());
    }
    @FXML private Text mmsTxt; 
}
