/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;


/**
 *
 * @author vagonon1
 */
public class OldCaptor {    
    private FloatProperty temperature = new SimpleFloatProperty();
    
    public FloatProperty temperatureProperty(){
        return temperature;
    }
    
    public OldCaptor(int temperature){
        SetTemperature(temperature);
    }
    
    public void SetTemperature(int temperature){
        this.temperature.set(temperature);
    }
    
    public float GetTemperature(){
        return temperature.get();
    }
    
    @Override public String toString(){
        return "temperature : "+temperature;
    }
}
