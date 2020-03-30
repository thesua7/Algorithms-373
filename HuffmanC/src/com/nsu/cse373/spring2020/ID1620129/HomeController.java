package com.nsu.cse373.spring2020.ID1620129;


import javafx.fxml.*;

import java.io.File;
import java.util.PriorityQueue;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class HomeController {

	private final static int R = 256;
	static String[] mArray = new String[R];

    @FXML
    private Label toShow;
    
   

  @FXML
   public void uploadbtn(ActionEvent event) {
	  

	  FileChooser fc = new FileChooser();
	  fc.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
	  File selectedFile = fc.showOpenDialog(null);
	  String txt ="";
	  String DecodedTxt="";
	 

	  
	  if(selectedFile !=null) {
		  
		  try {
	
			  
			  
			  
             txt = FileCodes.SelectedFile(selectedFile);
             
             System.out.println(txt);
             
             HuffmanC.Genarate(txt);
 
            //Printing for testing "char: Prefix"
     
         	for(int i = 0; i < mArray.length; i++){
         
    			if(!(mArray[i] == null)){
    				System.out.println((char)(i) + ": " + mArray[i]);
    			}
   
    		}
         	
         	
         	System.out.println("OKOK");
         	
         	
         	for(int j = 0; j < mArray.length; j++){
    			if(!(mArray[j] == null)){
    				DecodedTxt = DecodedTxt+ mArray[j]+" ";
    				
    			}
    		}
         	
         	
         	System.out.println("Decoded " + DecodedTxt);
         	FileCodes.toStoreDecode(DecodedTxt);
         	
         	
  		  Main.mainStage.hide();
		  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondWindow.fxml"));
		  Parent root = (Parent) fxmlLoader.load();
		  Stage stage = new Stage();
		  stage.setScene(new Scene(root));  
		  stage.show();
		  toShow.setText("");
		  stage.setResizable(false);
		  
			  
		  }
		  
		  catch(Exception e){
			  
		  }
		  
		  
		  
		 // toShow.setText(selectedFile.getName());
	  }
	  else {
		  toShow.setText("Not Selected");
	  }
	  
	  
	  
  }
  

	
}
