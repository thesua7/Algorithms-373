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
			  s.SelectedFile(selectedFile);//For reading the uploaded file
			  	  
			  
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
