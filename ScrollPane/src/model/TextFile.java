package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TextFile {

	public String readTextFile(String addr) {
		String str;
		String text = "";
		File file = new File(addr);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((str = br.readLine()) != null) {
				text += str;
				text += "\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

}
