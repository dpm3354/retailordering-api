package beaufort.mockingapis;

import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class APITests {

	final static String mockableBaseUrl = "http://demo3637982.mockable.io/";
	final static String mocklabBaseUrl = "http://bftft.mocklab.io/";

	String baseUrl = mockableBaseUrl;

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void purchase_receiptExistsTest() {
		post(baseUrl + "purchase").then().body("receipt", notNullValue());
	}

	@Test
	public void purchase_receiptIncludesSkuTest() {
		given().
			param("sku", "12345678").
		when().
			post(baseUrl + "purchase").
		then().
			body("receipt.sku", equalTo("12345678"));
	}

	@Test
	public void purchase_receiptIncludesPriceTest() {
		given().
			param("sku", "12345678").
			param("paymentType", "cash").
		when().
			post(baseUrl + "purchase").
		then().
			body("receipt.price", equalTo("$12.00"));
	}

	@Test
	public void purchase_receiptIncludesPaymentTypeTest() {
		given().
			param("sku", "12345678").
			param("paymentType", "cash").
		when().
			post(baseUrl + "purchase").
		then().
			body("receipt.paymentType", equalTo("cash"));
	}

}
