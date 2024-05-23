package smartDevice;

import java.util.ArrayList;

public class DeviceSearch {

	
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
