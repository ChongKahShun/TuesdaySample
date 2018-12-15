    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.Serializable;

/**
 *
 * @author SasaHui
 */
public class Product implements Serializable, Comparable<Product>{
    //Declare variable for class
    private String name;    
    private String type;
    private double price;
    private String description;
    private int pQuantity;
    private String promotionMonth;
    private double discountPrice;
    //Declare function for class will be used in add button
    public Product(String name, String type, String description,String monthlyPromotion,double price, int quantity,double discountPrice){
        this.name=name;
        this.type= type;
        this.description = description;
        this.price=price;
        this.pQuantity=quantity;
        this.promotionMonth=monthlyPromotion;
        this.discountPrice=discountPrice;
    }
    //Get set for variable
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getType(){
      return type;
  }
  
  public void setType(String type){
      this.type = type;
  }
  
  public String getDescription(){
      return description;
  }
  
  public void setDescription(String description){
      this.description = description;
  }
  
  public double getPrice(){
      return price;
  }
  
  public void setPrice(double price){
      this.price=price; 
  }
  
  public void setQuantity(int pQuantity){
      this.pQuantity=pQuantity; 
  }
  public int getQuantity(){
     return pQuantity;
  }
    public String getmonth() {
    return promotionMonth;
  }

  public void setmonth(String promotion) {
    this.promotionMonth = promotion;
  }
  
    public double getDiscount() {
    return discountPrice;
  }

  public void setDiscount(double discount) {
    this.discountPrice = discount;
  }
  //show
  public String toString() {
      String s = "";
      return s+=String.format("%-30s %-50s %-30.2f %-30d %-30s\n",name,type,discountPrice,pQuantity,description);
  }

    @Override
    public int compareTo(Product o) {
        if(this.getName().compareTo(o.getName()) > 0)
            return 1;
        return 0;
    }
}
