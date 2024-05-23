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
	
	/**
	* Constructor that takes args and assigns the value to the various parameters
	*
	* @param name
	* @param manufacturer
	* @param powerState
	* @param room
	*/
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
	
	/**
	 * Returns the current value of name of device as a string
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * assigns name with the argument passed if legal, else throws a illegal
	 * argument exception, if null throws null pointer
	 * 
	 * @param name
	 * @throws IllegalArgumentException
	 */
	public void setName(String name) throws IllegalArgumentException{
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Invalid nme length entered");
		} else {
		this.name = name;
		}
	}
	
	/**
	 * Returns the current value of manufacturer of the device as a string
	 * 
	 * @return manufacturer
	 */
	public String getManufacturer() {
	

		return manufacturer;
	}
	
	/**
	 * Assigns the argument passed to the parameter manufacturer if the arg is legal
	 * else throws an illegal arguments if arg is outside predefined range
	 * 
	 * @param manufacturer
	 */
	public void setManufacturer(String manufacturer)throws IllegalArgumentException {
		if(manufacturer.length()<MIN_MANUFACTURER_LENGTH || manufacturer.length()> MAX_MANUFACTURER_LENGTH) {
			throw new IllegalArgumentException("Invalid manufacturer length");
		}
	
		else{this.manufacturer = manufacturer;}
		}
	
	/**
	 * returns the current value of room
	 * 
	 * @return
	 */
	public Room getRoom() {
		return room;
	}
	
	/**
	 * assigns room with the arg passed
	 * 
	 * @param room
	 */
	public void setRoom(Room room) {
		this.room = room;
	}
	
	/**
	 * returns the current state of device
	 * 
	 * @return state
	 */
	public PowerState getState() {
		return state;
	}

	public void setState(PowerState state) {
		this.state = state;
	}

	/**
	 * abstract method that will be implemented in extended classes to show all
	 * current data to the console
	 */
	public abstract void showAll();

	/**
	 * abstract method that will be implemented in extended classes to return a
	 * string that represents the current state
	 */
	public abstract String status();


}
