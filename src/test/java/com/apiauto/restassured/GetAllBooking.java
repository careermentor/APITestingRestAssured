package com.apiauto.restassured;

import org.testng.Assert;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class GetAllBooking 
{

	@Test
	public void getallbookings()
	{
		
		Response resp = RestAssured.get("https://restful-booker.herokuapp.com/booking");
		
		System.out.println(resp.getStatusCode());
		
		resp.print();
		
		Assert.assertEquals(resp.getStatusCode(), 200);  //hard assertion
		
		List<Integer> bookingIDs = resp.jsonPath().getList("bookingid");
		
		Assert.assertFalse(bookingIDs.isEmpty());
		
		
		
	}
	
}
