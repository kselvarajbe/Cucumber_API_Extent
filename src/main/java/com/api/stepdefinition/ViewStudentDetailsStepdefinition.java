package com.api.stepdefinition;

import com.api.model.StudentID;
import com.api.utils.ResponseHandler;
import com.api.utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ViewStudentDetailsStepdefinition {
	private TestContext context;
	private static final Logger LOG = LogManager.getLogger(ViewStudentDetailsStepdefinition.class);
	
	public ViewStudentDetailsStepdefinition(TestContext context) {
		this.context = context;
	}

	@Given("user has access to endpoint {string}")
	public void userHasAccessToEndpoint(String endpoint) {		
		context.session.put("endpoint", endpoint);
	}

	@When("user makes a request to view student IDs")
	public void userMakesARequestToViewstudentIDs() {
		context.response = context.requestSetup().when().get(context.session.get("endpoint").toString());
		int id = context.response.getBody().jsonPath().getInt("[0].id");
		LOG.info("Student ID: "+id);
		assertNotNull("Student ID not found!", id);
		context.session.put("id", id);
	}

	@Then("user should get the response code {int}")
	public void userShouldGetTheResponseCode(Integer statusCode) {
		assertEquals(Long.valueOf(statusCode), Long.valueOf(context.response.getStatusCode()));
	}

	@Then("user should see all the student IDs")
	public void userShouldSeeAllTheStudentIDS() {
		StudentID[] studentIDs = ResponseHandler.deserializedResponse(context.response, StudentID[].class);
		assertNotNull("Student ID not found!!", studentIDs);
	}

	@When("user makes a request to view details of a student ID")
	public void userMakesARequestToViewDetailsOfStudentID() {
		LOG.info("Session StudentID: "+context.session.get("id"));
		context.response = context.requestSetup().pathParam("id", context.session.get("id"))
				.when().get(context.session.get("endpoint")+"/{id}");

	}


	

}
