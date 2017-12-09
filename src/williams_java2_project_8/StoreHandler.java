/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package williams_java2_project_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// this handles an array list of StoreItems (paintings, movies, books). It allows you
// to iterate through the list and look at each member of the list as well as add
// and remove items from the store. It also handles serializing and deserializing
// files. 

public class StoreHandler{
    private ArrayList<StoreItem> arr;
    private int size;
    private int arr_index;
    public StoreHandler(){
        arr = new ArrayList<StoreItem>();
        size = arr.size();
        size=arr.size();
        arr_index=-1;
    }
    
    public void addBook(Book newBook){
        arr.add(newBook);
        if(arr_index==-1)arr_index++;
        size++;
    }
    
    public void addMovie(Movie newMovie){
        arr.add(newMovie);
        if(arr_index==-1)arr_index++;
        size++;
    }
    
    public void addPainting(Painting newPainting){
        arr.add(newPainting);
        if(arr_index==-1)arr_index++;
        size++;
    }
    
    public boolean next(){
        if(arr_index!=-1&&arr_index<size-1){
            arr_index++;
            return true;
        }
        else{
            System.out.println(" end of list");
            return false;
            //arr_index=0;
        }
        
    }
    
    public boolean previous(){
        if(arr_index!=-1&&arr_index>0){
            arr_index--;
            return true;
        }
        else{
            System.out.println(" start of list");
            return false;
        }
    }
    
    public StoreItem getCurrent(){
        StoreItem temp = new StoreItem("null","null",new Date(0,0,0),0,0);
        if(arr_index!=-1){
            return arr.get(arr_index);
        }else{
            return temp;
        }
    }
    
    public String printCurrent(){
        if(arr_index!=-1){
            return arr.get(arr_index).printableString();
        }else{
            return "null";
        }
    }
    
    public void readFile(String fileName){
        try{
            FileInputStream in = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(in);
            arr=(ArrayList<StoreItem>)(ois.readObject());
            size=arr.size();
            arr_index++;
        }catch(Exception e){
            System.out.println("Problem reading file. " + e);
        }
    }
    
    public void writeFile(String fileName){
        try{
            FileOutputStream out = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(arr);
            oos.close();
            out.close();
        }catch(Exception e){
            System.out.println("Problem writing file. "+e);
        }
    }
   
}
