package Tests;

import POJO.Request.UserArray;
import TestData.UserManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

public class UserTest extends UserManager {
    ArrayList<UserArray> arrayList = UserManager.createUserArray();
    Logger logger = Logger.getLogger(UserTest.class.getName());
    String userToBeUpdated = "user002";
    String newUserNameUpdated = "usernew002";

    RequestSpecification requestSpecification = RestAssured.given().baseUri("https://petstore.swagger.io/v2").
            header("Content-Type", "application/json");

    @Test(priority = 1)
    public void createUser() {

        logger.info("Creating user array for 3 user data");

        Response response =requestSpecification
                .body(arrayList)
                .when().post("/user/createWithArray").
                then().extract().response();

        JsonPath js = new JsonPath(response.body().asString());
        Assert.assertEquals(js.get("message"),"ok");
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test(priority = 2)
    public void updateUser() {

        logger.info("Updating userName for user -  userName002");

        for(int i=0;i<arrayList.size();i++) {
            if (arrayList.get(i).getUsername().equals(userToBeUpdated)) {
                arrayList.get(i).setUsername(newUserNameUpdated);
                System.out.println("in loop for ..." + i);

                Response response =requestSpecification
                        .body(arrayList.get(i))
                        .when().put("/user/" + userToBeUpdated).
                        then().extract().response();

                System.out.println("response is for update " + response.asString());

                Assert.assertEquals(response.statusCode(),200);

            }
        }

    }

    @Test(priority = 3)
    public void getUserDetails() {
        logger.info("Getting details for the updated user");

        Response response = requestSpecification
                .when().get("/user/"+ newUserNameUpdated).
                then().extract().response();
        System.out.println("response is " + response.asString());

        Assert.assertEquals(response.statusCode(),200);
       JsonPath js = new JsonPath(response.body().asString());

       Assert.assertEquals(js.get("username"),newUserNameUpdated);
       Assert.assertEquals(js.get("firstName"),"FUser2");


    }
}
