package com.api.stepdefinition;

import com.api.model.StudentDetailsDTO;
import com.api.utils.JsonReader;
import com.api.utils.ResponseHandler;
import com.api.utils.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UpdateStudentStepdefinition {
	private TestContext context;
	private static final Logger LOG = LogManager.getLogger(UpdateStudentStepdefinition.class);
	
	public UpdateStudentStepdefinition(TestContext context) {
		this.context = context;
	}

	@When("user creates a auth token with credential {string} & {string}")
	public void userCreatesAAuthTokenWithCredential(String username, String password) {
		JSONObject credentials = new JSONObject();
		credentials.put("username", username);
		credentials.put("password", password);
		context.response = context.requestSetup().body(credentials.toString())
				.when().post(context.session.get("endpoint").toString());
		String token = context.response.path("token");
		LOG.info("Auth Token: "+token);
		context.session.put("token", "token="+token);	
	}

	@When("user updates the details of a student")
	public void userUpdatesthedetailsofaStudent(DataTable dataTable) {
		Map<String,String> studentData = dataTable.asMaps().get(0);
		JSONObject studentBody = new JSONObject();
		studentBody.put("firstName", studentData.get("firstname"));
		studentBody.put("lastName", studentData.get("lastname"));
		studentBody.put("id", Integer.valueOf(studentData.get("id")));
		studentBody.put("nationality", (studentData.get("nationality")));
		studentBody.put("studentClass", (studentData.get("studentClass")));

		System.out.println("Update ID is "+ context.session.get("id"));

		context.response = context.requestSetup()
				.pathParam("id", context.session.get("id"))
				.body(studentBody.toString())
				.when().put("/updateStudent"+"/{id}");


	}
	

	
	@When("user updates the student details using data {string} from JSON file {string}")
	public void userUpdatesTheStudentDetailsUsingDataFromJSONFile(String dataKey, String JSONFile) {
		context.response = context.requestSetup()
				.header("Cookie", context.session.get("token").toString())
				.pathParam("studentID", context.session.get("id"))
				.body(JsonReader.getRequestBody(JSONFile,dataKey))
				.when().put(context.session.get("endpoint")+"/{studentID}");
		
		StudentDetailsDTO studentDetailsDTO = ResponseHandler.deserializedResponse(context.response, StudentDetailsDTO.class);
		assertNotNull("Student not created", studentDetailsDTO);
	}

	@When("user updates a student")
	public void userUpdatesAStudent(DataTable dataTable) {
		Map<String, String> studentData = dataTable.asMaps().get(0);
		JSONObject studentBody = new JSONObject();
		studentBody.put("firstName", studentData.get("firstname"));
		studentBody.put("lastName", studentData.get("lastname"));
		studentBody.put("id", Integer.valueOf(studentData.get("id")));
		studentBody.put("nationality", studentData.get("nationality"));
		studentBody.put("studentClass", studentData.get("studentClass"));

		context.response = context.requestSetup().body(studentBody.toString())
				.when().put(context.session.get("endpoint").toString());

	}
	

}
