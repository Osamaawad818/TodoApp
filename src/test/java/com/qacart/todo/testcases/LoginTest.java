package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login with email & password")
    @Description("It will login by filling the email and password and navigate to the todo page")
    @Test (description = "Test the Login functionality using Email & Password")
    public void shouldBeAbleToLoginWithEmailAndPassword(){

//        driver.get("http://qacart-todo.herokuapp.com/");

        LoginPage loginPage = new LoginPage(getDriver());
        boolean isMessageDisplayed =
                loginPage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .isWelcomeMessageDisplayed();
//        TodoPage todoPage = loginPage.login("hatem@example.com" , "123456");

//        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("hatem@example.com");
//        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("123456");
//        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();

//        TodoPage todoPage = new TodoPage(driver);

//        boolean isMessageDisplayed = todoPage.isWelcomeMessageDisplayed();
        Assert.assertTrue(isMessageDisplayed);
    }
}
