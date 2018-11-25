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
   private ObservableList<Integer> partIdList = FXCollections.observableArrayList();
   private ObservableList<Integer> productIdList = FXCollections.observableArrayList();

   /*
   -overload addProduct mehtod with boolean value. True to call creatID on the
   product and set it.
   -Have overlaoded value set ID value you to newly generated value
   ParameterProduct.setProductID(ParameterProduct.makeID(inventory.returnProductIDList()));
   */
   
   
   public ObservableList<Integer> returnProductIDList(){
       return this.productIdList;
   }
   
   
   public ObservableList<Integer> returnIDList(){
       return this.partIdList;
   }
   
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
   
  public ObservableList<Part> searchParts(int searchValue) {
        ObservableList<Part> searchResults = FXCollections.observableArrayList();
              
       Part[] interumStateSearchValues = allParts.toArray(new Part[0]);
       ArrayList<Part> searchableValues = new ArrayList<Part>(Arrays.asList(interumStateSearchValues));
       
       for(Part part : searchableValues) {
          if (part.getPartID() == searchValue) {
              searchResults.add(part);
          }
       }
      return searchResults;
       
   }
  
  public ObservableList<Product> searchProducts(String searchValue){
       ObservableList<Product> searchResults = FXCollections.observableArrayList();

       Product[] interumStateSearchValues = allProducts.toArray(new Product[0]);
       ArrayList<Product> searchableValues = new ArrayList<Product>(Arrays.asList(interumStateSearchValues));
       
       for(Product product : searchableValues) {
          if (product.getName().toLowerCase().equals(searchValue)) {
              searchResults.add(product);
          }else if(searchValue.isEmpty()) {
              searchResults = allProducts;
          }
       }
       return searchResults;
  }
  
  public ObservableList<Product> searchProducts(int searchValue) {
       ObservableList<Product> searchResults = FXCollections.observableArrayList();

       Product[] interumStateSearchValues = allProducts.toArray(new Product[0]);
       ArrayList<Product> searchableValues = new ArrayList<Product>(Arrays.asList(interumStateSearchValues));
       
       for(Product product : searchableValues) {
          if (product.getProductID() == searchValue) {
              searchResults.add(product);
          }
       }
      return searchResults;
  }
   
   public void addProduct(Product product) {
       allProducts.add(product);
   } 
   
   public void addProduct(Product product, boolean value) {
       product.setProductID(product.makeID(this.productIdList));
       if(value) {
           allProducts.add(product);
       }
   }
    
   public boolean removeProduct(int Id) {
       
       Product[] interumStateSearchValues = allProducts.toArray(new Product[0]);
       ArrayList<Product> searchableValues = new ArrayList<Product>(Arrays.asList(interumStateSearchValues));
       
       for(Product product : searchableValues){
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
       Part[] interumStateSearchValues = allParts.toArray(new Part[0]);
       ArrayList<Part> searchableValues = new ArrayList<Part>(Arrays.asList(interumStateSearchValues));
       
       for(Part part : searchableValues){
           if (part.getPartID() == realPart.getPartID()){
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
