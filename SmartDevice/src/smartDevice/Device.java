package smartDevice;

public abstract class Device {
	/**
	 * various constants to define the legal ranges for respective instance variables
	 */
	
	public static final int MAX_NAME_LENGTH = 20;
	public static final int MIN_NAME_LENGTH = 3;
	public static final int MAX_MANUFACTURER_LENGTH =20;
	public static final int MIN_MANUFACTURER_LENGTH =3;
	
/**
 * various variables attaining to the attributes of the smart device
 */
	private String name,manufacturer;
	private Room room;
	private PowerState state;
	
	
	public Device(String name, String manufacturer, Room room, PowerState state) {
		this.setName(name);
		this.setManufacturer(manufacturer);
		this.state = state;
		this.room = room;
	}

/**
 * default constructor
 */
	public Device() {
		// TODO Auto-generated constructor stub
	}

public String getName() {
	return name;
}

public void setName(String name) throws IllegalArgumentException{
	if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
		throw new IllegalArgumentException("Invalid nme length entered");
	} else {
		this.name = name;
	}
}

public String getManufacturer() {
	

	return manufacturer;
}

public void setManufacturer(String manufacturer)throws IllegalArgumentException {
	if(manufacturer.length()<MIN_MANUFACTURER_LENGTH || manufacturer.length()> MAX_MANUFACTURER_LENGTH) {
		throw new IllegalArgumentException("Invalid manufacturer length");
	}
	
else{this.manufacturer = manufacturer;}
}

public Room getRoom() {
	return room;
}

public void setRoom(Room room) {
	this.room = room;
}

public PowerState getState() {
	return state;
}

public void setState(PowerState state) {
	this.state = state;
}


public abstract void showAll();


public abstract String status();


}
