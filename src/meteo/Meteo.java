/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import AlgorithmeTemperature.AlgorithmeTempAleatoireBorne;
import AlgorithmeTemperature.AlgorithmeTempAleatoireFenetre;
import Fenetres.FenetresMetier.IconeWindowController;
import Fenetres.FenetresMetier.Selectionneur2;
import Fenetres.FenetresMetier.SpinnerWindowController;
import Fenetres.FenetresMetier.ThermometreWindowController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author vagonon1
 */
public class Meteo extends Application {
    
    private static final String NOM_FENETRE_PRINCIPALE="Notre super projet météo !";    
            
    @Override
    public void start(Stage primaryStage) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fenetres/MainWindow.fxml"));
            Parent root =loader.load();

            Scene scene = new Scene(root, 500, 250);

            primaryStage.setTitle(NOM_FENETRE_PRINCIPALE);
            primaryStage.setScene(scene);
            primaryStage.show();        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
