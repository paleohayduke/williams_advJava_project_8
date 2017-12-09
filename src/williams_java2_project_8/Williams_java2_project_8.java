/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package williams_java2_project_8;

import javax.swing.JFrame;

/**
 *
 * @author paleo
 */
public class Williams_java2_project_8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StoreHandler test = new StoreHandler();
 //       (String title, String author, Date dateAcquired, double purchasePrice,
   //         double askingPrice, String genre)
        //Book book1 = new Book("Title");
//        DataBaseConnector db = new DataBaseConnector();
        MyGUI gui = new MyGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1600,900);
        gui.setVisible(true);

    
    }
    
}
