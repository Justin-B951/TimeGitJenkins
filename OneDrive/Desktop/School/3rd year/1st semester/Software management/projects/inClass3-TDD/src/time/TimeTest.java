package time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	// Total Second Tests
	@Test
	void testGetTotalSecondsGood() {
		
		int seconds = Time.getTotalSeconds("05:05:05:90");
		assertTrue(seconds==18305);
	}
	
	
	@Test
	void testGetTotalSecondsBad() {
		
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getTotalSeconds("10:00");});
	}
	
	
	@Test
	void testGetTotalSecondsBoundary() {
		
		int secondsLower = Time.getTotalSeconds("00:00:00");
		int secondsUpper = Time.getTotalSeconds("99:99:99");
		assertTrue(secondsLower==0 && secondsUpper == 362439);
		
	}
	
	// Total Minute Test
	@Test
	void testGetTotalMinutesGood() {
		int minutes = Time.getTotalMinutes("00:10:00");
		assertTrue(minutes == 10);
	}
	
	@Test
	void testGetTotalMinutesBad() {
		int minutes = Time.getTotalMinutes("00:10:00");
		assertFalse(minutes == 20);
	}
	
	@Test
	void testGetTotalMinutesBoundary() {
		int minutesUpper = Time.getTotalMinutes("00:00:00");
		int minutesLower = Time.getTotalMinutes("00:99:00");
		assertTrue(minutesUpper == 0 && minutesLower == 99);
	}
	
	//Total Hour Test
	@Test
	void testGetTotalHoursGood() {
		int hours = Time.getTotalHours("10:00:00");
		assertTrue(hours == 10);
	}
	
	@Test
	void testGetTotalHoursBad() {
		int hours = Time.getTotalHours("20:00:00");
		assertFalse(hours == 10);
	}
	
	@Test
	void testGetTotalHoursBoundary() {
		int hoursLower = Time.getTotalHours("00:00:00");
		int hoursUpper = Time.getTotalHours("99:00:00");
		assertTrue(hoursLower == 0 && hoursUpper == 99);
	}
	
	// Get second Test
	@Test
	void testTotalSecondGood() {
		int seconds = Time.getSeconds("00:00:60");
		assertTrue(seconds == 60);
	}
	
	@Test
	void testTotalSecondBad() {
		int seconds = Time.getSeconds("00:00:60");
		assertFalse(seconds == 30);
	}
	
	@Test
	void testTotalSecondBoundary() {
		int secondsLower = Time.getSeconds("00:00:00");
		int secondsUpper = Time.getSeconds("00:00:99");
		assertTrue(secondsLower == 0 && secondsUpper == 99);
		
	}
	
	//Parameterized Tests

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
	void testGetTotalHours(String candidate) {
		
		int hours = Time.getTotalHours(candidate);
		assertTrue( hours ==5);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "00:10:10", "20:10:00", "30:10:00" })
	void testGetTotalMinutes(String candidate) {
		
		int minutes = Time.getTotalMinutes(candidate);
		assertTrue(minutes ==10);
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "00:60:00:00", "00:59:60:00","01:00:00:00"})
	void testGetTotalSecond(String candidate) {
		
		double seconds = Time.getTotalSeconds(candidate);
		assertTrue(seconds ==3600);
	}
	
	//Get getMilliseconds tests in class 3 
	@Test
	void testGetMillisecondsGood() {
		int milliseconds = Time.getMilliseconds("00:00:00:15");
		assertTrue(milliseconds == 15);
	}
	
	@Test
	void testGetMillisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class,()-> {Time.getMilliseconds("00:00:1");});
		
	}
	
	@Test
	void testGetMillisecondsBoundary(){
		int milliseconds = Time.getMilliseconds("00:00:00:59");
		assertTrue(milliseconds == 59);
	}

}
