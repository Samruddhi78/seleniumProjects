package ContinuumTraining.CucumberPractice.stepDefinitions;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Parameters;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.config.ParamConfig.UpdateStrategy;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class ReqResAPI {
	String url = "";
	private static Response response = null;
	private static String error = null;

	public static final int OK_SATUS_CODE = 200;
	public static final int OK_SATUS_CREATED = 201;
//public static final int OK_SATUS_CODE=200;

	@Given("send get request to get all users$")
	public void send_get_request_to_get_all_users() {
		response = RestAssured.get("https://reqres.in/api/users/");
	}

	@Given("verify if response contains userCount$")
	public void verify_if_response_contains_user_count() {
		Assert.assertEquals(response.getStatusCode() == OK_SATUS_CODE, "URL is not working");

		JSONObject res = new JSONObject(response.asString());
		if (res.getInt("total") != 12) {
			System.out.println("wrong url, user count is not 12 ,  response user count is" + res.getInt("total"));
		}

	}

	@Given("^I send put request depending on (.*) and change first name to (.*)$")
	public void i_send_put_request_depending_on_id_and_change_first_name_to(int id, String name) {
		JSONObject updatedData = new JSONObject();
		updatedData.put("first_name", name);

		response = RestAssured.given().queryParam("id", id).contentType(ContentType.JSON).body(updatedData).when()
				.put("https://reqres.in/api/users/");

	}

	@Given("^I verify if the data is changed (.*) (.*)$")
	public void i_verify_if_the_data_is_changed_ian(Integer id, String name) {
		if (response.getStatusCode() != OK_SATUS_CODE) {
			error = response.then().extract().asString() + "   " + response.getStatusCode();
			System.out.println("API to update user info is giving error  " + error);
		}

		else {
			String res = response.asString();
			if (res.contains("updatedAt")) {
				System.out.println("user info is successfully updated ");
			} else
				System.out.println("Not updated");
		}

	}

	@Given("^I send post request and create new user (.*) (.*) (.*) (.*)$")
	public void i_send_post_request_and_create_new_user_(String first_name, String last_name, String email,
			String avatar) {
		JSONObject data = new JSONObject();
		data.put("first_name", first_name);
		data.put("last_name", last_name);
		data.put("email", email);
		data.put("avatar", avatar);

		response = RestAssured.given().contentType(ContentType.JSON).body(data).when()
				.post("https://reqres.in/api/users/");

	}

	@Given("^I verify if the user is created$")
	public void i_verify_if_the_user_is_created() {
		if (response.getStatusCode() != OK_SATUS_CREATED) {
			error = response.then().extract().asString() + "   " + response.getStatusCode();
			System.out.println("API to create user is giving error  " + error);
		} else {
			String res = response.asString();
			if (res.contains("createdAt")) {
				System.out.println("user is successfully created ");
			} else
				System.out.println("Not created");
		}
	}

	@Given("^I send delete request depending on (.*)$")
	public void i_send_delete_request_depending_on(Integer id) {
		ValidatableResponse response = RestAssured.given().queryParam("id", id).contentType(ContentType.JSON).when()
				.delete("https://reqres.in/api/users/").then().assertThat().statusCode(204);
		System.out.println("the response is  " + response.toString());
	}

	@Given("^I send get request to get detail of  user named (.*)$")
	public void i_send_get_request_to_get_user_first_named_michael(String name) {

		response = RestAssured.given().when().get("http://reqres.in/api/users/");
		System.out.println("response " + response.asString());
		Assert.assertTrue("URL is not working", response.getStatusCode() == OK_SATUS_CODE);

		JSONObject resp = new JSONObject(response.asString());
		int total_page = resp.getInt("total_pages");
		int per_page = resp.getInt("per_page");
		int pageNo = 1;
		while (pageNo <= total_page) {
			JSONArray data = resp.getJSONArray("data");
			for (int i = 0; i < per_page; i++) {
				JSONObject res = (JSONObject) data.get(i);
				if (res.getString("first_name").equals(name)) {
					System.out.println("the id is " + res.getInt("id"));
					System.out.println("the email is " + res.getString("email"));
					System.out.println("the last_name is " + res.getString("last_name"));
					System.out.println("the avatar is " + res.getString("avatar"));
					return;
				}
			}
			pageNo++;
			response = RestAssured.given().when().get("https://reqres.in/api/users?page=" + pageNo);
			Assert.assertTrue("URL is not working", response.getStatusCode() == OK_SATUS_CODE);
			resp = new JSONObject(response.asString());
		}

	}
}
