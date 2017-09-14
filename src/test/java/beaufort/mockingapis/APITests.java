package beaufort.mockingapis;


import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class APITests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		get("http://demo3637982.mockable.io/").then().body("msg", equalTo("Hello World."));
	}

}
