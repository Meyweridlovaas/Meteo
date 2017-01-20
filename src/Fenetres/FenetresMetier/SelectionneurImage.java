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
public abstract class SelectionneurImage {
    
    /**
     * sélectionne une image
     * 
     * @param temperature
     * température permettant de déterminer l'image
     * 
     * @return l'image sélectionnée 
     */
    public abstract Image selectionImage(double temperature);
}
