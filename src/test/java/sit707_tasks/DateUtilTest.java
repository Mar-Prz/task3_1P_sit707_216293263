package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Mark Przybylkiewicz
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "216293263";
		Assert.assertNotNull("Student ID is 216293263", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Mark Przybylkiewicz";
		Assert.assertNotNull("Student name is Mark Przybylkiewicz", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
		date.increment();
		Assert.assertEquals("January 1 should increment to January 2", 2, date.getDay());
		Assert.assertEquals("Month should stay January", 1, date.getMonth());
		
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("january 1 should decrement to December 31 > " + date);
	    date.decrement();
	    Assert.assertEquals("Decrementing January 1st should result in December 31st of the previous year", 31, date.getDay());
	    Assert.assertEquals("The month should be December", 12, date.getMonth());
	    Assert.assertEquals("The year should decrement by 1", 2023, date.getYear());
	}
	
	@Test
	public void testFebruary28ShouldIncrementToFebruary29InLeapYear() {
	    DateUtil date = new DateUtil(28, 2, 2024);
	    date.increment();
	    Assert.assertEquals("February 28 should increment to February 29 in a leap year", 29, date.getDay());
	    Assert.assertEquals("The month should stay as February", 2, date.getMonth());
	}

	@Test
	public void testFebruary29ShouldIncrementToMarch1InLeapYear() {
	    DateUtil date = new DateUtil(29, 2, 2024);
	    date.increment();
	    Assert.assertEquals("February 29 should increment to March 1 in a leap year", 1, date.getDay());
	    Assert.assertEquals("The month should change to March", 3, date.getMonth());
	}
}
