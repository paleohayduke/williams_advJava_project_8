/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package williams_java2_project_8;

// This Class is designed to hold info about books, it extends StoreItem
public class Book extends StoreItem{
    static int bookCount = 0;

    String genre;

    // create it with constructor 
    public Book(String title, String author, Date dateAcquired, double purchasePrice,
            double askingPrice, String genre){
        super(title, author, dateAcquired,purchasePrice, askingPrice);
        setTitle(title);
        setGenre(genre);
        bookCount++;
        
//        String title, String author, Date dateAcquired, 
//            double purchasePrice, double askingPrice
        
    }
    
    // or edit it with set methods. 
    public String getGenre(){
        return genre;
    }
    
    public void setGenre(String genre){
        this.genre=genre;
    }
    
    
    public void remove(){
        bookCount--;
        itemCount--;
    }

    public String printableString(){
        String output = "Title: " + title +"\nAuthor: "+author+
                "\nDate Acquired(D/M/Y): " + dateAcquired.printableString() + "\nPurchase Price: " + 
                purchasePrice + "\nAsking Price: "+askingPrice+"\nGenre: "+genre;
        return output;
    }
//    title, author, dateAcquired, purchasePrice,askingPrice,genre    
    
}
