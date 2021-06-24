package ui;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
    @FXML
    public TextField account;
    @FXML
    public PasswordField password;

    private FXMLTest application;


    public void setApp(FXMLTest application) {
        this.application = application;
    }

    @FXML
    public void LOGIN_M(ActionEvent event){
        application.userLogin(account.getText(), password.getText());
    }


    @FXML
    private void CLEAR_M(ActionEvent event) {
        account.setText(null);
        password.setText(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void test(Socket socket, ObjectOutputStream oos) {



    }
}