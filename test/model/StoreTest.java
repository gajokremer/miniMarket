package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.AgeException;
import exceptions.DayException;

class StoreTest {

	private Store store;

	public void setUpScenario1() {

		store = new Store();
	}

	@Test
	public void testAddWorks() {

		setUpScenario1();

		String t = "CC";
		String i = "0149508384";

		Person p = new Person(t, i);
		
		try {
			assertTrue(store.add(t, i));
		} catch (AgeException | DayException e) {
			e.printStackTrace();
		}
		
		assertEquals(t, p.getType());
		assertEquals(i, p.getId());
	}
	
	@Test
	public void testAgeException() {
		
		setUpScenario1();
		
		String t = "TI";
		String i = "7010991649";

		try {
			assertFalse(store.add(t, i));
		} catch (AgeException | DayException e) {
			e.printStackTrace();
		}
		
		assertThrows(AgeException.class, () -> {

			throw new AgeException(t);
		});
	}

	@Test
	public void testDayException() {
		
		setUpScenario1();
		
		String t = "PP";
		String i = "0621220734";
		
		try {
			assertFalse(store.add(t, i));
		} catch (AgeException | DayException e) {
			e.printStackTrace();
		}
		
		assertThrows(DayException.class, () -> {
			
			throw new DayException(i);
		});
	}
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
}
