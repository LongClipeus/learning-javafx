package view;

import entity.Book;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewChangeListener extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Book book1 = new Book(1L, "J01", "Java IO Tutorial");
		Book book2 = new Book(2L, "J02", "Java Enums Tutorial");
		Book book3 = new Book(2L, "C01", "C# Tutorial for Beginners");

		Label label = new Label();

		// Một danh sách
		ObservableList<String> books = FXCollections.observableArrayList(book1.getName(), book2.getName(), book3.getName());

		// Tạo một ListView
		ListView<String> listView = new ListView<String>(books);

		// Chỉ cho phép lựa chọn 1 dòng trên danh sách.
		listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

//			@Override
//			public void changed(ObservableValue<? extends Book> observable, Book oldValue, Book newValue) {
//				// TODO Auto-generated method stub
//				label.setText("OLD: " + oldValue + ",  NEW: " + newValue);
//			}

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				label.setText("OLD: " + oldValue + "-->  NEW: " + newValue);
			}
		});

		VBox root = new VBox();
		root.getChildren().addAll(listView, label);

		primaryStage.setTitle("ListView & ChangeListener (o7planning.org)");

		Scene scene = new Scene(root, 450, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
