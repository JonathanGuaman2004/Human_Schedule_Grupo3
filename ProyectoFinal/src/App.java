
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import DataAccess.SQLiteDataHelper;
import DataAccess.DAO.RegistroEmpleado_DAO;
import DataAccess.DTO.RegistroEmpleado_DTO;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
    private double xOffset=0;
    private double yOffset=0;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage)throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/UserInterface/CustomerControl/VentanaMenu.fxml"));
            Pane ventana = (Pane) loader.load();
            
            Scene scene = new Scene(ventana);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
