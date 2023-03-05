package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterAPI;
import com.qacart.todo.api.TasksAPI;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;



@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    @Story("All Todo")
    @Test (description = "Should be able to add a new TODO correctly")
    public void shouldBeAbleToAddNewTodo() {

        //To make an API call using Rest_Assured
        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.register();

        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();

        injectCookiesToBrowser(registerAPI.getRestAssuredCookies());

        String actualResult = newTodoPage
                .load()
                .addNewTask("Learn Selenium")
                .getTodoText();

        //2
//        String actualResult = todoPage
//                .load()
//                .clickOnPlusButton()
//                .addNewTask("Learn Selenium")
//                .getTodoText();

        //1
//        LoginPage loginPage = new LoginPage(driver);
//        String actualResult = loginPage
//                .load()
//                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
//                .clickOnPlusButton()
//                .addNewTask("Learn Selenium")
//                .getTodoText();

        //New TodoPage
//        newTodoPage.addNewTask("Learn Selenium");

        //TodoPage
//        String actualResult = todoPage.getTodoText();

        Assert.assertEquals(actualResult , "Learn Selenium");
    }

    @Story("Delete Todo")
    @Test (description = "Should be able to delete TODO correctly")
    public void shouldBeAbleToDeleteTodo () {

        //To make an API call using Rest_Assured
        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.register();

        TasksAPI tasksAPI = new TasksAPI();
        tasksAPI.addTask(registerAPI.getAccessToken());

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();

        injectCookiesToBrowser(registerAPI.getRestAssuredCookies());
        boolean isNoTodoMessageDisplayed = todoPage
                .load()
                .clickOnDeleteButton()
                .isNoTodoMessageDisplayed();
//        NewTodoPage newTodoPage = todoPage.clickOnPlusButton();

        //New TodoPage
//        newTodoPage.addNewTask("Learn Selenium");


//        todoPage.clickOnDeleteButton();

//        boolean isNoTodoMessageDisplayed = todoPage.isNoTodoMessageDisplayed();
        Assert.assertTrue(isNoTodoMessageDisplayed);
    }
}
