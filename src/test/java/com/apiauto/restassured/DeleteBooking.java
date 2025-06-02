package com.apiauto.restassured;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteBooking 
{

	@Test
	public void getallbookings()
	{
		
		
		
		Response resp = RestAssured.given().auth().preemptive().basic("admin","password").contentType(ContentType.JSON).
				delete("https://restful-booker.herokuapp.com/booking/1");
		
		System.out.println(resp.getStatusCode());
		
		resp.print();
		
		Assert.assertEquals(resp.getStatusCode(), 200);  //hard assertion
		
		
		
	}
	
}
