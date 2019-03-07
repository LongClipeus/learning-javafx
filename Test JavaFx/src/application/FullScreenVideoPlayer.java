package application;

import static config.Define.PROJECT_PATH;

import java.io.File;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FullScreenVideoPlayer extends Application {

	public static final String VIDEO_FILE = "/src/data/video/SampleVideo_1280x720_10mb.mp4";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		String videoPath = "file:" + PROJECT_PATH.replace(" ", "%20") + VIDEO_FILE;

		try {
			final Media m = new Media(videoPath);
			final MediaPlayer mp = new MediaPlayer(m);
			final MediaView mv = new MediaView(mp);

			final DoubleProperty width = mv.fitWidthProperty();
			final DoubleProperty height = mv.fitHeightProperty();

			System.out.println(mv.sceneProperty() + "");
			System.out.println(mv.parentProperty() + "");
			System.out.println(Bindings.selectDouble(mv.sceneProperty(), "width") + "");
			width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
			height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
//			            Bindings.selectDouble(mv.parentProperty(), "width").divide(2));
			System.out.println(width);
			System.out.println(height);

			mv.setPreserveRatio(true);

			StackPane root = new StackPane();
			root.getChildren().add(mv);

			final Scene scene = new Scene(root, 480, 270);
			scene.setFill(Color.BLACK);

			primaryStage.setScene(scene);
			primaryStage.setTitle("Full Screen Video Player");
			primaryStage.setFullScreen(true);
			primaryStage.show();

			mp.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
