package UserInterface.Viejo;
/** 
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Controlador.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
*/
/**
 * FXML Controller class
 *
 * @author jonat
 */

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;



public class SplashScreenForm {
    private static JFrame       frmSplash;
    private static JProgressBar prbLoading;
    private static ImageIcon    icoImagen;
    private static JLabel       lblSplash;

    public static void show() {
        //icoImagen = new ImageIcon(IAStyle.URL__SPLASH);
        lblSplash = new JLabel(icoImagen);
        prbLoading = new JProgressBar(0, 100);

        prbLoading.setStringPainted(true);

        frmSplash = new JFrame();
        frmSplash.setUndecorated(true);
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
        frmSplash.add(prbLoading, BorderLayout.SOUTH);
        frmSplash.setSize(icoImagen.getIconWidth(),icoImagen.getIconHeight());
        frmSplash.setLocationRelativeTo(null);

        frmSplash.setVisible(true);
        for(int time = 0; time<=100;time++){
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            prbLoading.setValue(time);
        }
        frmSplash.setVisible(false);
    }

/** 
    private Stage stage;
    @FXML
    private Button dasdasd;
    @FXML
    private Label texto;

    /*
     * Initializes the controller class.
     */
    /*@Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void dasdasd(ActionEvent event) {
        for(int i =0;i<101;i++){
            System.out.println(""+i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(SplashScreenForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/vista/VentanaMenu.fxml"));
            Pane ventana = (Pane) loader.load();
            
            Scene scene = new Scene(ventana);
            stage.setScene(scene);
            stage.show();
            this.stage.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    */
}
