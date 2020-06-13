package edu.uoc.uocarium.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class KeeperTest {

	@Test
	void testSetId() throws KeeperException {
		Keeper keeper = new Keeper("G1234", "Abraham", "Lincoln");
		assertEquals("G1234", keeper.getId());
		Exception exceptionValue = assertThrows(KeeperException.class, ()-> keeper.setId("A1234"));
		assertEquals(KeeperException.MSG_ERR_ID_VALUE, exceptionValue.getMessage());
		Exception exceptionLength = assertThrows(KeeperException.class, ()-> keeper.setId("G123456"));
		assertEquals(KeeperException.MSG_ERR_ID_LENGTH, exceptionLength.getMessage());
		Exception exceptionNull = assertThrows(NullPointerException.class, ()-> keeper.setId(null));
		assertEquals(NullPointerException.class, exceptionNull.getClass());
	}

	@Test
	void testAddTank() throws KeeperException, TankException {
		Keeper keeper = new Keeper("G1234", "Abraham", "Lincoln");
		assertEquals(0, keeper.getTanks().size());
		assertEquals(Collections.emptyList(),keeper.getTanks());
		keeper.addTank(new Tank());
		assertEquals(1, keeper.getTanks().size());
		keeper.addTank(new Tank());
		assertEquals(2, keeper.getTanks().size());
		keeper.addTank(new Tank());
		assertEquals(3, keeper.getTanks().size());
		keeper.addTank(new Tank());
		assertEquals(4, keeper.getTanks().size());
		keeper.addTank(new Tank());
		assertEquals(5, keeper.getTanks().size());
		Exception exc = assertThrows(KeeperException.class, ()-> keeper.addTank(new Tank()));
		assertEquals(KeeperException.MSG_ERR_TANKS_SIZE, exc.getMessage());	
	}
	

}
