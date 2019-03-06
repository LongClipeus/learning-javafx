package application;

import javafx.application.Application;
import view.TestGUI;

public class Main {

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				Application.launch(TestGUI.class, args);
			}
		}.start();
	}

}
