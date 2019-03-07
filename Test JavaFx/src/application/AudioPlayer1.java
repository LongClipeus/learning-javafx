package application;

import java.net.URL;

import config.Define;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class AudioPlayer1 extends Application {

//	public static final String AUDIO_FILE = Define.AUDIO + "audio-test.wav";
	public static final String AUDIO_FILE = Define.AUDIO + "4C.mp3";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			URL resource = getClass().getResource(AUDIO_FILE);
			Media media = new Media(resource.toString());

			MediaPlayer mediaPlayer = new MediaPlayer(media);
			mediaPlayer.setOnError(() -> {
				final String errorMessage = media.getError().getMessage();
				System.out.println(errorMessage);
			});
			mediaPlayer.play();
		} catch (RuntimeException re) {
			re.printStackTrace();
		}

		primaryStage.setTitle("Audio Player 1");
		primaryStage.setWidth(200);
		primaryStage.setHeight(200);
		primaryStage.show();
	}

}
