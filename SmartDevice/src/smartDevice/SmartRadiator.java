package smartDevice;

public class SmartRadiator extends Device {

	/**
	 * constants for various variables to define legal ranges for respective
	 * instance variables
	 */
	public static final double TEMPNOW_MIN = 10.00;
	public static final double TEMPNOW_MAX = 30.00;
	public static final double TEMP_TARGET_MIN = 5.00;
	public static final double TEMP_TARGET_MAX = 26.00;

	/**
	 * variables relating to the current temperature of the smart radiator and the
	 * target temperature
	 */

	private double tempNow, tempTarget;

	/**
	 * constructor with args
	 * 
	 * @param name
	 * @param manufacturer
	 * @param powerState
	 * @param room
	 * @param tempNow
	 * @param tempTarget
	 */
	public SmartRadiator(String name, String manufacturer, double tempNow, double tempTarget, Room room,
			PowerState state) {
		super(name, manufacturer, room, state);
		this.setTempTarget(tempTarget);
        this.setTempNow(tempNow);
		
	}

	/**
	 * default constructor takes no args
	 */
	public SmartRadiator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * returns the current value of temp of the radiator as a double
	 * 
	 * @return tempNow
	 */
	public double getTempNow() {
		return tempNow;
	}
	
	/**
	 * Assigns temp now with the arg passed if legal, else throws a new illegal
	 * argument exception
	 * 
	 * @param tempNow2
	 */
	public void setTempNow(double tempNow) throws IllegalArgumentException {
		if (tempNow < TEMPNOW_MIN || tempNow > TEMPNOW_MAX) {
			throw new IllegalArgumentException("Invalid temp now entered");
		} else {
			if (tempNow < tempTarget) {
				this.setState(PowerState.ON);
		} else {this.setState(PowerState.OFF);}
			this.tempNow = tempNow;
		}
	}
	
	/**
	 * returns the current value of the target temperature as a double
	 * 
	 * @return
	 */
	public double getTempTarget() {
		return tempTarget;
	}
	
	/**
	 * assigns the variable temp target with the arg passed if within legal range
	 * else throws an illegal argument exception
	 * 
	 * @param tempTarget
	 */
	public void setTempTarget(double tempTarget) {
		if (tempTarget < TEMP_TARGET_MIN || tempTarget > TEMP_TARGET_MAX) {
			throw new IllegalArgumentException("INVALID TARGET TEMP");
		} else {
			this.tempTarget = tempTarget;
		}
	}
	
	/**
	 * displays all current values of the attributes of radiator
	 */
	@Override
	public void showAll() {
		System.out.printf("NAME -%10s -10%s",":",getName());
		System.out.printf("\nMANUFACTURER -%10s -10%s",":",getManufacturer());
		System.out.printf("\nROOM -%10s -10%s",":",getRoom());
		System.out.printf("\nPOWERSTATE -%10s -10%s",":",getState());
		System.out.printf("\nName -%10s -%10.1f Degrees",":",tempNow);
		System.out.printf("\nName -%10s -%10.1f  Degrees",":",tempTarget);
	}
	
	/**
	 * returns the name room current temp target temp and current state of the
	 * radiator as a string
	 */
	@Override
	public String status() {
		return String.format("SR-%s-%s-NOW:%.1f-TARGET:%.1f-%s",getName(),getRoom(),tempNow,tempTarget,getState());
	
	}
}
