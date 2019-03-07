package application;

import java.net.URL;

import config.Define;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class BasicAudioClip extends Application {

	public static final String AUDIO_FILE = Define.AUDIO + "audio-test.wav";

	private final URL resource;
	private final URL stylesheet;
	private final Button button;
	private AudioClip audioClip;

	public BasicAudioClip() throws Throwable {
		button = new Button("Bing Zzzzt!");
		resource = BasicAudioClip.class.getResource(AUDIO_FILE);
		stylesheet = BasicAudioClip.class.getResource("Style.css");
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		if (resource != null) {
			audioClip = new AudioClip(resource.toString());

			button.setOnAction((ActionEvent event) -> {
				audioClip.play(1.0);
			});
		} else {
			System.out.println("Can't open file");
		}

		final StackPane stackPane = new StackPane();
		stackPane.setPadding(new Insets(10));
		stackPane.getChildren().add(button);

		final Scene scene = new Scene(stackPane, 400, 400);
		try {
			scene.getStylesheets().add(stylesheet.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		primaryStage.setTitle("Basic AudioClip Example");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
