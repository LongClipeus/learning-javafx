package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import config.Define;

public class TimerSystem {

	public String getDateTime() {
		Date current = new Date();

		DateFormat dateFormat = new SimpleDateFormat(Define.DATE_TIME_FORMAT);
		
		return dateFormat.format(current);
	}

}
