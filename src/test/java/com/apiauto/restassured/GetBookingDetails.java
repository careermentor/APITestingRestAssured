package com.apiauto.restassured;

import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class GetBookingDetails 
{

	@Test
	public void getallbookings()
	{
		
		Response resp = RestAssured.get("https://restful-booker.herokuapp.com/booking/1");
		
		System.out.println(resp.getStatusCode());
		
		resp.print();
		
		Assert.assertEquals(resp.getStatusCode(), 200);  //hard assertion
		
		String actfirstname = resp.jsonPath().getString("firstname");
		Assert.assertEquals(actfirstname, "Susan");
		
		String actlastname = resp.jsonPath().getString("lastname");
		Assert.assertEquals(actlastname, "Wilson");
		
		int acttotalprice = resp.jsonPath().getInt("totalprice");
		Assert.assertEquals(acttotalprice, 257);
		
		boolean actdepostapid = resp.jsonPath().getBoolean("depositpaid");
		Assert.assertEquals(actdepostapid, false);
		
		String booking_checkin = resp.jsonPath().getString("bookingdates.checkin");
		Assert.assertEquals(booking_checkin, "2018-12-06");
		
		String booking_checkout = resp.jsonPath().getString("bookingdates.checkout");
		Assert.assertEquals(booking_checkout, "2021-01-17");
		
	}
	
}
