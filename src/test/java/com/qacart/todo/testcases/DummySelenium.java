package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterAPI;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DummySelenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        driver.manage().window().maximize();

//        Cookie accessTokenCookie = new Cookie("access_token" ,
//                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYzZTJhMjAwMmYxNDA1MDAxNGYyMWI2YSIsImZpcnN0TmFtZSI6Ik9zYW1hIiwibGFzdE5hbWUiOiJBd2FkIiwiaWF0IjoxNjc1Nzk2OTkyfQ.5rZ4uhQZX79Bcf-T4xEvV9Jf60hujQD5f1KTvHGQopo");
//        Cookie firstNameCookie = new Cookie("firstName" , "Osama");

        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.register();
        List<Cookie> restAssuredCookies = registerAPI.getRestAssuredCookies();
        for(Cookie cookie : restAssuredCookies){
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.getName() , cookie.getValue());
            driver.manage().addCookie(seleniumCookie);
        }

//        driver.manage().addCookie(accessTokenCookie);

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        Thread.sleep(6000);

        driver.quit();
    }
}
