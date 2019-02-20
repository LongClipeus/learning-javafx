package application;

import config.Define;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.TextFile;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		String txt = new TextFile().readTextFile(Define.TEXT_FILE);
		try {			
			Parent root = FXMLLoader.load(getClass().getResource(Define.MY_SCENE));

			primaryStage.setTitle("ScrollPane Demo");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
