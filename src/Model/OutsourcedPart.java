/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Jhfar
 */
public class OutsourcedPart extends Part {
    
    StringProperty companyName = new SimpleStringProperty();
   
    public OutsourcedPart (Inventory inventory, String partName, double partPrice, int partInStock, int partMin, int partMax, String compName) {
        super(inventory, partName, partPrice, partInStock, partMin, partMax);
        this.companyName.set(compName);
    }
    
    public OutsourcedPart (int Id, String partName, double partPrice, int partInStock, int partMin, int partMax, String compName) {
        super(Id, partName, partPrice, partInStock, partMin, partMax);
        this.companyName.set(compName);
    }
    
    public void setCompanyName(String name) {
        companyName.set(name);
    }
    
    public String getCompanyName() {
        return companyName.get();
    }
}
