package com.nsu.cse373.spring2020.ID1620129;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	 public static Stage mainStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			
			Scene mainScene = new Scene(root,520,400);
			mainScene.getStylesheets().add(getClass().getResource("css/application.css").toExternalForm());
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Huffman");
			primaryStage.setResizable(false);
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
