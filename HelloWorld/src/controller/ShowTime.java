package controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.TimerSystem;

public class ShowTime implements Initializable {
	
	@FXML
	private Button btnShowDateTime;
	
	@FXML
	private TextField txtfDateTime;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void ShowDateTime() {
		System.out.println("Button Show Date Time Clicked !");
				
		String dateTime = new TimerSystem().getDateTime();
		
		txtfDateTime.setText(dateTime);
	}

}
