package requests;

import org.testng.annotations.Test;

import com.mpokket.pojo.CreateEmpPOJO;
import com.mpokket.util.BaseAPIClass;
import com.mpokket.util.JsonUtil;
import com.mpokket.util.ResourcePath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetEmployeeAndValidateData extends BaseAPIClass{
	
	@Test
	public void getEmployeeAndValidateDataTest() {
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
		.get(ResourcePath.GET_SINGLE_EMPLOYEE)
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}

}
