package bigkenbird.MyStock.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetToday {
	
	public static Date today=getToday();
	
	private static Date getToday() {
		Date today=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateformat=sdf.format(today);
		Date date_rs = null;
		try {
			date_rs = sdf.parse(dateformat);
			return date_rs;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date_rs;
		
	}
}
