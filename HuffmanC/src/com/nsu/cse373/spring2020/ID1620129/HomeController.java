package com.nsu.cse373.spring2020.ID1620129;


import javafx.fxml.*;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class HomeController {


	private static Huffman H = new Huffman();
	private static  int FreqArray[] = new int[1000];
	private static char tempChar[] = new char[1000];
	private static String text="";
	private static Node N;

    @FXML
    private Label toShow;
    
   

  @FXML
   public void uploadbtn(ActionEvent event) {
	  
	  SecondController s = new SecondController();//Declaring Second window class object
	  FileChooser fc = new FileChooser();
	  fc.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
	  File selectedFile = fc.showOpenDialog(null);
	  
	  if(selectedFile !=null) {
		  
		  try {
			  Main.mainStage.hide();
			  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondWindow.fxml"));
			  Parent root = (Parent) fxmlLoader.load();
			  Stage stage = new Stage();
			  stage.setScene(new Scene(root));  
			  stage.show();
			  

			  
			  
			  text = s.SelectedFile(selectedFile);//For reading the uploaded file
			  System.out.println(text);
			  H.charOccurances(text, tempChar, FreqArray);
			  
			  for(int o=0;o<1000;o++) {
				if(FreqArray[o]==0) {
		            	   break;
		               }
               System.out.println(FreqArray[o]);
          
		       }
			  
			  
			  System.out.println("-----------------------------------");
			  
			  
			  for(int o=0;o<1000;o++) {
					if(tempChar[o]==0) {
			            	   break;
			               }
	               System.out.println(tempChar[o]);
	          
			      
			  
			  }
			  
			  
			  N = H.priorityQueue(FreqArray, tempChar);
			  
			  System.out.println(N.character);
			  
			  
			  
			  
			  
			  
			  
			  
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
