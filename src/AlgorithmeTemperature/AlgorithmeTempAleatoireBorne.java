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
public class AlgorithmeTempAleatoireBorne extends AlgorithmeTemperature{
    
    private static final double MIN_PAR_DEFAULT=15;
    private static final double MAX_PAR_DEFAULT=25;
    
    private double min;
    private double max;

    public AlgorithmeTempAleatoireBorne() {
        min=MIN_PAR_DEFAULT;
        max=MAX_PAR_DEFAULT;
    }
    
    public void setMin(double min){
        this.min=min<max?min:this.min;
    }
    
    public void setMax(double max){
        this.max=max>min?max:this.max;
    }

    @Override
    public double genererTemperature() {
        double ecart=max-min;        
        return ecart*random()+min;
    }
    
    @Override
    public String toString(){
        return "température aléatoire borné";
    }
}
