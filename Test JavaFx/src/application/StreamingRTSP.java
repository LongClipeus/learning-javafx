package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class StreamingRTSP extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Media m = new Media("rtsp://192.168.69.108:554/cam/realmonitor?channel=1&subtype=1&unicast=true&proto=Onvif");
			MediaPlayer mp = new MediaPlayer(m);
			MediaView mv = new MediaView(mp);

			StackPane root = new StackPane();
			root.getChildren().add(mv);

			primaryStage.setScene(new Scene(root, 960, 540));
			primaryStage.setTitle("Video Player 1");
			primaryStage.show();

			mp.play();
		} catch (Exception e) {
			System.out.println("Can't open video\n");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
