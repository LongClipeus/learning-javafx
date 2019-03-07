package application;

import java.io.File;

import static config.Define.PROJECT_PATH;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class VideoPlayer1 extends Application {

	public static final String VIDEO_FILE = "/src/data/video/SampleVideo_1280x720_10mb.mp4";

	@Override
	public void start(Stage primaryStage) {
//		File videoFile = new File(PROJECT_PATH, VIDEO_FILE);
//		String videoPath = videoFile.toURI().toString();

//		String videoPath = "file:" + PROJECT_PATH.replace('\\', '/').replace(" ", "%20") + VIDEO_FILE;
		String videoPath = "file:" + PROJECT_PATH.replace(" ", "%20") + VIDEO_FILE;
		
		try {

			Media m = new Media(videoPath);
			MediaPlayer mp = new MediaPlayer(m);
			MediaView mv = new MediaView(mp);

			StackPane root = new StackPane();
			root.getChildren().add(mv);

			primaryStage.setScene(new Scene(root, 960, 540));
			primaryStage.setTitle("Video Player 1");
			primaryStage.show();

			mp.play();
		} catch (Exception e) {
			System.out.println("Can't open video");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
