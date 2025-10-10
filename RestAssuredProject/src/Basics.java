import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;

public class Basics {

	public static void main(String[] args) {
		
		// This POST request creates a new resource with success and some assertions
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String post_response = given().log().all().queryParam("key","qaclick123").header("Content-type","application/json")
			.body(Payload.AddPlace())
			.when()
			.post("maps/api/place/add/json")
			.then()
			.assertThat().statusCode(200)
			.body("scope", equalTo("APP"))
			.header("server", "Apache/2.4.52 (Ubuntu)")
			.log().headers()
			.extract().response().asString();
				
		System.out.println(" POST response is " + post_response);
		
		JsonPath jsPost = new JsonPath(post_response);
		String placeId = jsPost.getString("place_id");
		System.out.println("place_id is " + placeId);
		
		// Update address via PUT request
		String newAddress = "50 spring walk, USA";
		
		String put_response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
			.body("{\n"
					+ "  \"place_id\":\"" + placeId + "\",\n"
					+ "  \"address\":\"" + newAddress + "\",\n"
					+ "  \"key\":\"qaclick123\"\n"
					+ "}")
			.when()
			.put("maps/api/place/update/json")
			.then().assertThat().log().all().statusCode(200)
			.body("msg", equalTo("Address successfully updated"))
			.extract().response().asString();
			
		System.out.println("PUT response is " + put_response);

		
		// Get request 
		String get_response = given().log().all().queryParam("key", "qaclick123")
			.queryParam("place_id", placeId)
			.when()
			.get("maps/api/place/get/json")
			.then().assertThat().log().all().statusCode(200)
			.extract().response().asString();
		
		JsonPath jsGet = new JsonPath(get_response);
		String actualAddress = jsGet.getString("address");
		System.out.println("actual address is " + actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);
		
		
	}

}
