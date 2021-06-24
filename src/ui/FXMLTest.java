package ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.factory.MysqlDaoFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import staffManagement.*;

public class FXMLTest extends Application {
    private Stage stage;
    private final double MINIMUM_WINDOW_WIDTH = 600.0;
    private final double MINIMUM_WINDOW_HEIGHT = 420.0;

    public Socket socket;
    public ObjectOutputStream oos;
    public ObjectInputStream ois;

    public Objectpool objectpool;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Payroll System");
        stage.setMaxWidth(MINIMUM_WINDOW_WIDTH);
        stage.setMaxHeight(MINIMUM_WINDOW_HEIGHT);
        //链接服务器
        this.socket = new Socket("127.0.0.1", 4041);
        this.objectpool = Objectpool.getInstance();
        gotoLogin();
        stage.show();
    }

    public void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("login.fxml");
            login.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(FXMLTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoMain() {
        try {
            TimeEmployee timeEmployee = (TimeEmployee) objectpool.getObject("TimeEmployee");

            MainController main = (MainController) replaceSceneContent("main.fxml");
            main.setApp(this);
            main.name_l.setText(timeEmployee.getName());
            main.sex_l.setText(timeEmployee.getSex());
            main.age_l.setText(timeEmployee.getAge());
            main.id_l.setText(timeEmployee.getEID());
            main.phone_l.setText(timeEmployee.getPhone());
            main.address_l.setText(timeEmployee.getAddress());
            main.time_l.setText(String.valueOf(timeEmployee.getWorkTimeCard().getTime()));
            main.unit_l.setText(String.valueOf(timeEmployee.getWorkTimeCard().getUnit()));
            main.salary_l.setText(String.valueOf(timeEmployee.getSalary()));
        } catch (Exception ex) {
            Logger.getLogger(FXMLTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void userLogin(String account, String password) {
        IService target = (EmployeeServiceImpl) objectpool.getObject("EmployeeServiceImpl");
        TimeEmployee timeEmployee = (TimeEmployee) objectpool.getObject("TimeEmployee");
        IService proxy = (IService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new EmployeeService(target)
        );
        Call call = proxy.detail(timeEmployee);

        timeEmployee.setEID(account);
        timeEmployee.setPassword(password);

        try {
            //使用socket的输出流（对象输出）
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(call);
            oos.flush();

            System.out.println("客户端发送方法：" + call.getClassName() + "." + call.getMethodName());
            this.ois = new ObjectInputStream(socket.getInputStream());
            //读取服务端返回的call对象
            call = (Call) ois.readObject();

            TimeEmployee o = (TimeEmployee) call.getReturnObj();
            System.out.println(o.getName());
            if (!o.getName().equals("UnKnown")) {
                timeEmployee.setName(o.getName());
                timeEmployee.setAge(o.getAge());
                timeEmployee.setSex(o.getSex());
                timeEmployee.setAddress(o.getAddress());
                timeEmployee.setEID(o.getEID());
                timeEmployee.setPhone(o.getPhone());
                timeEmployee.setPassword(o.getPassword());
                timeEmployee.getWorkTimeCard().setTime(o.getWorkTimeCard().getTime());
                timeEmployee.getWorkTimeCard().setUnit(o.getWorkTimeCard().getUnit());
                timeEmployee.getSalaryStrategy().setTime(o.getWorkTimeCard().getTime());
                timeEmployee.getSalaryStrategy().setUnit(o.getWorkTimeCard().getUnit());
                timeEmployee.getSalary();
                gotoMain();
            }
            oos.close();
            ois.close();
//            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void userOutMain() {
        gotoLogin();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = FXMLTest.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(FXMLTest.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 600, 500);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
