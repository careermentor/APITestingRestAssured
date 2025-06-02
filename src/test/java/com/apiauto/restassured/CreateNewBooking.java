package com.apiauto.restassured;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNewBooking 
{

	@Test
	public void getallbookings()
	{
		
		//create JSON Body

		JSONObject body = new JSONObject();
		body.put("firstname","Shyam");
		body.put("lastname","Ram");
		body.put("price",43);
		body.put("depositpaid",false);

		JSONObject bookingDates = new JSONObject();
		bookingDates.put("checkin","2025-05-27");
		bookingDates.put("checkout","2025-05-28");
		body.put("bookingDates",bookingDates);
		
		body.put("additionalneeds", "Breakfast");
		
		Response resp = RestAssured.given().auth().preemptive().basic("admin","password123").contentType(ContentType.JSON).body(body).
				post("https://restful-booker.herokuapp.com/booking");
		
		System.out.println(resp.getStatusCode());
		
		resp.print();
		
		Assert.assertEquals(resp.getStatusCode(), 200);  //hard assertion
		
		
		
	}
	
}
