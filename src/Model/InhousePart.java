/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Jhfar
 */
public class InhousePart extends Part {
    
    IntegerProperty machineID = new SimpleIntegerProperty();
    
    public InhousePart (int Id, String partName, double partPrice, int partInStock, int partMin, int partMax, int mId) {
        super(Id, partName, partPrice, partInStock, partMin, partMax);
        this.machineID.set(mId);
    }
    
    public void setMachineID (int Id) {
        machineID.set(Id);
    }
    
    public int getMachineID () {
        return machineID.get();
    }
}
