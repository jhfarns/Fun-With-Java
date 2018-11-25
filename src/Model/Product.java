/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
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
public class Product {
    
    private ObservableList<Part> associatedParts =  FXCollections.observableArrayList();
    private IntegerProperty productID = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty(); 
    private DoubleProperty price = new SimpleDoubleProperty();
    private IntegerProperty inStock = new SimpleIntegerProperty();
    private IntegerProperty min = new SimpleIntegerProperty();
    private IntegerProperty max = new SimpleIntegerProperty();
    
    public Product() {
        this.productID.set(500);
        this.name.set("Temporary Value");
        this.price.set(0.0);
        this.inStock.set(0);
        this.min.set(0);
        this.max.set(100);
    }
    
    public Product (Inventory inventory, String name, double price, int inStock, int min, int max, ObservableList<Part> associatedParts) {
        this.productID.set(makeID(inventory.returnProductIDList()));
        this.name.set(name);
        this.price.set(price);
        this.inStock.set(inStock);
        this.min.set(min);
        this.max.set(max);
        this.associatedParts.addAll(associatedParts.toArray(new Part[0]));
        
    }
    
    public Product (Inventory inventory, String name, double price, int inStock, int min, int max) {
        this.productID.set(makeID(inventory.returnProductIDList()));
        this.name.set(name);
        this.price.set(price);
        this.inStock.set(inStock);
        this.min.set(min);
        this.max.set(max);
    }
    
    public Product (Inventory inventory, String name, double price, int inStock, int min, int max, Part ... associatedParts) {
        this.productID.set(makeID(inventory.returnProductIDList()));
        this.name.set(name);
        this.price.set(price);
        this.inStock.set(inStock);
        this.min.set(min);
        this.max.set(max);
        this.associatedParts.addAll(associatedParts);
    }
    
    public int makeID(ObservableList<Integer> idList) {
        int ID = idList.size();
        idList.add(ID);
        return ID;
    }
    
    public ObservableList<Part> returnAllParts() {
        return this.associatedParts;
    }
    
    public IntegerProperty productIDProperty() {
        return this.productID;
    }
    
    public StringProperty nameProperty() {
        return this.name;
    }
    
    public IntegerProperty inStockProperty() {
        return this.inStock;
    }
    
    public DoubleProperty priceProperty() {
        return this.price;
    }
    public void setName(String name) {
        this.name.set(name);
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
            associatedParts.add(newPart);
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
