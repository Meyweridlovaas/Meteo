/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meteo;

import AlgorithmeTemperature.AlgorithmeTempAleatoireBorne;
import AlgorithmeTemperature.AlgorithmeTempAleatoireFenetre;
import Fenetres.IconeWindowController;
import Fenetres.Selectionneur2;
import Fenetres.SpinnerWindowController;
import Fenetres.ThermometreWindowController;
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
    
    private static final boolean TEST=false;
    
    private static final String TITLE="Thermostat";
    private static final boolean IS_RESIZABLE=false;
    
    public static final String TITRE_FENETRE_ICONE = "Icône";
    public static final String TITRE_FENETRE_THERMOMETRE = "Thermomètre";
    public static final double THERMOMETRE_X = 700;
    public static final double THERMOMETRE_Y = 300;
    public static final double SPINNER_Y = 300;
    public static final double SPINNER_X = 380;
    double temperature = 30;
            
    @Override
    public void start(Stage primaryStage) throws IOException { 
        if(TEST){//pas beau du tout, juste test
            CapteurAvecAlgorithme c = new CapteurAvecAlgorithme();
            CapteurAvecAlgorithme c2 = new CapteurAvecAlgorithme();
            MegaCapteur mc= new MegaCapteur();
            SpinnerWindowController spinner = new SpinnerWindowController();        

            FXMLLoader loader3=new FXMLLoader(getClass().getResource("/Fenetres/SpinnerWindow.fxml"));
            loader3.setController(spinner);

            Stage stage2 = new Stage();
            Stage stage3 = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fenetres/IconeWindow.fxml"));
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/Fenetres/ThermometreWindow.fxml"));
            Parent root = loader.load();
            Parent root2 = loader2.load();
            Parent root3 = loader3.load();
            
            IconeWindowController iWController = loader.getController();
            ThermometreWindowController tWController = loader2.getController();

            //Sélectionne les intervalles de changement d'image
            iWController.setSelectionneurImage(new Selectionneur2());

            Scene scene = new Scene(root, 100, 100);
            Scene scene2 = new Scene(root2, 150, 300);
            Scene scene3 = new Scene(root3,200,100);
            
            primaryStage.setTitle(TITLE);
            primaryStage.setScene(scene);

            stage3.setScene(scene3);
            primaryStage.setResizable(IS_RESIZABLE);        
            stage2.setResizable(IS_RESIZABLE);
            stage3.setResizable(IS_RESIZABLE);

            stage2.setTitle(TITRE_FENETRE_THERMOMETRE);
            stage3.setTitle(TITLE);
            stage2.setX(THERMOMETRE_X);
            stage2.setY(THERMOMETRE_Y);
            stage2.setScene(scene2);
            stage3.setY(SPINNER_Y);
            stage3.setX(SPINNER_X);
            stage2.show();
            stage3.show();

            primaryStage.setTitle(TITRE_FENETRE_ICONE);
            primaryStage.setScene(scene);
            primaryStage.show();


            mc.ajouterObservateur(spinner);
            mc.ajouterObservateur(iWController);
            mc.ajouterObservateur(tWController);         



            c.setAlgorithme(new AlgorithmeTempAleatoireBorne());
            c2.setAlgorithme(new AlgorithmeTempAleatoireFenetre());

            mc.ajouterCapteur(c);
            mc.ajouterCapteur(c2, 2);
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fenetres/MainWindow.fxml"));
            Parent root =loader.load();

            Scene scene = new Scene(root, 500, 250);

            primaryStage.setTitle("Fenêtre");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
