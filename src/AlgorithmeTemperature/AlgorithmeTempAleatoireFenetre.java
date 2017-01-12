/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmeTemperature;

import static java.lang.Math.random;

/**
 *
 * @author vagonon1
 */
public class AlgorithmeTempAleatoireFenetre extends AlgorithmeTemperature{
    
    private static final double VALEUR_PAR_DEFAULT=15;
    private static final double FENETRE_PAR_DEFAULT=3;
    
    private double valeur;
    private double fenetre;

    public AlgorithmeTempAleatoireFenetre() {
        valeur=VALEUR_PAR_DEFAULT;
        fenetre=FENETRE_PAR_DEFAULT;
    }
    
    public void setValeur(double valeur){
        this.valeur=valeur;
    }
    
    public void setFenetre(double fenetre){
        this.fenetre=fenetre>0?fenetre:this.fenetre;
    }   
    
    @Override
    public double genererTemperature() {
        valeur+=random()*fenetre*2-fenetre;
        return valeur;
    }
    
    @Override
    public String toString(){
        return "température aléatoire fenêtré";
    }
}
