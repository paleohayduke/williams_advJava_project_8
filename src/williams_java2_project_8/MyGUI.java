/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package williams_java2_project_8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// This class is the results of me making a handmade GUI. Maybe I could have 
// seperated it into more classes.

//(String title, String author, Date dateAcquired, double purchasePrice, double askingPrice, String genre)
public class MyGUI extends JFrame{
    DataBaseConnector db = new DataBaseConnector();
    
    JFileChooser fc = new JFileChooser();
    
    StoreHandler store;
    ArrayList<String> actors;
    
    private final GridLayout layout;
    
    private final JPanel bookPanel = new JPanel();
    private final JPanel moviePanel = new JPanel();
    private final JPanel paintingPanel = new JPanel();
    private final JPanel outputPanel = new JPanel();
    
    
    private final JButton open = new JButton ("open file");
    private final JButton save = new JButton ("save file");
    
    private final JButton next = new JButton("next");
    private final JButton previous = new JButton("prev");
    private final JButton saveBook = new JButton("save book");
    private final JButton saveMovie = new JButton("save movie");
    private final JButton savePainting = new JButton("save painting");
    private final JButton saveActor = new JButton("add actor");
    

    private final JLabel bookHeading = new JLabel("BOOK:");
    private final JLabel movieHeading = new JLabel("MOVIE:");
    private final JLabel paintingHeading = new JLabel("PAINTING:");
    
    
    private final JTextArea outputLabel = new JTextArea("Output");
    
    private final JLabel titleLabel = new JLabel("Title");
    private final JLabel authorLabel = new JLabel("Author");
    private final JLabel dateLabel1 = new JLabel("Date Purchased D");
    private final JLabel dateLabel2 = new JLabel("M");
    private final JLabel dateLabel3 = new JLabel("Y");
    private final JLabel purchasePriceLabel = new JLabel("Purchase Price");
    private final JLabel askingPriceLabel = new JLabel("Asking Price");
    
    private final JLabel titleLabel2 = new JLabel("Title");
    private final JLabel authorLabel2 = new JLabel("Author");
    private final JLabel dateLabel21 = new JLabel("Date Purchased D");
    private final JLabel dateLabel22 = new JLabel("M");
    private final JLabel dateLabel23 = new JLabel("Y");
    private final JLabel purchasePriceLabel2 = new JLabel("Purchase Price");
    private final JLabel askingPriceLabel2 = new JLabel("Asking Price");
    
    private final JLabel titleLabel3 = new JLabel("Title");
    private final JLabel authorLabel3 = new JLabel("Author");
    private final JLabel dateLabel31 = new JLabel("Date Purchased D");
    private final JLabel dateLabel32 = new JLabel("M");
    private final JLabel dateLabel33 = new JLabel("Y");
    private final JLabel purchasePriceLabel3 = new JLabel("Purchase Price");
    private final JLabel askingPriceLabel3 = new JLabel("Asking Price");
    
    
    
    private final JLabel genreLabel = new JLabel("Genre");
    private final JLabel directorLabel = new JLabel("Director");
    private final JLabel actorLabel = new JLabel("Actor");
    private final JLabel heightLabel = new JLabel("Height");
    private final JLabel widthLabel = new JLabel("Width");
    private final JLabel mediaLabel = new JLabel("Media");
    
    private final JTextField bookTitle;
    private final JTextField bookAuthor;
    private final JTextField bookDate1;
    private final JTextField bookDate2;
    private final JTextField bookDate3;
    private final JTextField bookPurchasePrice;
    private final JTextField bookAskingPrice;
    private final JTextField bookGenre;
    
//String title, String author, Date dateAcquired, double purchasePrice, double askingPrice, String director, String[]actors, String[]actresses
    private final JTextField movieTitle;
    private final JTextField movieAuthor;
    private final JTextField movieDate1;
    private final JTextField movieDate2;
    private final JTextField movieDate3;
    private final JTextField moviePurchasePrice;
    private final JTextField movieAskingPrice;
    private final JTextField movieDirector;
    private final JTextField movieActor;

//(String title, String author,  Date dateAcquired, double purchasePrice, double askingPrice, int height, int width, String media)
    private final JTextField paintingTitle;
    private final JTextField paintingAuthor;
    private final JTextField paintingDate1;
    private final JTextField paintingDate2;
    private final JTextField paintingDate3;    
    private final JTextField paintingPurchasePrice;
    private final JTextField paintingAskingPrice;
    private final JTextField paintingHeight;
    private final JTextField paintingWidth;
    private final JTextField paintingMedia;
    
