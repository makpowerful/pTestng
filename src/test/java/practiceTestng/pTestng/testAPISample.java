package practiceTestng.pTestng;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;

public class testAPISample {

	public static String body = """
						{
			  "location": {
			    "lat": -38.383494,
			    "lng": 33.427362
			  },
			  "accuracy": 50,
			  "name": "Frontline house",
			  "phone_number": "(+91) 983 893 3937",
			  "address": "29, side layout, cohen 09",
			  "types": [
			    "shoe park",
			    "shop"
			  ],
			  "website": "http://google.com",
			  "language": "French-IN"
			}

						""";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseuri = "https://rahulshettyacademy.com/";
		String path = "maps/api/place/add/json";
		String response1 = given()
				.baseUri(baseuri)
				.header("Content-Type", "application/json")
				.queryParam("key", "qaclick123")
				.body(body)
				.when().post(path)
				.then()
				.assertThat().statusCode(200)
				.extract().asString();
		
		System.out.println(response1);
		
		JSONObject js = new JSONObject(response1);
		String scopeval = js.getString("scope");
		System.out.println(scopeval);
		

	}

}
