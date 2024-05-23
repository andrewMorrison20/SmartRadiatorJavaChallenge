package smartDevice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSmartRadiator {

	String nameValidMin, nameValidMax, nameValidMid, nameInvalidMin, nameInvalidMax;
	String manufacturerValidMin, manufacturerValidMid, manufacturerValidMax, manufacturerInvalidMin,
			manufacturerInvalidMax;
	double tempNowValidMin, tempNowValidMid, tempNowValidMax, tempNowInvalidMin, tempNowInvalidMax;
	double tempTargetValidMin, tempTargetValidMid, tempTargetValidMax, tempTargetInvalidMin, tempTargetInvalidMax;
	SmartRadiator sr;
	Room room;
	PowerState state;

	@BeforeEach
	void setUp() throws Exception {

		nameValidMin = "a".repeat(3);
		nameValidMax = "a".repeat(20);
		nameValidMid = "ValidName";
		nameInvalidMin = "x".repeat(2);
		nameInvalidMax = "x".repeat(21);
		manufacturerValidMin = "a".repeat(3);
		manufacturerValidMid = "ValidManufacturer";
		manufacturerValidMax = "a".repeat(20);
		manufacturerInvalidMin = "x".repeat(2);
		manufacturerInvalidMax = "x".repeat(21);
		tempNowValidMin = 10.00;
		tempNowValidMid = 20.00;
		tempNowValidMax = 30.00;
		tempNowInvalidMin = 9.99;
		tempNowInvalidMax = 30.01;
		tempTargetValidMin = 5.00;
		tempTargetValidMid = 17.50;
		tempTargetValidMax = 26.00;
		tempTargetInvalidMin = 4.99;
		tempTargetInvalidMax = 26.01;
		sr = new SmartRadiator();
		room = Room.HOUSE;
		state = PowerState.OFF;
	}

	@Test
	void testConstructorValidArgs() {

		sr = new SmartRadiator(nameValidMin, manufacturerValidMin, tempNowValidMin, tempTargetValidMin, room, state);
		assertEquals(nameValidMin, sr.getName());
		assertEquals(manufacturerValidMin, sr.getManufacturer());
		assertEquals(tempNowValidMin, sr.getTempNow());
		assertEquals(tempTargetValidMin, sr.getTempTarget());
		assertEquals(room, sr.getRoom());
		assertEquals(state, sr.getState());
	}

	@Test
	void testDefaultConstructor() {
		sr = new SmartRadiator();
		assertNotNull(sr);

	}

	@Test
	void testGetSetNameValid() {
		String expected, actual;
		expected = nameValidMin;
		sr.setName(expected);
		actual = sr.getName();
		assertEquals(expected, actual);

		expected = nameValidMid;
		sr.setName(expected);
		actual = sr.getName();
		assertEquals(expected, actual);

		expected = nameValidMax;
		sr.setName(expected);
		actual = sr.getName();
		assertEquals(expected, actual);
	}

	@Test
	void setInvalidNameExpectsException() {

		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			sr.setName(nameInvalidMin);
		});

		e = assertThrows(IllegalArgumentException.class, () -> {
			sr.setName(nameInvalidMax);
		});

	}

	@Test
	void testGetSetManufacturerValid() {

		String expected, actual;

		expected = manufacturerValidMin;
		sr.setManufacturer(expected);
		actual = sr.getManufacturer();
		assertEquals(expected, actual);

		expected = manufacturerValidMid;
		sr.setManufacturer(expected);
		actual = sr.getManufacturer();
		assertEquals(expected, actual);

		expected = manufacturerValidMax;
		sr.setManufacturer(expected);
		actual = sr.getManufacturer();
		assertEquals(expected, actual);

	}

	@Test
	void testSetInvalidManufacturerExpectsException() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			sr.setManufacturer(manufacturerInvalidMin);
		});

		e = assertThrows(IllegalArgumentException.class, () -> {
			sr.setManufacturer(manufacturerInvalidMax);
		});
	}

	@Test
	void testSetGetTempTargetValid() {
		double expected, actual;
		expected = tempTargetValidMin;
		sr.setTempTarget(tempTargetValidMin);
		actual = sr.getTempTarget();
		assertEquals(expected, actual, 0.01);

		expected = tempTargetValidMid;
		sr.setTempTarget(tempTargetValidMid);
		actual = sr.getTempTarget();
		assertEquals(expected, actual, 0.01);

		expected = tempTargetValidMax;
		sr.setTempTarget(tempTargetValidMax);
		actual = sr.getTempTarget();
		assertEquals(expected, actual, 0.01);

	}

	@Test
	void testSetTempTargetInvalidExpectsExpectation() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			sr.setTempTarget(tempTargetInvalidMin);
		});

		e = assertThrows(IllegalArgumentException.class, () -> {
			sr.setTempTarget(tempTargetInvalidMax);
		});

	}
	
	@Test
	void testGetSetRoom() {
		sr.setRoom(Room.BATHROOM);
		assertEquals(Room.BATHROOM, sr.getRoom());
		
		sr.setRoom(Room.BEDROOM);
		assertEquals(Room.BEDROOM, sr.getRoom());
		
		sr.setRoom(Room.HOUSE);
		assertEquals(Room.HOUSE, sr.getRoom());
		
		sr.setRoom(Room.KITCHEN);
		assertEquals(Room.KITCHEN, sr.getRoom());
		
		sr.setRoom(Room.LOUNGE);
		assertEquals(Room.LOUNGE, sr.getRoom());
	}
	
	@Test
	void testGetSetPowerState() {
		sr.setState(PowerState.ON);
		assertEquals(PowerState.ON, sr.getState());
		sr.setState(PowerState.OFF);
		assertEquals(PowerState.OFF,sr.getState());
	}
	
	@Test
	void testGetSetTempNow() {
		double expected,actual;
		expected = tempNowValidMin;
		sr.setTempNow(expected);
		actual = sr.getTempNow();
		assertEquals(expected,actual,0.01);
		
		
		expected = tempNowValidMid;
		sr.setTempNow(expected);
		actual = sr.getTempNow();
		assertEquals(expected,actual,0.01);
		
		
		expected = tempNowValidMax;
		sr.setTempNow(expected);
		actual = sr.getTempNow();
		assertEquals(expected,actual,0.01);
	
	}
	
	@Test
	void testSetInvalidtempExpectsException() {
		Exception e = assertThrows(IllegalArgumentException.class, ()->{
			sr.setTempNow(tempNowInvalidMin);
		});
		
		 assertThrows(IllegalArgumentException.class, ()->{
				sr.setTempNow(tempNowInvalidMax);
			});
	}
	
	@Test
	void testSetterTempNowEffectOnState() {
		
		double tempEqual = 15;
		sr = new SmartRadiator(nameValidMax, manufacturerValidMax, tempNowValidMin,tempTargetValidMax, room,state);
		assertEquals(PowerState.ON,sr.getState());
		
		sr = new SmartRadiator(nameValidMax, manufacturerValidMax, tempNowValidMax,tempTargetValidMin, room,state);
		assertEquals(PowerState.OFF,sr.getState());
		
		sr = new SmartRadiator(nameValidMax, manufacturerValidMax, tempEqual,tempEqual, room,state);
		assertEquals(PowerState.OFF,sr.getState());
		
		
		
}
	
	@Test
	void testStatus() {
		sr = new SmartRadiator(nameValidMin, manufacturerValidMin, tempNowValidMin, tempTargetValidMin, room, state);
		String expected = "SR-aaa-HOUSE-NOW:10.0-TARGET:5.0-OFF";
		String actual = sr.status(); 
		assertEquals(expected, actual);
	}
}
