/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package williams_java2_project_8;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author paleo
 */



public class DataBaseConnector {

    final String DATABASE_URL = "jdbc:derby:store";
    final String USER = "user";
    final String PASSWORD = "password";

    final String SELECT_QUERY="SELECT itemID, title FROM storeitem_t";//debug purposes
    
    private int size = 0;
    private int pos_index = 1;
    /**
     * @param args the command line arguments
     */
    public DataBaseConnector(){

        
        
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        // use try-with-resources to connect to and query the database
        connectTEST();
        System.out.println("size: "+size);
    }
    
    public void insertBook(Book book){
        String insertStoreItemQuery = 
                "INSERT INTO StoreItem_t (itemID, title, author, dateAquired, purchasePrice, askingPrice, type, sold) VALUES ("+
        (1+size) + ",'"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getDate().printableString()+"','"+
                book.getPurchasePrice()+"','"+book.getAskingPrice()+"','book','false')";
        
        System.out.println(insertStoreItemQuery);
        String insertBookQuery = "INSERT INTO Book_t (itemID, genre) VALUES ("+
                (1+size)+",'"+book.getGenre()+"')";
        System.out.println(insertBookQuery);
        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            ){
            statement.executeUpdate(insertStoreItemQuery);
            statement.executeUpdate(insertBookQuery);
            size++;
        }
               
        catch(SQLException sqlException){
                sqlException.printStackTrace();
        }
        
    }
    
    public void insertMovie(Movie movie){
        String insertStoreItemQuery = 
                "INSERT INTO StoreItem_t (itemID, title, author, dateAquired, purchasePrice, askingPrice, type, sold) VALUES ("+
        (size+1) + ",'"+movie.getTitle()+"','"+movie.getAuthor()+"','"+movie.getDate().printableString()+"','"+
                movie.getPurchasePrice()+"','"+movie.getAskingPrice()+"','movie','false')";
        System.out.println(insertStoreItemQuery);
        
        String insertMovieQuery = "INSERT INTO Movie_t (itemID, director) VALUES ("+
                (1+size)+",'"+movie.getDirector()+"')";
        System.out.println(insertMovieQuery);
        
        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            ){
            statement.executeUpdate(insertStoreItemQuery);
            statement.executeUpdate(insertMovieQuery);

            String[]actors=movie.getActors();
            int actCount =0;
 //       String testOut = "";
            String actTempString = actors[actCount];
            while(actTempString!=null){
                String insertActorQuery = "INSERT INTO Actor_t (itemID, actor) VALUES ("+
                (1+size)+",'"+actTempString+"')";
                System.out.println(insertActorQuery);
                statement.executeUpdate(insertActorQuery);
                actTempString=actors[++actCount];
            }

            
            size++;
        }
               
        catch(SQLException sqlException){
                sqlException.printStackTrace();
        }
        
    }
    
