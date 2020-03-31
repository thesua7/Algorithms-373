package com.nsu.cse373.spring2020.ID1620129;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class SecondController extends Application{
	
	
	
	 @FXML
	 private Label SizeOfGtext;

	 @FXML
	 private Label SizeOfE;
	 
	 
	 @FXML
	 private Label path;

    @FXML
    void BackToHomebtn(ActionEvent event) {
 
    	Stage CurrentStage=(Stage) SizeOfE.getScene().getWindow();
    	CurrentStage.hide();
    	Main.mainStage.show();
    }
    
    
 


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub


		
	}
	
	
	@FXML
	public void initialize() throws IOException {
	
		SizeOfGtext.setText("  "+String.valueOf(FileCodes.MainFileSize)+" Bytes");
		SizeOfE.setText("  "+String.valueOf(FileCodes.EncodedFileSize)+" Bytes");
	
		
		FileCodes.toStoreDecodedFile(HuffmanC.decode(HomeController.EncodedTxt));
		

		path.setText(FileCodes.location);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	}






















