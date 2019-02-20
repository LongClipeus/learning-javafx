package view;

import entity.Book;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {

	@Override
	public void start(Stage stage) {

		Book book1 = new Book(1L, "J01", "Java IO Tutorial");
		Book book2 = new Book(2L, "J02", "Java Enums Tutorial");
		Book book3 = new Book(2L, "C01", "C# Tutorial for Beginners");

		// Một danh sách
		ObservableList<String> books = FXCollections.observableArrayList(book1.getName(), book2.getName(),
				book3.getName());

		// Tạo một ListView
		ListView<String> listView = new ListView<String>(books);

		// Cho phép lựa chọn nhiều dòng trên danh sách.
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// Lựa chọn phần tử Index = 0
		listView.getSelectionModel().selectIndices(0);

		// Focus
		listView.getFocusModel().focus(2);
		
//		listView.setOrientation(Orientation.HORIZONTAL);
		listView.setOrientation(Orientation.VERTICAL);

		StackPane root = new StackPane();
		root.getChildren().add(listView);

		stage.setTitle("ListView (o7planning.org)");

		Scene scene = new Scene(root, 350, 200);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
