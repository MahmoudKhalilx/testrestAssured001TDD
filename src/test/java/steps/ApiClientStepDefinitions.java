package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import steps.POJO.BodyModeling.ApiClient.ApiClientRequest;
import steps.POJO.BodyModeling.ApiClient.ApiClientResponse;
import steps.POJO.BodyModeling.Book.Book;

import javax.swing.*;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiClientStepDefinitions {
//    private ApiClientRequest request;
//    private Response response;

    private ApiClientRequest request;
    private Response response;
    private String accessToken;
    private int bookId;

    @Given("I have a new API client request ClientName {string} and ClientEmail {string}")
    public void iHaveANewAPIClientRequestClientNameAndClientEmail(String ClientName, String ClientEmail) {

        request = new ApiClientRequest();
        request.setClientName(ClientName+"_" + System.currentTimeMillis());
        request.setClientEmail(System.currentTimeMillis()+ "_" + ClientEmail);
    }

    @When("I send a POST request to create an API client")
    public void i_send_a_post_request_to_create_an_api_client() {
        response = given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/api-clients/");
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode.intValue());
    }

    @Then("the response should contain an access token")
    public void the_response_should_contain_an_access_token() {
        ApiClientResponse apiClientResponse = response.as(ApiClientResponse.class);
        Assert.assertNotNull(apiClientResponse.getAccessToken());
        Assert.assertFalse(apiClientResponse.getAccessToken().isEmpty());
    }





    //  Scenario: Get List of Books by type

   // private Response booksResponse;

    @When("I send a GET request to fetch {string} books")
    public void iSendAGETRequestToFetchBooks(String type) {
        response = given()
                .queryParam("type", type)
                .when()
                .get("/books");

    }

    @Then("the response should contain a list of {string} books")
    public void the_response_should_contain_a_list_of_non_fiction_books(String type) {
        List<Book> books = response.jsonPath().getList("", Book.class);
        Assert.assertFalse(books.isEmpty(), "The list of books should not be empty");
        books.forEach(book -> {
            Assert.assertEquals(book.getType(), type, "All books should be " + type);
        });
    }



//  Scenario: Retrieve a specific book


    @When("^I send a GET request to fetch book with ID (\\d+)$")
    public void iSendAGetRequestToFetchBookWitId(int bookId) {
        response = given()
                .when()
                .get("/books/" + bookId);
    }



    @Then("the response should contain details of the requested book")
    public void the_response_should_contain_details_of_the_requested_book() {
        Book book = response.as(Book.class);

            Assert.assertNotNull(book, "Book should not be null");
            Assert.assertEquals(book.getId(), 1, "Book ID should be 1");
            Assert.assertNotNull(book.getName(), "Book name should not be null");
            Assert.assertNotNull(book.getAuthor(), "Book author should not be null");
            Assert.assertNotNull(book.getType(), "Book type should not be null");
        Assert.assertFalse(book.getName().isEmpty(), "Book name should not be empty");
        Assert.assertFalse(book.getAuthor().isEmpty(), "Book author should not be empty");
        Assert.assertFalse(book.getType().isEmpty(), "Book type should not be empty");


    }

    @Then("I store the access token from the response")
    public void i_store_the_access_token_from_the_response() {
        accessToken = response.jsonPath().getString("accessToken");
        Assert.assertNotNull(accessToken, "Access token should not be null");
    }
}
