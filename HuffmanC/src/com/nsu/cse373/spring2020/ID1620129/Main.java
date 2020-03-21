package com.nsu.cse373.spring2020.ID1620129;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	 public static Stage mainStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene mainScene = new Scene(root,400,400);
			mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Huffman");
		
			primaryStage.show();
			mainStage = primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