    public MyGUI(){
        super("STORE");
        
        
        store = new StoreHandler();
        actors = new ArrayList<String>();
        
        layout = new GridLayout(4,4,5,5);
        setLayout(layout);
        
        bookTitle = new JTextField(10);
        bookAuthor = new JTextField(10);
        bookDate1 = new JTextField(2);
        bookDate2 = new JTextField(2);
        bookDate3 = new JTextField(2);
        
        bookPurchasePrice = new JTextField(10);;
        bookAskingPrice = new JTextField(10);;
        bookGenre = new JTextField(10);;
        
        bookPanel.add(bookHeading);
        bookPanel.add(titleLabel);
        bookPanel.add(bookTitle);
        bookPanel.add(authorLabel);
        bookPanel.add(bookAuthor);
        bookPanel.add(dateLabel1);
        bookPanel.add(bookDate1);
        bookPanel.add(dateLabel2);
        bookPanel.add(bookDate2);
        bookPanel.add(dateLabel3);
        bookPanel.add(bookDate3);        
        bookPanel.add(purchasePriceLabel);
        bookPanel.add(bookPurchasePrice);
        bookPanel.add(askingPriceLabel);
        bookPanel.add(bookAskingPrice);
        bookPanel.add(genreLabel);
        bookPanel.add(bookGenre);
        bookPanel.add(saveBook);
        
        
//String title, String author, Date dateAcquired, double purchasePrice, double askingPrice, String director, String[]actors, String[]actresses
        movieTitle = new JTextField(10);;
        movieAuthor = new JTextField(10);;
        movieDate1 = new JTextField(2);
        movieDate2 = new JTextField(2);
        movieDate3 = new JTextField(2);
        
        moviePurchasePrice = new JTextField(10);;
        movieAskingPrice = new JTextField(10);;
        movieDirector = new JTextField(10);;
        movieActor = new JTextField(10);;
        
        moviePanel.add(movieHeading);
        moviePanel.add(titleLabel2);
        moviePanel.add(movieTitle);
        moviePanel.add(authorLabel2);
        moviePanel.add(movieAuthor);
        moviePanel.add(dateLabel21);
        moviePanel.add(movieDate1);
        moviePanel.add(dateLabel22);
        moviePanel.add(movieDate2);
        moviePanel.add(dateLabel23);
        moviePanel.add(movieDate3);
        moviePanel.add(purchasePriceLabel2);
        moviePanel.add(moviePurchasePrice);
        moviePanel.add(askingPriceLabel2);
        moviePanel.add(movieAskingPrice);
        moviePanel.add(directorLabel);
        moviePanel.add(movieDirector);
        moviePanel.add(actorLabel);
        moviePanel.add(movieActor);
        moviePanel.add(saveActor);
        moviePanel.add(saveMovie);
//(String title, String author,  Date dateAcquired, double purchasePrice, double askingPrice, int height, int width, String media)
        paintingTitle = new JTextField(10);
        paintingAuthor = new JTextField(10);
        paintingDate1 = new JTextField(2);
        paintingDate2 = new JTextField(2);
        paintingDate3 = new JTextField(2);
        
        paintingPurchasePrice = new JTextField(10);
        paintingAskingPrice = new JTextField(10);
        paintingHeight = new JTextField(10);
        paintingWidth = new JTextField(10);
        paintingMedia = new JTextField(10);
        
        paintingPanel.add(paintingHeading);
        paintingPanel.add(titleLabel3);
        paintingPanel.add(paintingTitle);
        paintingPanel.add(authorLabel3);
        paintingPanel.add(paintingAuthor);
        paintingPanel.add(dateLabel31);
        paintingPanel.add(paintingDate1);
        paintingPanel.add(dateLabel32);
        paintingPanel.add(paintingDate2);
        paintingPanel.add(dateLabel33);
        paintingPanel.add(paintingDate3);
        
        paintingPanel.add(purchasePriceLabel3);
        paintingPanel.add(paintingPurchasePrice);
        paintingPanel.add(askingPriceLabel3);
        paintingPanel.add(paintingAskingPrice);
        paintingPanel.add(heightLabel);
        paintingPanel.add(paintingHeight);
        paintingPanel.add(widthLabel);
        paintingPanel.add(paintingWidth);
        paintingPanel.add(mediaLabel);
        paintingPanel.add(paintingMedia);
        paintingPanel.add(savePainting);
        
        BorderLayout outputLayout = new BorderLayout();
        outputPanel.setLayout(outputLayout);
        outputPanel.add(previous,BorderLayout.WEST);
        outputPanel.add(next,BorderLayout.EAST);
        outputPanel.add(outputLabel,BorderLayout.CENTER);
        outputPanel.add(open,BorderLayout.NORTH);
        outputPanel.add(save,BorderLayout.SOUTH);
        
        add(bookPanel,BorderLayout.NORTH);
        add(moviePanel,BorderLayout.CENTER);
        add(paintingPanel,BorderLayout.SOUTH);
        add(outputPanel,BorderLayout.EAST);
        
        ButtonHandler handler = new ButtonHandler();
        next.addActionListener(handler);
        previous.addActionListener(handler);
        saveBook.addActionListener(handler);
        saveMovie.addActionListener(handler);
        savePainting.addActionListener(handler);
        saveActor.addActionListener(handler);       
        open.addActionListener(handler); 
        save.addActionListener(handler); 
        
    }

