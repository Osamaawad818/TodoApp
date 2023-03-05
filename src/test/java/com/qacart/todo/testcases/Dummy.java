package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterAPI;
import com.qacart.todo.objects.User;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Dummy {
    public static void main(String[] args) {

        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.register();

        System.out.println(registerAPI.getAccessToken());
        System.out.println(registerAPI.getUserID());
        System.out.println(registerAPI.getFirstName());


        //Given
        //When
        //Then
    }
}
