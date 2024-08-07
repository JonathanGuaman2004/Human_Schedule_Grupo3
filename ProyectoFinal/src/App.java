
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Clase Java en donde se ejecutar►0nuestro programa
 */
public class App extends Application{
    /**
     * Método de Entrada Principal
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Método de la Aplicacion JavaFx donde el ¨Stage¨ sera la ventana principal de la aplicacion
     */
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
