package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.allOf;

@QuarkusTest
public class PetResourceTest {

	/**
	 * Test Pet ArrayList work accordingly
	 */
	@Test
    public void testPetEndpoint() {
        given()
          .when().get("/v1/pets")
          .then()
             .statusCode(200);
    }
	/**
	 * Test negative ids cannot be search in Pet Model
	 */
	@Test
	public void testNegativeIdsAvoid() {
		given()
        .when().get("/v1/pets/-1")
        .then()
           .statusCode(404);
	}
	/**
	 * Check Pet Types can access successfully
	 */
	@Test
	public void testPetTypeEndpoint() {
		given()
        .when().get("/v1/petType")
        .then()
           .statusCode(200);
	}

}