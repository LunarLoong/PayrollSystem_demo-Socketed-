package ui;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class MainController implements Initializable{
    private FXMLTest application;
    @FXML
    public Label name_l;
    @FXML
    public Label sex_l;
    @FXML
    public Label phone_l;
    @FXML
    public Label id_l;
    @FXML
    public Label age_l;
    @FXML
    public Label address_l;
    @FXML
    public Label time_l;
    @FXML
    public Label unit_l;
    @FXML
    public Label salary_l;



    public void setApp(FXMLTest application){
        this.application = application;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void get_out(ActionEvent actionEvent) {
        application.userOutMain();
    }
    public void take_money(ActionEvent actionEvent) {
        Alert _alert = new Alert(Alert.AlertType.CONFIRMATION,"领取成功！已经打入卡内。",new ButtonType("确定", ButtonBar.ButtonData.YES));
        _alert.showAndWait();
        application.userOutMain();
    }
}

