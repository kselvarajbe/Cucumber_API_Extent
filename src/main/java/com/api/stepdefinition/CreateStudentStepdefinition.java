package com.api.stepdefinition;

import com.api.model.StudentDTO;
import com.api.utils.JsonReader;
import com.api.utils.ResponseHandler;
import com.api.utils.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateStudentStepdefinition {
	private TestContext context;
	private static final Logger LOG = LogManager.getLogger(CreateStudentStepdefinition.class);

	public CreateStudentStepdefinition(TestContext context) {
		this.context = context;
	}

	@When("user creates a student")
	public void userCreatesAStudent(DataTable dataTable) {
		Map<String,String> studentData = dataTable.asMaps().get(0);
		JSONObject studentBody = new JSONObject();
		studentBody.put("firstName", studentData.get("firstname"));
		studentBody.put("lastName", studentData.get("lastname"));
		studentBody.put("id", Integer.valueOf(studentData.get("id")));
		studentBody.put("nationality", studentData.get("nationality"));
		studentBody.put("studentClass", studentData.get("studentClass"));

		context.response = context.requestSetup().body(studentBody.toString())
				.when().post(context.session.get("endpoint").toString());

	}


	@When("user creates a student using data {string} from JSON file {string}")
	public void userCreatesAStudentUsingDataFromJSONFile(String dataKey, String JSONFile) {
		context.response = context.requestSetup().body(JsonReader.getRequestBody(JSONFile,dataKey))
				.when().post(context.session.get("endpoint").toString());


	}




}
