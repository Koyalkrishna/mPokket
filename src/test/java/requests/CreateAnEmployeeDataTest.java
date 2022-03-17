package requests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mpokket.pojo.CreateEmpPOJO;
import com.mpokket.util.BaseAPIClass;
import static com.mpokket.util.JsonUtil.*;
import com.mpokket.util.ResourcePath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAnEmployeeDataTest extends BaseAPIClass{
	
	@Test
	public void createAnNewEmployeeData() {
		CreateEmpPOJO createEmployeePOJO = new CreateEmpPOJO("koyal", "123", "23", 25);

		Response createEmployeeResponse = RestAssured.given()
				.contentType(ContentType.JSON)
				.when()
				.post(ResourcePath.CREATE_EMPLOYEE);
		createEmployeeResponse.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
		String status=getJsonResponseValue(createEmployeeResponse, "status").toString();
		Assert.assertEquals(status, "success");
		String name=getJsonResponseValue(createEmployeeResponse, "data.name").toString();
		Assert.assertEquals(name, createEmployeePOJO.getName());
		String salary=getJsonResponseValue(createEmployeeResponse, "data.salary").toString();
		Assert.assertEquals(salary, createEmployeePOJO.getSalary());
	}

}
