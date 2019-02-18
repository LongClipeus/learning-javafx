package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class StackShow implements Initializable {

	@FXML
	private StackPane stackPane;

	@FXML
	private Button btnChangeTop;

	@FXML
	private TextField txtfXinChao;

	@FXML
	private TextField txtfHelloWorld;

	@FXML
	private TextField txtfSayHi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void ChangeTop() {
		System.out.println("Change top button clicked !");

		ObservableList<Node> childs = stackPane.getChildren();
		int childNumber = childs.size();

		if (childNumber > 1) {
			Node topNode = childs.get(childNumber - 1);
			if (topNode.getId().equals("btnChangeTop")) {
				System.out.println(topNode.getId() + " to back");
				topNode.toBack();
				topNode = childs.get(childNumber - 1);
			}
			topNode.toBack();
		}
	}

}
