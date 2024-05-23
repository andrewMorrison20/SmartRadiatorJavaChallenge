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

	public double getTempNow() {
		return tempNow;
	}

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

	public double getTempTarget() {
		return tempTarget;
	}

	public void setTempTarget(double tempTarget) {
		if (tempTarget < TEMP_TARGET_MIN || tempTarget > TEMP_TARGET_MAX) {
			throw new IllegalArgumentException("INVALID TARGET TEMP");
		} else {
			this.tempTarget = tempTarget;
		}
	}
	
@Override
public void showAll() {
	System.out.printf("NAME -%10s -10%s",":",getName());
	System.out.printf("\nMANUFACTURER -%10s -10%s",":",getManufacturer());
	System.out.printf("\nROOM -%10s -10%s",":",getRoom());
	System.out.printf("\nPOWERSTATE -%10s -10%s",":",getState());
	System.out.printf("\nName -%10s -%10.1f Degrees",":",tempNow);
	System.out.printf("\nName -%10s -%10.1f  Degrees",":",tempTarget);
}

@Override
public String status() {
	return String.format("SR-%s-%s-NOW:%.1f-TARGET:%.1f-%s",getName(),getRoom(),tempNow,tempTarget,getState());
	
}
}