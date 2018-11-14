/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/* Replace ListProperty with an actual array that holds the type classes defined part and product */



/**
 *
 * @author Jhfar
 */
public class Inventory {
   private ObservableList<Product> allProducts = FXCollections.observableArrayList();
   private ObservableList<Part> allParts = FXCollections.observableArrayList();
   /*Add 2 private variables that are lists that will integers
   one will be for products, one will be for parts. When they are added 
   lines of code will need to be added to the constructors to verify values
   increment the list by one, set the of the ID member variable for the given 
   type.
   */
    
   public ObservableList<Part> returnAllParts() {
       return this.allParts;
   }
   
   public ObservableList<Product> returnAllProducts() {
       return this.allProducts;
   }
   
   public ObservableList<Part> searchParts(String searchValue) {
       ObservableList<Part> searchResults = FXCollections.observableArrayList();
              
       Part[] interumStateSearchValues = allParts.toArray(new Part[0]);
       ArrayList<Part> searchableValues = new ArrayList<Part>(Arrays.asList(interumStateSearchValues));
       
       for(Part part : searchableValues) {
          if (part.getName().toLowerCase().equals(searchValue)) {
              searchResults.add(part);
          }else if(searchValue.isEmpty()) {
              searchResults = allParts;
          }
       }
      return searchResults;
   } 
   
  /* public ObservableList<Part> searchParts(int searchValue) {
       
       
   }*/
   
   public void addProduct(Product product) {
       allProducts.add(product);
   } 
    
   public boolean removeProduct(int Id) {
       
       for(Product product : allProducts){
           if (product.getProductID() == Id){
               return allProducts.remove(product);
           } 
       }     
       return false;
   }
   
   public Product lookupProduct(int Id) {
              
       for(Product product : allProducts){
           if (product.getProductID() == Id) {
               return product;
           }
       }
       return null;
   }
   
   public void updateProduct(int Id, ArrayList<Part> associatedParts, String productName, double productPrice, int productMin, int productMax) {
       for(Product product : allProducts) {
           if (product.getProductID() == Id){
               product.removeAllAssociatedParts();
               product.addAssociatedPart(associatedParts.toArray(new Part[0]));
               product.setName(productName);
               product.setPrice(productPrice);
               product.setMin(productMin);
               product.setMax(productMax);
           }
       }
   }
   
   public void addPart(Part part) {
       allParts.add(part);
   }
   
   public boolean deletePart(Part realPart) {
       /*this is jenky, think about changing the parameter to an int for ID of the part*/
       for(Part part : allParts){
           if (part == realPart){
               return allParts.remove(part);
           } 
       }     
       return false;
   }
   
   public Part lookupPart(int Id) {
       for(Part part : allParts){
           if (part.getPartID() == Id){
               return part;
            } 
       }     
       return null;
   }
   
   /*This class may have some inheritance issues because I don't know how it will handle being of type Part when there are two subclasses inhouse and outsourced.*/
   /*There could be some problems, I am going to overload this function to execute different code based off of argtypes*/
   /*If this does give problems will probably need to figure out how to cast this to the subclass*/
   public void updatePart (int ID, String partName, double partPrice, int partMin, int partMax, int partMachineId) {
       for(Part part : allParts){
           if (part.getPartID() == ID){
               part.setName(partName);
               part.setPrice(partPrice);
               part.setMin(partMin);
               part.setMax(partMax);
               InhousePart inhousePart = (InhousePart)part;
               inhousePart.setMachineID(ID);
               
            } 
       }     
   }
   
   public void updatePart (int ID, String partName, double partPrice, int partMin, int partMax, String partCompanyName) {
       for(Part part : allParts){
           if (part.getPartID() == ID){
               part.setName(partName);
               part.setPrice(partPrice);
               part.setMin(partMin);
               part.setMax(partMax);
               OutsourcedPart outsourcedPart = (OutsourcedPart)part;
               outsourcedPart.setCompanyName(partCompanyName);
               
            } 
       }     
   }
}