    private Book makeBook(){
        String tempTitle=" ";
        String tempAuthor=" ";
        Date tempDate= new Date(0,0,0);
        double tempPurchasePrice = 0;
        double tempAskingPrice = 0;
        String tempGenre = " ";
        
        if(bookTitle.getText()!=null){
            tempTitle=bookTitle.getText();
        }
        if(bookAuthor.getText()!=null){
            tempAuthor=bookAuthor.getText();
        }
        //if(bookDate1.getText()!=null&&bookDate2.getText()!=null
        //        &&bookDate3.getText()!=null){
        if(isInteger(bookDate1.getText())&&isInteger(bookDate2.getText())&&isInteger(bookDate3.getText())){
            tempDate = new Date(Integer.parseInt(bookDate1.getText())
                ,Integer.parseInt(bookDate2.getText()),Integer.parseInt(bookDate3.getText()));
        }
        if(isDouble(bookPurchasePrice.getText())){
            System.out.println("UHOH");
            tempPurchasePrice=Double.parseDouble(bookPurchasePrice.getText());
        }
        if(isDouble(bookAskingPrice.getText())){
            tempAskingPrice=Double.parseDouble(bookAskingPrice.getText());
        }
        if(bookGenre.getText()!=null){
            tempGenre=bookGenre.getText();
        }
        
        
        Book tempBook = new Book(tempTitle,tempAuthor,tempDate,
                tempPurchasePrice,tempAskingPrice,tempGenre);
        
        bookTitle.setText("");
        bookAuthor.setText("");
        bookDate1.setText("");
        bookDate2.setText("");
        bookDate3.setText("");
        bookPurchasePrice.setText("");
        bookAskingPrice.setText("");
        bookGenre.setText("");
        
        return tempBook;
    }
    
    private Movie makeMovie(){
        String tempTitle=" ";
        String tempAuthor=" ";
        Date tempDate= new Date(0,0,0);
        double tempPurchasePrice = 0;
        double tempAskingPrice = 0;
        String tempDirector = " ";
        String[] tempActors = new String[actors.size()];

        if(movieTitle.getText()!=null){
            tempTitle=movieTitle.getText();
        }
        if(movieAuthor.getText()!=null){
            tempAuthor=movieAuthor.getText();
        }
        //if(bookDate1.getText()!=null&&bookDate2.getText()!=null
        //        &&bookDate3.getText()!=null){
        if(isInteger(movieDate1.getText())&&isInteger(movieDate2.getText())&&isInteger(movieDate3.getText())){
            tempDate = new Date(Integer.parseInt(movieDate1.getText())
                ,Integer.parseInt(movieDate2.getText()),Integer.parseInt(movieDate3.getText()));
        }
        if(isDouble(moviePurchasePrice.getText())){
            System.out.println("UHOH");
            tempPurchasePrice=Double.parseDouble(moviePurchasePrice.getText());
        }
        if(isDouble(movieAskingPrice.getText())){
            tempAskingPrice=Double.parseDouble(movieAskingPrice.getText());
        }
        if(movieDirector.getText()!=null){
            tempDirector=movieDirector.getText();
        }
        if(movieActor.getText()!=null){
            
            for(int count =0;count<actors.size();count++){
                tempActors[count]=actors.get(count);
            }
            
            
            actors = new ArrayList<String>();
        }
        
        Movie tempMovie = new Movie(tempTitle,tempAuthor,tempDate,
                tempPurchasePrice,tempAskingPrice,tempDirector, tempActors);
        
        
        movieTitle.setText("");
        movieAuthor.setText("");
        movieDate1.setText("");
        movieDate2.setText("");
        movieDate3.setText("");
        moviePurchasePrice.setText("");
        movieAskingPrice.setText("");
        movieDirector.setText("");
        movieActor.setText("");
        return tempMovie;
        
    }
    
