/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package williams_java2_project_8;

// This is like books but for movies. 
// actors are saved on an array of strings. 


public class Movie extends StoreItem{
    static private int movieCount = 0;
    private String director;
    private String[] actors=new String[20];
    
    Movie(String title, String author, Date dateAcquired, double purchasePrice,
            double askingPrice, String director, String[]actors){
        super(title, author, dateAcquired,purchasePrice, askingPrice);
        setDirector(director);
        setActors(actors);
        movieCount++;
    }
    

    public void setDirector(String director){
        this.director=director;
    }
    public String getDirector(){
        return director;
    }
    public void setActors(String [] actors){
        
        //
        String actorString = "";
        for(int count = 0; count<actors.length;count++){
            actorString += actors[count]+" ";
        }
        System.out.println("\nDEBUG:"+actorString);
        //
        
        
        for(int count = 0; count<actors.length;count++){// trying manually get this to copy, damn it !!!
            this.actors[count] = actors[count];
        }
    }
    public String[] getActors(){
        return actors;
    }

    
    public void remove(){
        movieCount--;
        itemCount--;
    }
    
    public String printableString(){
        //
        int actCount =0;
 //       String testOut = "";
        String actorString = "";
        String actTempString = actors[actCount];
        while(actTempString!=null){
            actorString+=actTempString+", ";
            actTempString=actors[++actCount];
        }
        

        //

//        for(int count = 0; count<actors.length;count++){
//            actorString += actors[count]+" ";
//        }
//
//        for(int count = 0; count<actresses.length;count++){
//            actressString += actresses[count]+" ";
//        }
        
        String output = "Title: " + title +"\nAuthor: "+author+ "\nDirector: " + 
                director+"\nDate Acquired: " +"\nActors:"+actorString+
                "\nDate Acquired(D/M/Y): "+
                dateAcquired.printableString() + 
                "\nPurchase Price: " + purchasePrice + "\nAsking Price: "+
                askingPrice;
        return output;
    }    
}
