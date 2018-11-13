/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Jhfar
 */
public class Product {
    
    private ArrayList<Part> associatedParts = new ArrayList<Part>();
    private IntegerProperty productID = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty(); 
    private DoubleProperty price = new SimpleDoubleProperty();
    private IntegerProperty inStock = new SimpleIntegerProperty();
    private IntegerProperty min = new SimpleIntegerProperty();
    private IntegerProperty max = new SimpleIntegerProperty();
    
    /*Add constructor here*/
    
    public void setName(String name) {
        
    }
    
    public String getName() {
        return name.get();
    }
    
    public void setPrice(Double newPrice) {
        price.set(newPrice);
    }
    
    public double getPrice() {
        return price.get();
    }
    
    public void setInStock(int number) {
        inStock.set(number);
    }
    
    public int getInStock() {
        return inStock.get();
    }
    
    public void setMin(int newMin) {
        min.set(newMin);
    }
    
    public int getMin() {
        return min.get();
    }
    
    public void setMax(int newMax) {
        max.set(newMax);
    }
    
    public int getMax () {
        return max.get();
    }
    
    public void addAssociatedPart(Part ... part) {
        /* I need to be a loop through part*/
        for(Part newPart : part){
            
        }
    }
    
    public void removeAllAssociatedParts() {
       associatedParts.clear();
   }
    public boolean removeAssociatedPart(int ... Id) {
        /* I need to be a loop through part*/
        /* can't decide if there is a need for this to be varargs*/
        
        boolean changedVal = false;
        
        for(int partID : Id){
            for(Part part : associatedParts){
                if (part.getPartID() == partID){
                    associatedParts.remove(part);
                    changedVal = true;
                }
            }
        }
        return changedVal;
    }
    
    public Part lookupAssociatedPart(int id) {
        for(Part part: associatedParts){
            if(part.getPartID() == id){
                return part;
            }
        }
        return null;
    }
    
    public void setProductID(int Id) {
        productID.set(Id);
    }
    
    public int getProductID() {
        return productID.get();
    }
}