    private Painting makePainting(){
        String tempTitle=" ";
        String tempAuthor=" ";
        Date tempDate= new Date(0,0,0);
        double tempPurchasePrice = 0;
        double tempAskingPrice = 0;
        int tempHeight = 0;
        int tempWidth = 0;
        String tempMedia = " ";
        
        if(paintingTitle.getText()!=null){
            tempTitle=paintingTitle.getText();
        }
        if(paintingAuthor.getText()!=null){
            tempAuthor=paintingAuthor.getText();
        }
        //if(bookDate1.getText()!=null&&bookDate2.getText()!=null
        //        &&bookDate3.getText()!=null){
        if(isInteger(paintingDate1.getText())&&isInteger(paintingDate2.getText())&&isInteger(paintingDate3.getText())){
            tempDate = new Date(Integer.parseInt(paintingDate1.getText())
                ,Integer.parseInt(paintingDate2.getText()),Integer.parseInt(paintingDate3.getText()));
        }
        if(isDouble(paintingPurchasePrice.getText())){
            System.out.println("UHOH");
            tempPurchasePrice=Double.parseDouble(paintingPurchasePrice.getText());
        }
        if(isDouble(paintingAskingPrice.getText())){
            tempAskingPrice=Double.parseDouble(paintingAskingPrice.getText());
        }
        if(isInteger(paintingHeight.getText())){
            tempHeight=Integer.parseInt(paintingHeight.getText());
        }
        if(isInteger(paintingWidth.getText())){
            tempWidth=Integer.parseInt(paintingWidth.getText());
        }
        if(paintingMedia.getText()!=null){
            tempMedia=paintingMedia.getText();
        }
        
        
        Painting tempPainting = new Painting(tempTitle,tempAuthor,tempDate,
                tempPurchasePrice,tempAskingPrice,tempHeight,tempWidth,tempMedia);
        
        paintingTitle.setText("");
        paintingAuthor.setText("");
        paintingDate1.setText("");
        paintingDate2.setText("");
        paintingDate3.setText("");
        paintingPurchasePrice.setText("");
        paintingAskingPrice.setText("");
        paintingHeight.setText("");
        paintingWidth.setText("");
        paintingMedia.setText("");
        
        return tempPainting;
    }
    
    private class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            if (event.getSource()==next){
                outputLabel.setText(db.readNext());
                    //System.out.println("DEBUG99: " + db.readNext());
//                if(store.next()){
//                    //outputLabel.setText(store.printCurrent());
//                    outputLabel.setText(db.readNext());
//                    System.out.println("DEBUG99: " + db.readNext());
//                }else{
//                    outputLabel.setText(store.printCurrent()+"\n*End of list");
//                }
            }else if (event.getSource()==previous){
                outputLabel.setText(db.readPrevious());
//                if(store.previous()){
//                    outputLabel.setText(store.printCurrent());
//                }else{
//                    outputLabel.setText(store.printCurrent()+"\n*Start of list");
//                }
            }else if (event.getSource()==saveBook){
                Book newBook = makeBook();
                store.addBook(newBook);
                
                db.insertBook(newBook);
                
                
                System.out.println("SAVING BOOK");
                
//                store.next();
                
                System.out.println(store.getCurrent().printableString());
                
            }else if (event.getSource()==saveMovie){
                Movie newMovie = makeMovie();
                store.addMovie(newMovie);
                db.insertMovie(newMovie);
                
                System.out.println("SAVING MOVIE");
                
            }else if (event.getSource()==savePainting){
                Painting newPainting = makePainting();
                store.addPainting(newPainting);
                db.insertPainting(newPainting);
                System.out.println("SAVING PAINTING");
            }else if (event.getSource()==saveActor){
                
                System.out.println("SAVING ACTOR");
                if(movieActor.getText()!=null){
                    actors.add(movieActor.getText());
                    
                }
            }else if(event.getSource()==open){
                File tempFile;

                fc.setCurrentDirectory(new java.io.File("."));
                fc.setDialogTitle("Open File");
                int result = fc.showOpenDialog(open);
                if(result == JFileChooser.APPROVE_OPTION){
                    tempFile=fc.getSelectedFile();
                
                try{                    
                    store.readFile(tempFile.getAbsolutePath());    
                }catch(Exception e){
                    System.out.println("Error " + e);
                }
                }
                
                
            }else if(event.getSource()==save){
                
                fc.setCurrentDirectory(new java.io.File("."));
                fc.setDialogTitle("Save File");
                int result = fc.showSaveDialog(save);
                if(result == JFileChooser.APPROVE_OPTION){
                    File file = fc.getSelectedFile();
//                    System.out.println(file.getAbsolutePath());
                    try{
                        
                        store.writeFile(file.getAbsolutePath());
                    }catch(Exception e){
                        System.out.println("Error " + e);
                    }
                }


                
            }
        }
    }
    
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
    return true;
    }

    public static boolean isDouble(String s) {
        try { 
            Double.parseDouble(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
    return true;
    }
}
