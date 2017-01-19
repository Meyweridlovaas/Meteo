/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmeTemperature;

/**
 *
 * @author vagonon1
 */
public class AlgorithmeTempConstant extends AlgorithmeTemperature{
    
    private static final double VALEUR_PAR_DEFAULT=13.37;
    
    private double valeur;

    public AlgorithmeTempConstant() {
        valeur=VALEUR_PAR_DEFAULT;
    }
    
    public void setValeur(double valeur){
        this.valeur=valeur;
    }    
    
    @Override
    public double genererTemperature() {
        return valeur;
    }
    
    @Override
    public String toString(){
        return "température constant";
    }

    @Override
    public void setParametres(double... arguments) {
        setValeur(arguments[0]);
    }
    
}
