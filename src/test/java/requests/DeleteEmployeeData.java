package requests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.mpokket.pojo.CreateEmpPOJO;
import com.mpokket.util.JsonUtil;
import com.mpokket.util.ResourcePath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteEmployeeData {
	
	@Test
	public void deleteEmployeeDataTest() {
		CreateEmpPOJO createEmployeePOJO = new CreateEmpPOJO("koyal", "123", "23", 25);

		Response createEmployeeResponse = RestAssured.given()
				.contentType(ContentType.JSON)
				.when()
				.post(ResourcePath.CREATE_EMPLOYEE);
		createEmployeeResponse.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
		String id=JsonUtil.getJsonResponseValue(createEmployeeResponse, "data.id").toString();
		
		RestAssured.given()
		.pathParam("empid", Integer.parseInt(id))
		.delete(ResourcePath.DELETE_SINGLE_EMPLOYEE)
		.then()
		.assertThat().body("data.employee_name", Matchers.equalTo(createEmployeePOJO.getName()))
		.assertThat().statusCode(204)
		.log().all();
	}

}
