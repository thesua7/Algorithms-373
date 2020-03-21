package com.nsu.cse373.spring2020.ID1620129;


import javafx.fxml.*;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


public class HomeController {



    @FXML
    private Label toShow;
    
   

  @FXML
   public void uploadbtn(ActionEvent event) {
	  
	  FileChooser fc = new FileChooser();
	  fc.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
	  File selectedFile = fc.showOpenDialog(null);
	  
	  if(selectedFile !=null) {
		  toShow.setText(selectedFile.getName());
	  }
	  else {
		  toShow.setText("Not Selected");
	  }
	  
	  
	  
  }
  
	
}
