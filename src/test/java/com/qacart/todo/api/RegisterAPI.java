package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterAPI {

    private static List<Cookie> restAssuredCookies;
    private static String accessToken;
    private static String userID;
    private static String firstName;

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookies;
    }


    public void register(){
        User user = new UserUtils().generateRandomUser();

        Response response =
                given()
                    .baseUri("http://qacart-todo.herokuapp.com")
                    .header("Content-Type" , "application/json")
                    .body(user)
                        .log().all()
                .when()
                    .post(EndPoint.API_REGISTER_ENDPOINT)
                .then().log().all()
                    .extract().response();


        if(response.statusCode() != 201) {
            throw new RuntimeException("Something went wrong with the request");
        }

        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userID = response.path("userID");
        firstName = response.path("firstName");
    }
}
