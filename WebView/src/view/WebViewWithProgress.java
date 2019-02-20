package view;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewWithProgress extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		TextField addressBar = new TextField();
		addressBar.setText("https://github.com/");
		Button goButton = new Button("Go!");
		Label stateLabel = new Label();

		stateLabel.setTextFill(Color.RED);
		ProgressBar progressBar = new ProgressBar();

		final WebView browser = new WebView();
		final WebEngine webEngine = browser.getEngine();

		// Worker làm nhiệm vụ tải trang web
		Worker<Void> worker = webEngine.getLoadWorker();

		// Lắng nghe các trạng thái tải trang web.
		worker.stateProperty().addListener(new ChangeListener<State>() {

			@Override
			public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
				stateLabel.setText("Loading state: " + newValue.toString());
				if (newValue == Worker.State.SUCCEEDED) {
					primaryStage.setTitle(webEngine.getLocation());
					stateLabel.setText("Finish!");
				}
			}
		});

		// Kết nối thuộc tính progress của progressBar
		// với thuộc tính progressBar của Worker tải nội dung trang.
		progressBar.progressProperty().bind(worker.progressProperty());

		goButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String url = addressBar.getText();
				// Tải nội dung trang
				webEngine.load(url);
			}
		});
		//

		VBox root = new VBox();
		root.getChildren().addAll(addressBar, goButton, stateLabel, progressBar, browser);

		Scene scene = new Scene(root);

		primaryStage.setTitle("JavaFX WebView (o7planning.org)");
		primaryStage.setScene(scene);
		primaryStage.setWidth(450);
		primaryStage.setHeight(300);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