//    public void insertActors(Movie movie){
//        String[]actors=movie.getActors();
//        int actCount =0;
// //       String testOut = "";
//        String actTempString = actors[actCount];
//        while(actTempString!=null){
//            String insertActorQuery = "INSERT INTO Actor_t (itemID, actor) VALUES ("+
//                (1+size)+",'"+actTempString+"')";
//            statement.executeUpdate(insertActorQuery);
//            actTempString=actors[++actCount];
//        }
//    }
    
    public void insertPainting(Painting painting){
        String insertStoreItemQuery = 
                "INSERT INTO StoreItem_t (itemID, title, author, dateAquired, purchasePrice, askingPrice, type, sold) VALUES ("+
        (1+size) + ",'"+painting.getTitle()+"','"+painting.getAuthor()+"','"+painting.getDate().printableString()+"','"+
                painting.getPurchasePrice()+"','"+painting.getAskingPrice()+"','painting','false')";
        System.out.println(insertStoreItemQuery);
        String insertPaintingQuery = "INSERT INTO Painting_t (itemID, height, width, media) VALUES ("+
                (1+size)+",'"+painting.getHeight()+"','"+painting.getWidth()+"','"+painting.getMedia()+"')";
        System.out.println(insertPaintingQuery);
        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            ){
            System.out.println("Trying to execute Query");
            statement.executeUpdate(insertStoreItemQuery);
            statement.executeUpdate(insertPaintingQuery);
            size++;
        }
               
        catch(SQLException sqlException){
                sqlException.printStackTrace();
        }
    }
    
    public void update(String select_query){
        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            ){
            statement.executeUpdate(select_query);
            
        }
               
        catch(SQLException sqlException){
                sqlException.printStackTrace();
                }
    }
    
    public void connectTEST(){
        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(SELECT_QUERY)){
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.printf("Store Database:%n%n");
            for (int i = 1; i <=numberOfColumns;i++){
                System.out.printf("%-8s\t",metaData.getColumnName(i));
            }
            System.out.println();
            while(resultSet.next()){
                size++;
                for(int i = 1; i <=numberOfColumns;i++){
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println();
            }
        }
               
        catch(SQLException sqlException){
                sqlException.printStackTrace();
        }
    }
    //pos_index
    //itemID, title, author, dateAquired, purchasePrice, askingPrice
    String[] storeItemLabels = {"itemID","title","author","dateAquired","purchasePrice","askingPrice","type","sold"};
    public String readNext(){
        String output = "";
        
        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT itemID, title, author, dateAquired, purchasePrice, askingPrice, type, sold from storeitem_t WHERE itemID = "+ pos_index)){
                       
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            {if(!resultSet.next())return "";

                for(int i = 1; i <=numberOfColumns;i++){
                    System.out.printf("%-16s\t", resultSet.getObject(i));
                    output += storeItemLabels[i-1]+": "+resultSet.getObject(i)+"\n";
                    //System.out.println("COUNT: "+i);
                }
                System.out.println();
                String checkType = ""+resultSet.getObject(7);
                System.out.println("checkType: "+checkType);
                if(checkType.equals("book")){
                    System.out.println("ITSABOOK");
                    ResultSet resultSetBook=statement.executeQuery("SELECT genre FROM book_t WHERE itemID = "+pos_index);
                    if(resultSetBook.next()){
                        output+="genre: " + resultSetBook.getObject(1)+"\n";
                    }else{
                        output+="genre: \n";
                    }
                }else if(checkType.equals("movie")){
                    ResultSet resultSetMovie=statement.executeQuery("SELECT director FROM movie_t WHERE itemID = "+pos_index);
                    if(resultSetMovie.next()){
                        output+="director: " + resultSetMovie.getObject(1)+"\n";
                        {
                            ResultSet resultSetActor=statement.executeQuery("SELECT actor FROM actor_t WHERE itemID = "+pos_index);
                            ResultSetMetaData metaDataActor = resultSetActor.getMetaData();
                            int colNum = metaDataActor.getColumnCount();
                            output+="actors: ";
                            while(resultSetActor.next()){
                                output+=resultSetActor.getObject(1)+", ";
                            }
                            
                            
                            
                            
                        }
                    }else{
                        output+="director: \n";
                    }
                }else if(checkType.equals("painting")){
                    ResultSet resultSetPainting=statement.executeQuery("SELECT height, width, media FROM painting_t WHERE itemID = "+pos_index);
                    if(resultSetPainting.next()){
                        output+="height: " + resultSetPainting.getObject(1)+"\n";
                        output+="width: " + resultSetPainting.getObject(2)+"\n";
                        output+="media: " + resultSetPainting.getObject(3)+"\n";                        
                    }else{
                        output+="genre: \n";
                    }
                }
                
                
                
            }
            
            if(pos_index<size){
                pos_index++;
            
            }
           // pos_index++;
        }
               
        catch(SQLException sqlException){
                sqlException.printStackTrace();
        }
        return output;
    }
    
    public String readPrevious(){
        String output = "";
        if(pos_index>0){
            pos_index--;
            if(pos_index<1)pos_index=1;
        }
        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT itemID, title, author, dateAquired, purchasePrice, askingPrice, type, sold from storeitem_t WHERE itemID = "+ pos_index)){
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            {if(!resultSet.next())return "";

                for(int i = 1; i <=numberOfColumns;i++){
                    System.out.printf("%-16s\t", resultSet.getObject(i));
                    output += storeItemLabels[i-1]+": "+resultSet.getObject(i)+"\n";
                    //System.out.println("COUNT: "+i);
                }
                System.out.println();
                String checkType = ""+resultSet.getObject(7);
                System.out.println("checkType: "+checkType);
                if(checkType.equals("book")){
                    System.out.println("ITSABOOK");
                    ResultSet resultSetBook=statement.executeQuery("SELECT genre FROM book_t WHERE itemID = "+pos_index);
                    if(resultSetBook.next()){
                        output+="genre: " + resultSetBook.getObject(1)+"\n";
                    }else{
                        output+="genre: \n";
                    }
                }else if(checkType.equals("movie")){
                    ResultSet resultSetMovie=statement.executeQuery("SELECT director FROM movie_t WHERE itemID = "+pos_index);
                    if(resultSetMovie.next()){
                        output+="director: " + resultSetMovie.getObject(1)+"\n";
                        {
                            ResultSet resultSetActor=statement.executeQuery("SELECT actor FROM actor_t WHERE itemID = "+pos_index);
                            ResultSetMetaData metaDataActor = resultSetActor.getMetaData();
                            int colNum = metaDataActor.getColumnCount();
                            output+="actors: ";
                            while(resultSetActor.next()){
                                output+=resultSetActor.getObject(1)+", ";
                            }
                            
                            
                            
                            
                        }
                    }else{
                        output+="director: \n";
                    }
                }else if(checkType.equals("painting")){
                    ResultSet resultSetPainting=statement.executeQuery("SELECT height, width, media FROM painting_t WHERE itemID = "+pos_index);
                    if(resultSetPainting.next()){
                        output+="height: " + resultSetPainting.getObject(1)+"\n";
                        output+="width: " + resultSetPainting.getObject(2)+"\n";
                        output+="media: " + resultSetPainting.getObject(3)+"\n";                        
                    }else{
                        output+="genre: \n";
                    }
                }
                
                
                
            }
            
        }
               
        catch(SQLException sqlException){
                sqlException.printStackTrace();
        }
        return output;
    }
    
    public void sellCurrent(){
        String output = "";
        
        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT itemID, title, author, dateAquired, purchasePrice, askingPrice, type, sold from storeitem_t WHERE itemID = "+ pos_index)){
            if(pos_index<size){
                pos_index++;
            
            }
            
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            {if(!resultSet.next())return;
                size++;
                for(int i = 1; i <=numberOfColumns;i++){
                    System.out.printf("%-16s\t", resultSet.getObject(i));
                    output += storeItemLabels[i-1]+": "+resultSet.getObject(i)+"\n";
                    //System.out.println("COUNT: "+i);
                }
                System.out.println();
                String checkType = ""+resultSet.getObject(7);
                System.out.println("checkType: "+checkType);
                if(checkType.equals("book")){
                    System.out.println("ITSABOOK");
                    ResultSet resultSetBook=statement.executeQuery("SELECT genre FROM book_t WHERE itemID = "+pos_index);
                    if(resultSetBook.next()){
                        output+="genre: " + resultSetBook.getObject(1)+"\n";
                    }else{
                        output+="genre: \n";
                    }
                }else if(checkType.equals("movie")){
                    ResultSet resultSetMovie=statement.executeQuery("SELECT director FROM movie_t WHERE itemID = "+pos_index);
                    if(resultSetMovie.next()){
                        output+="director: " + resultSetMovie.getObject(1)+"\n";
                        {
                            ResultSet resultSetActor=statement.executeQuery("SELECT actor FROM actor_t WHERE itemID = "+pos_index);
                            ResultSetMetaData metaDataActor = resultSetActor.getMetaData();
                            int colNum = metaDataActor.getColumnCount();
                            output+="actors: ";
                            while(resultSetActor.next()){
                                output+=resultSetActor.getObject(1)+", ";
                            }
                            
                            
                            
                            
                        }
                    }else{
                        output+="director: \n";
                    }
                }else if(checkType.equals("painting")){
                    ResultSet resultSetPainting=statement.executeQuery("SELECT height, width, media FROM painting_t WHERE itemID = "+pos_index);
                    if(resultSetPainting.next()){
                        output+="height: " + resultSetPainting.getObject(1)+"\n";
                        output+="width: " + resultSetPainting.getObject(2)+"\n";
                        output+="media: " + resultSetPainting.getObject(3)+"\n";                        
                    }else{
                        output+="genre: \n";
                    }
                }
                
                
                
            }
            
           // pos_index++;
        }
               
        catch(SQLException sqlException){
                sqlException.printStackTrace();
        }
        return;
    }
        
    
}