package com.epam.tc.hw9;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import lombok.SneakyThrows;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestRunner {

    private RequestSpecification REQUEST_SPECIFICATION;

    private String BOARD_ID;
    private String LIST_ID;
    private String CARD_ID;

    private final String DOMAIN = "https://api.trello.com/1/";
    private final String BOARD_ENDPOINT = "boards/{id}";
    private final String LIST_ENDPOINT = "lists/{id}";
    private final String CARD_ENDPOINT = "cards/{id}";
    private final String NEW_BOARD_NAME = "NewBoard";
    private final String NEW_LIST_NAME = "NewList";
    private final String NEW_CARD_NAME = "NewCard";

    @SneakyThrows
    private Properties getProperties() {
        Properties props = new Properties();
        String propFileName = "test.properties";
        props.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        return props;
    }

    @BeforeMethod
    public void setUpBoardId() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Board");

        Response response = given(REQUEST_SPECIFICATION)
                .header("Content-Type","application/json")
                .body(requestParams.toJSONString())
                .post("boards")
                .then()
                .extract().response();
        BOARD_ID = response.jsonPath().getString("id");
    }

    @BeforeMethod
    public void setUpCardId() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("idList", LIST_ID);

        Response response = given(REQUEST_SPECIFICATION)
                .header("Content-Type","application/json")
                .body(requestParams.toJSONString())
                .post("cards")
                .then()
                .extract().response();
        CARD_ID = response.jsonPath().getString("id");
    }

    @BeforeMethod
    public void setUpBoardListId() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "List");
        requestParams.put("idBoard", BOARD_ID);

        Response response = given(REQUEST_SPECIFICATION)
                .header("Content-Type","application/json")
                .body(requestParams.toJSONString())
                .post("lists")
                .then()
                .extract().response();
        LIST_ID = response.jsonPath().getString("id");
    }


    @BeforeClass
    public void setup() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .addHeader("Authorization", getProperties().get("login").toString())
                .setBaseUri(DOMAIN)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    @AfterMethod
    void teardown() {
    }

    @Test(description = "Create a Board")
    public void createBoard() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Board");

        given(REQUEST_SPECIFICATION)
                .header("Content-Type","application/json")
                .body(requestParams.toJSONString())
                .post("boards")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(description = "Create a List on Board")
    void createList() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "List");
        requestParams.put("idBoard", BOARD_ID);

        given(REQUEST_SPECIFICATION)
                .header("Content-Type","application/json")
                .body(requestParams.toJSONString())
                .post("lists")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(description = "Create a Card")
    void createCard() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("idList", LIST_ID);

        given(REQUEST_SPECIFICATION)
                .header("Content-Type","application/json")
                .body(requestParams.toJSONString())
                .post("cards")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(description = "Get a Board")
    void getBoard() {
        given(REQUEST_SPECIFICATION)
                .pathParam("id", BOARD_ID)
                .when()
                .get(BOARD_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test(description = "Get a List")
    void getList() {
        given(REQUEST_SPECIFICATION)
                .pathParam("id", LIST_ID)
                .when()
                .get(LIST_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(description = "Get a Card")
    void getCard() {
        given(REQUEST_SPECIFICATION)
                .pathParam("id", CARD_ID)
                .when()
                .get(CARD_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(description = "Update a Board")
    void updateBoard() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", NEW_BOARD_NAME);

        given(REQUEST_SPECIFICATION)
                .pathParam("id", BOARD_ID)
                .header("Content-Type","application/json")
                .body(requestParams.toJSONString())
                .put(BOARD_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(NEW_BOARD_NAME));

    }

    @Test(description = "Update a List")
    void updateList() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", NEW_LIST_NAME);

        given(REQUEST_SPECIFICATION)
                .pathParam("id", LIST_ID)
                .header("Content-Type","application/json")
                .body(requestParams.toJSONString())
                .put(LIST_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(NEW_LIST_NAME));
    }

    @Test(description = "Update a Card")
    void updateCard() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", NEW_CARD_NAME);

        given(REQUEST_SPECIFICATION)
                .pathParam("id", CARD_ID)
                .header("Content-Type","application/json")
                .body(requestParams.toJSONString())
                .put(CARD_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(NEW_CARD_NAME));
    }

    @Test(description = "Delete a Board")
    public void deleteBoard() {
        given(REQUEST_SPECIFICATION)
                .pathParam("id", BOARD_ID)
                .when()
                .delete(BOARD_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(description = "Delete a Card")
    public void deleteCard() {
        given(REQUEST_SPECIFICATION)
                .pathParam("id", CARD_ID)
                .when()
                .delete(CARD_ENDPOINT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
