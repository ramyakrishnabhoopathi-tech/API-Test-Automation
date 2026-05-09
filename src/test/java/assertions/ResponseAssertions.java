package assertions;

import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseAssertions {

    public static void validateStatusCode(
            Response response,
            int expectedStatus){

        Assert.assertEquals(
                response.statusCode(),
                expectedStatus);
    }

    public static void printFirstName(
            Response response){

        String firstName =
                response.jsonPath()
                        .getString("data.first_name");

        System.out.println(
                "First Name: " + firstName);

        Assert.assertNotNull(firstName);
    }

    public static void printAvatar(
            Response response){

        String avatar =
                response.jsonPath()
                        .getString("data.avatar");

        System.out.println(
                "Avatar URL: " + avatar);

        Assert.assertNotNull(avatar);
    }
}