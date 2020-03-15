package com.nsu.cse373.spring2020.ID1620129;


import javafx.fxml.*;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class HomeController {

    @FXML
    private TextField nameText;

    @FXML
    private PasswordField pText;

    @FXML
    private Label toShow;

    @FXML
    public void login(ActionEvent event) {

    	if(nameText.getText().equals("sani")&&pText.getText().equals("123")) {
    		toShow.setText("LoggedIn");
    	}
    	
    	else {
    		toShow.setText("Invalid U&P");
    	}
    	
    }
	
}
