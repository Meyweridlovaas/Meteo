/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * FXML Controller class
 *
 * @author vagonon1
 */
public class MainWindowController implements Initializable, Observer {

    /**
     * Initializes the controller class.
     */
    
    OldCaptor capt;
    @FXML Spinner<Float> spinner;
    ObjectProperty<Float> opf;
    //SpinnerValueFactory.DoubleSpinnerValueFactory truc=new SpinnerValueFactory.DoubleSpinnerValueFactory(0,10);
    
    
    public MainWindowController(OldCaptor capt){
        this.capt=capt;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spinner.setValueFactory(new SpinnerValueFactory<Float>() {

            @Override
            public void decrement(int steps) {
                setValue(getValue()-0.1f);
            }

            @Override
            public void increment(int steps) {
                setValue(getValue()+0.1f);
                System.out.println(capt);
            }
        });
        opf=capt.temperatureProperty().asObject();
        spinner.getValueFactory().valueProperty().bindBidirectional(opf);
        capt.temperatureProperty().addListener((o,ol,n)->System.out.println(ol+" "+n));
    }    

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
