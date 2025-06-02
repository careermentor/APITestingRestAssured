package com.apiauto.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingDetails 
{

	@Test
	public void getallbookings()
	{
		
		Response resp = RestAssured.get("https://restful-booker.herokuapp.com/booking/1");
		
		System.out.println(resp.getStatusCode());
		
		resp.print();
		
		Assert.assertEquals(resp.getStatusCode(), 200);  //hard assertion
		
		SoftAssert sa = new SoftAssert();
		
		String actfirstname = resp.jsonPath().getString("firstname");
		sa.assertEquals(actfirstname, "Susan");
		
		String actlastname = resp.jsonPath().getString("lastname");
		sa.assertEquals(actlastname, "Wilson");
		
		int acttotalprice = resp.jsonPath().getInt("totalprice");
		sa.assertEquals(acttotalprice, 257);
		
		boolean actdepostapid = resp.jsonPath().getBoolean("depositpaid");
		sa.assertEquals(actdepostapid, false);
		
		String booking_checkin = resp.jsonPath().getString("bookingdates.checkin");
		sa.assertEquals(booking_checkin, "2018-12-06");
		
		String booking_checkout = resp.jsonPath().getString("bookingdates.checkout");
		sa.assertEquals(booking_checkout, "2021-01-17");
		
		sa.assertAll();
		
	}
	
}
