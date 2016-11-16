package fr.dta.mediatic.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateGenerator {

	public static Date getDate(String d) throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat.parse(d);
	}
}
