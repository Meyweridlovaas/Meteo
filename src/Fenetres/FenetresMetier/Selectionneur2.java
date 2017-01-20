/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetres.FenetresMetier;

import javafx.scene.image.Image;

/**
 *
 * @author flsarret
 */
public class Selectionneur2 extends SelectionneurImage{
    public static Image GLACON_IMG = new Image(IconeWindowController.class.getResource("/Images/glaçons.jpg").toExternalForm());
    public static Image NUAGE_IMG = new Image(IconeWindowController.class.getResource("/Images/nuage.jpg").toExternalForm());
    public static Image SOLEIL_IMG = new Image(IconeWindowController.class.getResource("/Images/soleil.png").toExternalForm());
    Image imRes;
    
    
    //Méthode de définition des intervalles de changement d'image.
    @Override 
    public Image selectionImage(double temperature){
        if (temperature <= 5)
            imRes = GLACON_IMG;
        else if (temperature < 17)
            imRes = NUAGE_IMG;
        else 
            imRes = SOLEIL_IMG;
        return imRes;
    }
}
