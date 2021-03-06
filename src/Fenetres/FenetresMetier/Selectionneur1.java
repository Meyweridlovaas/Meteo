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
public class Selectionneur1 extends SelectionneurImage{
    public static Image GLACON_IMAGE = new Image(IconeWindowController.class.getResource("/Images/glaçons.jpg").toExternalForm());
    public static Image SOLEIL_IMAGE = new Image(IconeWindowController.class.getResource("/Images/soleil.png").toExternalForm());
    Image imageCourante;
    
    
    /**
     * sélectionne une image
     * 
     * @param temperature
     * température permettant de déterminer l'image
     * 
     * @return l'image sélectionnée 
     */
    @Override 
    public Image selectionImage(double temperature){
        if (temperature <= 15)
            imageCourante = GLACON_IMAGE;
        else
            imageCourante = SOLEIL_IMAGE;
        return imageCourante;
    }
}
