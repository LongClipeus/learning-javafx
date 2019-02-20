package view;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Button buttonURL = new Button("Load Page eclipse.org");
		Button buttonHtmlString = new Button("Load HTML String");
		Button buttonHtmlFile = new Button("Load HTML File");

		final WebView browser = new WebView();
		final WebEngine webEngine = browser.getEngine();

		buttonURL.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String url = "https://www.eclipse.org/";

				// Tải một trang HTML từ url.
				webEngine.load(url);
			}
		});

		buttonHtmlString.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String html = "<html><h1>Hello</h1><h2>Hello</h2></html>";

				// Tải HTML String
				webEngine.loadContent(html);
			}
		});
		buttonHtmlFile.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					File file = new File("src/web_test/Hello.html");
					URL url = file.toURI().toURL();
					webEngine.load(url.toString());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}

			}
		});

		VBox root = new VBox();
		root.setPadding(new Insets(5));
		root.setSpacing(5);
		root.getChildren().addAll(buttonURL, buttonHtmlString, buttonHtmlFile, browser);

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
