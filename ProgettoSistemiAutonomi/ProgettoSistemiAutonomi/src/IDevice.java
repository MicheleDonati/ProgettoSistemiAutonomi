/*
 * 	This is the device interface
 */


public interface IDevice {
	
	/*
	 * This method sets the hour of the day given the patient's city.
	 */
	void setHour();
	
	/*
	 * This method sets the weather informations about the patient's city.
	 */
	void setWeather();

	/*
	 * This method write a motivational message on the user interface given the informations retrieved with
	 * setHour() and setWeather().
	 */
	void writeMotivationalMessage();
}
