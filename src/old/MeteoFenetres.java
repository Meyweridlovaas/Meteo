/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Fenetres.IconeWindowController;
import Fenetres.Selectionneur2;
import Fenetres.ThermometreWindowController;

/**
 *
 * @author flsarret
 */
public class MeteoFenetres extends Application {
    
    public static final String TITRE_FENETRE_ICONE = "Icône";
    public static final String TITRE_FENETRE_THERMOMETRE = "Thermomètre";
    public static final double THERMOMETRE_X = 700;
    public static final double THERMOMETRE_Y = 300;
    double temperature = 30;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Stage stage2 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IconeWindow.fxml"));
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("ThermometreWindow.fxml"));
        Parent root = loader.load();
        Parent root2 = loader2.load();
        
        
        IconeWindowController iWController = loader.getController();
        ThermometreWindowController tWController = loader2.getController();
        
        //Sélectionne les intervalles de changement d'image
        iWController.setSelectionneurImage(new Selectionneur2());
        
        iWController.ChoixImage(temperature);
        tWController.setProgres(temperature);
        
        Scene scene = new Scene(root, 100, 100);
        Scene scene2 = new Scene(root2, 200, 300);
        
        stage2.setTitle(TITRE_FENETRE_THERMOMETRE);
        stage2.setX(THERMOMETRE_X);
        stage2.setY(THERMOMETRE_Y);
        stage2.setScene(scene2);
        stage2.show();
        
        primaryStage.setTitle(TITRE_FENETRE_ICONE);
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
