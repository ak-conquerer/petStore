package Tests;

import POJO.Request.Pets;
import TestData.PetsManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.logging.Logger;


public class PetsTest extends PetsManager {

    Logger logger = Logger.getLogger(PetsTest.class.getName());

    ArrayList listDogs = PetsManager.createPets();
    static String status;
    RequestSpecification requestSpecification = RestAssured.given().baseUri("https://petstore.swagger.io/v2").
            header("Content-Type", "application/json");
    @Test
    public void TC001_createPet1() {

        logger.info("Creating 1st Pet object");

        Pets pet = requestSpecification
                .header("Content-Type", "application/json")
                .body(listDogs.get(0))
                .when().post("/pet/").
                as(Pets.class);

        Assert.assertEquals(pet.getName(), "dog001");
        Assert.assertEquals(pet.getTags().get(0).getName(), "dog1Tag");


    }

      @Test
    public void TC002_createPet2() {

        logger.info("Creating 2nd Pet object");

        Pets pet = requestSpecification
                .body(listDogs.get(1))
                .when().post("/pet/").
                as(Pets.class);

        Assert.assertEquals(pet.getName(), "dog002");
        Assert.assertEquals(pet.getTags().get(0).getName(), "dog2Tag");

    }

     @Test
    public void TC003_createPet3() {

        logger.info("Creating 3rd Pet object");

        Pets pet = requestSpecification
                .body(listDogs.get(2))
                .when().post("/pet/").
                as(Pets.class);

        Assert.assertEquals(pet.getName(), "dog003");
        Assert.assertEquals(pet.getTags().get(0).getName(), "dog3Tag");
        status = pet.getStatus();

    }

    @Test

    public void TC004_updatePetsTest() {

        logger.info("Updating Pet with Available status");

        System.out.println("initial status is " + status);

        Pets updatePet = (Pets)listDogs.get(2);

        updatePet.setStatus("available");


        Response response =requestSpecification.body(updatePet)
                .when().put("/pet/")
                .then().extract().response();

        JsonPath js = new JsonPath(response.asString());
        System.out.println("response is for updated pet status " + js.get("status"));
        Assert.assertEquals(js.get("status"),"available");
        Assert.assertNotEquals(js.get("status"),"sold");
    }


    @Test
    public void TC005_getPetDetailsbyStatusTest () {

        logger.info("Getting Details of the pet updated above ");

        Response response = requestSpecification

                .when().get("/pet/findByStatus?status=available" )
                .then().extract().response();

        Assert.assertTrue(response.asString().contains("3333"));
    }
}


