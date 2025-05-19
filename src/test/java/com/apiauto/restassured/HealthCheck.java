package com.apiauto.restassured;

import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public class HealthCheck 
{

	@Test
	public void healthcheck()
	{
		given().
		when().
		get("https://restful-booker.herokuapp.com/ping").
		then().
		assertThat().statusCode(201);
		
		
	}
	
}
