package javaClasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DateUtil {

	public List<String> getDatesBetweenDates(String strstartdate, String strenddate)
	{
		String[] tokkens = strstartdate.split("/");
		strstartdate = tokkens[2]+"-"+tokkens[0]+"-"+tokkens[1];
		
		tokkens = strenddate.split("/");
		strenddate = tokkens[2]+"-"+tokkens[0]+"-"+tokkens[1];

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date startdate = null;
		Date enddate = null;
		try {
			startdate = format.parse(strstartdate);
			enddate = format.parse(strenddate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	    List<String> dates = new ArrayList<String>();
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(startdate);

	    while (calendar.getTime().before(enddate))
	    {
	        Date result = calendar.getTime();
	        dates.add(format.format(result));
	        calendar.add(Calendar.DATE, 1);
	    }
		dates.add(format.format(enddate)); //we add enddate too
		

	    return dates;
	}
}
