/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jhfar
 */
public abstract class Part {
    IntegerProperty partID = new SimpleIntegerProperty();
    StringProperty name = new SimpleStringProperty();
    DoubleProperty price = new SimpleDoubleProperty();
    IntegerProperty inStock = new SimpleIntegerProperty();
    IntegerProperty min = new SimpleIntegerProperty(); 
    IntegerProperty max = new SimpleIntegerProperty();
  
    public Part(Inventory inventory, String partName, double partPrice, int partInStock, int partMin, int partMax) {
        
        
        partID.set(makeID(inventory.returnIDList()));
        name.set(partName);
        price.set(partPrice);
        inStock.set(partInStock);
        min.set(partMin);
        max.set(partMax);
    }
    
    
    
    public Part(int Id, String partName, double partPrice, int partInStock, int partMin, int partMax) {
        partID.set(Id);
        name.set(partName);
        price.set(partPrice);
        inStock.set(partInStock);
        min.set(partMin);
        max.set(partMax);
    }
    
    public int makeID(ObservableList<Integer> idList) {
       int ID = idList.size();
       idList.add(ID);
       return ID;
    }
    
    public void setName(String partName) {
        name.set(partName);
    }
    
    public String getName() {
        return name.get();
    }
    
    public IntegerProperty partIDProperty() {
        return partID;
    }
    
    public StringProperty nameProperty() {
        return name;
    }
    
    public IntegerProperty partLevelProperty() {
        return inStock;
    }
    
    public DoubleProperty partPriceProperty() {
        return price;
    }
    public void setPrice(double partPrice) {
        price.set(partPrice);
    }
    
    public double getPrice() {
        return price.get();
    }
    
    public void setInStock(int number) {
        inStock.set(number);
    }
    
    public int getIntStock() {
        return inStock.get();
    }
    
    public void setMin(int partMin) {
        min.set(partMin);
    }
    
    public int getMin() {
        return min.get();
    }
    
    public void setMax(int partMax) {
        max.set(partMax);
    }
    
    public int getMax() {
        return min.get();
    }
    
    public void setPartID(int Id) {
        partID.set(Id);
    }
    
    public int getPartID() {
        return partID.get();
    }
}
