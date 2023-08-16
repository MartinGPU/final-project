package com.marat.back.tests;

import com.marat.allure.JiraIssue;
import com.marat.allure.JiraIssues;
import com.marat.allure.Layer;
import com.marat.back.model.LombokUserData;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.marat.back.specs.Specs.request;
import static com.marat.back.specs.Specs.response200;
import static com.marat.back.specs.Specs.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("API")
@Feature("Operations with user's acc")
public class ApiTests {

    @AllureId("25326")
    @JiraIssues({@JiraIssue("")})
    @Tag("back")
    @Test
    @Step("Get user")
    public void getSingleUser() {
        LombokUserData data = given()
                        .spec(request)
                        .when()
                        .get("/users/2")
                        .then()
                        .spec(response200)
                        .log().body()
                        .extract().as(LombokUserData.class);
        assertEquals(2, data.getUser().getId());
        assertEquals("janet.weaver@reqres.in", data.getUser().getEmail());
        assertEquals("Janet", data.getUser().getFirstName());
        assertEquals("Weaver", data.getUser().getLastName());
    }

    @AllureId("25327")
    @JiraIssues({@JiraIssue("")})
    @Tag("back")
    @Test
    @Step("Create user")
    public void createUser() {
        given()
                .spec(request)
                .body("{\"name\": \"Donatello\", \"job\": \"peace maker\"}")
                .when()
                .post("/users")
                .then()
                .spec(response201)
                .body("name", is("Donatello"))
                .body("job", is("peace maker"));
 }

    @AllureId("25328")
    @JiraIssues({@JiraIssue("")})
    @Tag("back")
    @Test
    @Step("Update user")
    public void updateUserData() {
        given()
                .spec(request)
                .body("{\"name\": \"Donald\", \"job\": \"teacher\"}")
                .when()
                .put("/users/2")
                .then()
                .spec(response200)
                .body("name",  is("Donald"))
                .body("job",  is("teacher"));
    }

    @AllureId("25329")
    @JiraIssues({@JiraIssue("")})
    @Tag("back")
    @Test
    @Step("Drop user")
    public void dropUserData() {
        given()
                .spec(request)
                .body("{\"name\": \"Donald\", \"job\": \"teacher\"}")
                .when()
                .delete("/users/2")
                .then()
                .spec(response204);
    }

    @AllureId("25330")
    @JiraIssues({@JiraIssue("")})
    @Tag("back")
    @Test
    @Step("User registration")
    public void userRegistration() {
        given()
                .spec(request)
                .body("{\"email\": \"rachel.howell@reqres.in\", \"password\": \"lineage\"}")
                .when()
                .post("/register")
                .then()
                .spec(response200)
                .body("id",  is(12))
                .body("token",  is("QpwL5tke4Pnpja7X12"));
    }

    @AllureId("25331")
    @JiraIssues({@JiraIssue("")})
    @Tag("back")
    @Test
    @Step("User authorization")
    public void userAuth() {
        given()
                .spec(request)
                .body("{\"email\": \"rachel.howell@reqres.in\", \"password\": \"lineage\"}")
                .when()
                .post("/login")
                .then()
                .spec(response200)
                .body("token",  is("QpwL5tke4Pnpja7X12"));
    }
}
