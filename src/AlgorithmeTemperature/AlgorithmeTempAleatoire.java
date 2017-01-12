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
public class AlgorithmeTempAleatoire extends AlgorithmeTemperature{

    @Override
    public double genererTemperature() {        
        return random()*Double.MAX_VALUE*2;
    }
    
    @Override
    public String toString(){
        return "température aléatoire";
    }
    
}
