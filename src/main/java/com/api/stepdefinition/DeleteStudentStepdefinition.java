package com.api.stepdefinition;

import com.api.utils.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.json.JSONObject;

import java.util.Map;

public class DeleteStudentStepdefinition {
	private TestContext context;

	public DeleteStudentStepdefinition(TestContext context) {
		this.context = context;
	}

	@When("user makes a request to delete student")
	public void userMakesARequestToDeletestudent() {
		context.response = context.requestSetup()
				.pathParam("id", context.session.get("id"))
				.when().delete(context.session.get("endpoint")+"/{id}");
	}

	@When("user deletes a student")
	public void userDeletesAStudent(DataTable dataTable) {
		Map<String, String> studentData = dataTable.asMaps().get(0);
		JSONObject studentBody = new JSONObject();
		studentBody.put("id", Integer.valueOf(studentData.get("id")));

		context.response = context.requestSetup().body(studentBody.toString())
				.when().delete(context.session.get("endpoint").toString());

	}
}
