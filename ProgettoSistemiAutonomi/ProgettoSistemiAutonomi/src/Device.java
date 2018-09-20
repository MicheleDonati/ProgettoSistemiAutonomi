import org.json.JSONException;

public class Device implements IDevice{

	private Utils utils;
	private Patient patient;
	private UserInterface ui;
	private ITimeZoneRetriever tzRetriever;
	private IWeatherInformationRetriever wiRetriever;
	private IFilter filter;
	private boolean flag = false;
	private int setup;
	
	public Device(UserInterface ui, int setup){
		utils = new Utils();
		this.ui = ui;
		this.setup = setup;
		patient = new Patient();
		filter = new Filter();
		setHour();
		setWeather();
		writeMotivationalMessage();	
		ui.enableChangeConditions();
	}
	

	public void setHour(){
		if(setup == 1){
			tzRetriever = new TimeZoneRetriever(patient.getCitta1Tz());
			ui.writeGeneralInfo(utils.HOUR + tzRetriever.getHourFromTimeZone(), true);
		}
		else {
			tzRetriever = new TimeZoneRetriever(patient.getCitta2Tz());
			ui.writeGeneralInfo(utils.HOUR + tzRetriever.getHourFromTimeZone(), true);
		}
	}
	
	public void setWeather(){
		if(setup == 1){
			wiRetriever = new WeatherInformationRetriever(patient.getCitta1Wi());
			try {
				ui.writeGeneralInfo(wiRetriever.getWeatherInformations(), false);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		else {
			wiRetriever = new WeatherInformationRetriever(patient.getCitta2Wi());
			try {
				ui.writeGeneralInfo(wiRetriever.getWeatherInformations(), false);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeMotivationalMessage(){
		flag = filter.timeFilter(tzRetriever.getHourFromTimeZone());
		if(flag == false){
			ui.writeMessageInfo(utils.STAY_HOME_MESSAGE_NIGHT);
		}
		else if (flag){
			ui.writeMessageInfo(filter.weatherFilter(wiRetriever.getResponse()));
		}
	}
	
}
