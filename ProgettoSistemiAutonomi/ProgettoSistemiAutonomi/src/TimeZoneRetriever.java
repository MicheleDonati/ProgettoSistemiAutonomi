import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneRetriever implements ITimeZoneRetriever{

	private TimeZone timeZone;
	private Calendar calendar;
	private int hour;
	
	public TimeZoneRetriever(String city){
		timeZone = TimeZone.getTimeZone(city);
		this.calendar = new GregorianCalendar();
		calendar.setTimeZone(timeZone);
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public int getHourFromTimeZone() {
		return this.hour;
	}
	
	
	
}
