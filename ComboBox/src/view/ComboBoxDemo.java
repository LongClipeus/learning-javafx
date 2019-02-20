package view;

import entity.Planet;
import entity.PlanetDAO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
         
 
        ComboBox<String> comboBox = new ComboBox<String>();
 
        ObservableList<String> list = PlanetDAO.getPlanetList();
 
        comboBox.setItems(list);
        comboBox.getSelectionModel().select(1);
 
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(5));
        root.setHgap(5);
         
        root.getChildren().add(new Label("Select Planet:"));
        root.getChildren().add(comboBox);
 
        primaryStage.setTitle("ComboxBox (o7planning.org)");
        Scene scene = new Scene(root, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }

}
