/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package williams_java2_project_8;


import java.io.Serializable;

// StoreItem, this is what the rest are based off of. 
public class StoreItem implements Serializable{
    protected static int itemCount=0;
    protected String title;
    protected String author;
    protected Date dateAcquired;
    protected double purchasePrice; // req doc asks for int
    protected double askingPrice;
    protected boolean inInventory;
    
    protected String type;
    protected int id;
    
    public StoreItem(String title, String author, Date dateAcquired, 
            double purchasePrice, double askingPrice){
        setTitle(title);
        setAuthor(author);
        setDate(dateAcquired);
        setPurchasePrice(purchasePrice);
        setAskingPrice(askingPrice);
        itemCount++;
        inInventory=true;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title=title;
    }
    
    public String getAuthor(){
        return author;
        
    }
    
    public void setAuthor(String author){
        this.author=author;
    }
    
    public void setDate(Date dateAcquired){
        this.dateAcquired=dateAcquired;
    }
    
    public Date getDate(){
        return dateAcquired;
    }
    
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }
    
    public double getPurchasePrice(){
        return purchasePrice;
    }

    public void setAskingPrice(double askingPrice){
        this.askingPrice = askingPrice;
    }
    
    public double getAskingPrice(){
        return askingPrice;
    }
    
    public void setType(String type){
        this.type = type;
    }
    public String returnType(){
        return type;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public int getID(){
        return id;
    }
    
  //  public boolean deal(double custOffer){
        
 //   }
    
    public void remove(){
       inInventory = false;
       itemCount--; 
    }
    
    public boolean inStock(){
        return inInventory;
    }
    
    public String printableString(){
        return "override me";
    };
    

 //   public double calculateComission(double custOffer){
        
//    }
    
    
}
