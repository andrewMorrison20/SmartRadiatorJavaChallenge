package smartDevice;

import java.util.ArrayList;

public class DeviceSearch {

	//polymorphic as any device can have the required attributes
	/**
	 * takes an arraylist and searches the list for any object that matches the room
	 * passed and returns the objects in an Array list
	 * 
	 * @param allDevices
	 * @param room
	 * @return results
	 */
	public static ArrayList<Device> searchByRoom(ArrayList<Device> allDevices, Room room) throws IllegalArgumentException{

		ArrayList<Device> results = new ArrayList<Device>();
		if (allDevices.size() != 0) {
			for (Device d : allDevices) {
				if (d.getRoom() == room) {
					results.add(d);
				}
			}
		} else {throw new IllegalArgumentException("List cannot be null");}
		return results;
	}
	//only radiator has temp so not polymorphic
	/**
	 * Takes an arraylist of type radiator and searches for those radiators within
	 * the defined range returns the list as an arraylist
	 * 
	 * @param allRadiators
	 * @param tempLowerLimit
	 * @param tempUpperLimit
	 * @return
	 */
	public ArrayList<SmartRadiator> searchBytemp(ArrayList<SmartRadiator> allRadiators, double tempLower, double tempUpper) {
		ArrayList<SmartRadiator> results = new ArrayList<SmartRadiator>();
		if(tempLower>tempUpper || allRadiators.size()==0) {throw new IllegalArgumentException("Invalid Inputs");}
		else {for(SmartRadiator r : allRadiators) {
			if(r.getTempNow()>=tempLower && r.getTempNow()<=tempUpper) {
				results.add(r);
			}
		}}
		return results;
		// TODO Auto-generated method stub
		
	}

}
