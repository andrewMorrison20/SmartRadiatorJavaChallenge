package smartDevice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDeviceSearch {
	
ArrayList<Device> expectedDeviceList;
ArrayList<Device> resultsDeviceList;
ArrayList<Device> allDevices;

ArrayList<SmartRadiator> expectedRadiatorList;
ArrayList<SmartRadiator> resultsRadiatorList;
ArrayList<SmartRadiator> allRadiators;

ArrayList<Device> nullList;
ArrayList<SmartRadiator>nullRadiatorList;

SmartRadiator r1,r2,r,r3,r4,r5;

String name1, name2, name3, name4, name5;
String man1, man2, man3, man4, man5;
double temp1, temp2, temp3, temp4, temp5;
double targ1, targ2, targ3, targ4, targ5;
Room room1, room2, room3, room4, room5;
PowerState state1, state2, state3, state4, state5;
double tempUpper,tempLower;

DeviceSearch search = new DeviceSearch();


@BeforeEach
	void setUp() throws Exception {
		

	name1= "NameOne";
	name2= "NameTwo";
	name3="NameThree";
	name4= "NameFour";
	name5= "NameFive";
	man1= "ManufacturerOne";
	man2 = "ManufacturerTwo";
	man3= "ManufacturerThree";
	man4= "ManufacturerFour";
	man5 = "ManufacturerFive";
         temp1 = 10.0;
		 temp2 = 13.0;
		 temp3 = 17.0;
		 temp4 = 20.0;
		 temp5 = 28.0;
		 targ1 = 6.0;
		 targ2 =12.0;
		 targ3 = 18.0;
		 targ4 = 20.0;
		 targ5 = 25.0;
		 room1 = Room.BATHROOM;
		 room2 = Room.BEDROOM;
		 room3 = Room.HOUSE;
		 room4 = Room.KITCHEN;
		 room5 = Room.LOUNGE;
		 state1 = PowerState.OFF;
		 state2 = PowerState.OFF;
		 state3 = PowerState.OFF;
		 state4 = PowerState.OFF;
		 state5 = PowerState.OFF;
		 
		 r1 = new SmartRadiator(name1, man1, temp1, targ1, room1, state1);
		 r2 = new SmartRadiator(name2, man2, temp2, targ2, room2, state2);
		 r3 = new SmartRadiator(name3, man3, temp3, targ3, room3, state3);
		 r4= new SmartRadiator(name4, man4, temp4, targ4, room4, state4);
		 r5 = new SmartRadiator(name5, man5, temp5, targ5, room5, state5);
		 
		expectedDeviceList = new ArrayList<Device>();
		resultsDeviceList = new ArrayList<Device>();
		allDevices = new ArrayList<Device>();
		nullList=new ArrayList<Device>();

		 expectedRadiatorList = new ArrayList<SmartRadiator>();
		 resultsRadiatorList = new ArrayList<SmartRadiator>();
		 allRadiators=new ArrayList<SmartRadiator>();
		 nullRadiatorList =new ArrayList<SmartRadiator>();
		 
		 allDevices.add(r1);
		 allDevices.add(r2);
		 allDevices.add(r3);
		 allDevices.add(r4);
		 allDevices.add(r5);
		 
		 allRadiators.add(r1);
		 allRadiators.add(r2);
		 allRadiators.add(r3);
		 allRadiators.add(r4);
		 allRadiators.add(r5);
	}

@Test
void testSearchByRoomValidInput() {
	//single return result
	resultsDeviceList= DeviceSearch.searchByRoom(allDevices, room1);
	assertTrue(resultsDeviceList.size()==1 && resultsDeviceList.contains(r1));
	
	//Multiple matches
	SmartRadiator r = new SmartRadiator(name1, man1, temp1, targ1, room1, state1);
	allDevices.add(r);
	resultsDeviceList= DeviceSearch.searchByRoom(allDevices, room1);
	assertTrue(resultsDeviceList.size()==2 && resultsDeviceList.contains(r1) &&resultsDeviceList.contains(r));
	
	
}

@Test
void testInvalidInputSearchByRoomExpectsException() {
	Exception e = assertThrows(IllegalArgumentException.class, ()->{
		search.searchByRoom(nullList, room1);
	});
}

@Test 
void testSearchByTempValidPath() {
	tempUpper=15;
	tempLower=10;
	resultsRadiatorList=search.searchBytemp( allRadiators,  tempLower,  tempUpper);
	expectedRadiatorList.add(r1);
	expectedRadiatorList.add(r2);
	assertTrue(resultsRadiatorList.size()==2&& resultsRadiatorList.contains(r1)&&resultsRadiatorList.contains(r2));
	
}

@Test
void TestSearchBytempInvalidPathExpectsException(){
	
	tempUpper=15;
    tempLower=10;
	Exception e = assertThrows(IllegalArgumentException.class, ()->{
		
		search.searchBytemp(nullRadiatorList, tempLower,tempUpper);
	});
	
	
	tempUpper=10;
    tempLower=20;
     e = assertThrows(IllegalArgumentException.class, ()->{
		
		search.searchBytemp(allRadiators, tempLower,tempUpper);
	});
}
}
