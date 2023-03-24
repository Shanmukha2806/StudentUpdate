package com.studentupdate;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StudentUpdateApplicationTests {

	@Test
    @Order(1)
    public void testAddStudents() {
    	String jsonbody="{\"student_firstname\":\"Meghana\",\"student_lastname\":\"'Chinchinada'\",\"student_email\":\"'maggi@gmail.com'.com\",\"dob\":\"'2001/03/05'\",\"student_password\":\"Maggi\",\"student_class\":\"6\",\"gender\":\"'Female'\",\"fathername\":\"Mohan\",\"mothername\":\"Lakshmi\",\"fees\":\"false\",\"teacher_email\":\"veena@gmail.com\"}";
        String res=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .put("http://localhost:8087/api/student/maggi@gmail.com")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
	
}
