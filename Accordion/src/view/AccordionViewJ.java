package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccordionViewJ extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Tạo TitledPane thứ nhất (Pane có tiêu đề)
		TitledPane firstTitledPane = new TitledPane();
		firstTitledPane.setText("Java");

		VBox content1 = new VBox();
		content1.getChildren().add(new Label("Java Swing Tutorial"));
		content1.getChildren().add(new Label("JavaFx Tutorial"));
		content1.getChildren().add(new Label("Java IO Tutorial"));

		firstTitledPane.setContent(content1);

		// Tạo TitledPane thứ hai (Pane có tiêu đề)
		TitledPane secondTitledPane = new TitledPane();
		secondTitledPane.setText("CShape");

		VBox content2 = new VBox();
		content2.getChildren().add(new Label("CShape Tutorial for Beginners"));
		content2.getChildren().add(new Label("CShape Enums Tutorial"));

		secondTitledPane.setContent(content2);

		Accordion root = new Accordion();
		root.getPanes().addAll(firstTitledPane, secondTitledPane);

		Scene scene = new Scene(root, 300, 200);
		primaryStage.setTitle("Accordion (o7planning.org)");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

//	public static void main(String[] args) {
//		Application.launch(args);
//	}

}
