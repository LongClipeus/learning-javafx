package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlanetDAO {

	public static ObservableList<String> getPlanetList() {
		Planet mercury = new Planet("MER", "Mercury");
		Planet venus = new Planet("VEN", "Venus");
		Planet earth = new Planet("EAR", "Earth");

		ObservableList<String> list //
				= FXCollections.observableArrayList(mercury.getName(), venus.getName(), earth.getName());

		return list;
	}

}
