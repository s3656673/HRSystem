import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	@Test
	// Test viewing timetable
	/* This test is expected to pass as there is a record for ISYS1118 in the database
	*/
	void testTimetable() {
		Timetable timetable = new Timetable();
		String result = timetable.viewTimetable("ISYS1118");
		assertEquals("ID: 1 FirstName: Bill LastName: Billson Date: 1/08/2018 Time:04:00", result);
	}

	@Test
	// Test input rate
	/*
	 * This test is expected to fail if the record already exists in the database,
	 * as the inputRates method imports into the database. However, if no record
	 * exists, it will be expected to pass.
	 */
	void inputRates() {
		Rates rates = new Rates();
		String result = rates.inputRates();
		assertEquals("Data imported successfully", result);
	}

	@Test
	/*
	 * This test checks if the availability class can manipulate the data in the SQL
	 * database, if the test has passed, the boolean will return true, therefore
	 * test will pass. Otherwise, if an SQLException occurs, the boolean will return
	 * false, therefore test will fail.
	 */
	void apply() {
		Availability availability = new Availability();
		boolean result = availability.apply("ISYS1118", "e123123");
		assertTrue(result);
	}

	@Test

	/*
	 * This test checks if the login will return false if the login was
	 * unsuccessful, therefore it will be able to deal with the exception and prompt
	 * the user to input the details again. The test will pass if the login returns
	 * false, however, if the login will return true for any value, Then this test
	 * will fail.
	 */
	void login() {
		Login login = new Login();
		boolean loginResult = login.Login();
		assertFalse(loginResult);
	}

}
