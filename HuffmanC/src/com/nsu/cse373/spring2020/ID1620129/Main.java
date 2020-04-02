package com.nsu.cse373.spring2020.ID1620129;
	
import java.io.File;
import java.util.BitSet;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	 public static Stage mainStage;
	 public static String EncodedTxt="";
	 
	 @FXML
	 private Label toShow;

	 @FXML
	 private Label SizeOfGtext;

	 @FXML
	 private Label SizeOfE;
	 
	 @FXML
	 private Label path;



	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			
			Scene mainScene = new Scene(root,600,480);
			mainScene.getStylesheets().add(getClass().getResource("css/application.css").toExternalForm());
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Huffman");
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
	    
	   

	  @FXML
	   public void uploadbtn(ActionEvent event) {
		  

		  FileChooser fc = new FileChooser();
		  fc.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
		  File selectedFile = fc.showOpenDialog(null);
		  String txt ="";

		  if(selectedFile !=null) {
			  
			  try {
		
				  
				  
		
	           txt = FileCodes.SelectedFile(selectedFile);
	    	   System.out.println("Main text: "+txt);
	           EncodedTxt=HuffmanC.Encoding(txt);//Getting the encoded string
	           System.out.println(HuffmanC.printCharMap(HuffmanC.MAINMAP)); 
	           System.out.println("Encoded TXT: "+ HuffmanC.Encoding(txt));
	           System.out.println("Decoded TXT: "+HuffmanC.Decoding(HuffmanC.root,EncodedTxt));
	           
	   
	           BitSet bS = HuffmanC.StringToBitSet(EncodedTxt);
	         
	          FileCodes.toStoreEncode(bS.toByteArray(),EncodedTxt);//Converting to byte[] array and saving to decoded.txt as "Byte[]"
	                                                    //For calculation the size in byte instead of character
	  	     
	          SizeOfGtext.setText("  "+String.valueOf(FileCodes.MainFileSize)+" Bytes");
			  SizeOfE.setText("  "+String.valueOf(FileCodes.EncodedFileSize)+" Bytes");
		
			
			  FileCodes.toStoreDecodedFile(HuffmanC.Decoding(HuffmanC.root,Main.EncodedTxt));//Decoding the encoded string 
			  toShow.setText("");                                                          //To generate real string and save that to file
			  path.setText(FileCodes.location);

			  
			  System.out.println("Selected File Size: "+FileCodes.MainFileSize);
			  System.out.println("Encoded File Size: "+FileCodes.EncodedFileSize);
			  
			  
			  
			  
			  
			  
			  }
			  
			  catch(Exception e){
				  
			  }
			  
			  
			  
			 // toShow.setText(selectedFile.getName());
		  }
		  else {
			  toShow.setText("Not Selected");
		  }
		  
	  }		  
		  
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	
	
	
	
	
}
