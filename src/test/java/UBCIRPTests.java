import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

public class UBCIRPTests {

    private static final String  url = "https://api.github.com/gists";
    private static final String  token = "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";

    @Test
    public void firstTestCase() {

        JSONObject content = new JSONObject();
        content.put("content","UBC IRP Student QA!");

        JSONObject fileName = new JSONObject();
        fileName.put("ubc_irp.txt",content);

        JSONObject rootObject = new JSONObject();
        rootObject.put("files",fileName);

        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.body(rootObject.toJSONString());
        reqSpec.headers("Authorization","Bearer "+token,"Content-Type",
                "application/json",
                "Accept",
                "application/vnd.github.v3+json");

        Response response = RestAssured.given(reqSpec).log().all().and().when().post(url);

        ResponseBody body = response.getBody();

        System.out.println(response.getStatusCode());
        System.out.println(body.toString());

        Assert.assertEquals(201,response.getStatusCode());

    }

    @Test
    public void secondTestCase() {

        JSONObject content = new JSONObject();
        content.put("content","UBC IRP Student QA!");

        JSONObject fileName = new JSONObject();
        fileName.put("ubc_irp.txt",content);

        JSONObject rootObject = new JSONObject();
        rootObject.put("files",fileName);

        RequestSpecification reqSpec = RestAssured.given();

        // commented the body data
        //reqSpec.body(rootObject.toJSONString());
        reqSpec.headers("Authorization","Bearer "+token,"Content-Type",
                "application/json",
                "Accept",
                "application/vnd.github.v3+json");

        Response response = RestAssured.given(reqSpec).log().all().and().when().post(url);

        ResponseBody body = response.getBody();

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());

        System.out.println(body.prettyPrint());

        Assert.assertEquals(422,response.getStatusCode());

    }

    /*This test case is not complete. By Default, RestAssured sets the User-Agent Token
    and I need more clarification on it to override the default settings of RestAssured.
     */
    @Test
    public void thirdTestCase() {

        JSONObject content = new JSONObject();
        content.put("content","UBC IRP Student QA!");

        JSONObject fileName = new JSONObject();
        fileName.put("ubc_irp.txt",content);

        JSONObject rootObject = new JSONObject();
        rootObject.put("files",fileName);

        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.body(rootObject.toJSONString());
        reqSpec.headers("Authorization","Bearer "+token,
                "Content-Type","application/json",
                "User-Agent","RestAssured",
                "Accept", "application/vnd.github.v3+json");

        //requestSpecification.removeHeader("User-Agent");

        Response response = RestAssured.given(reqSpec).log().all().and().when().post(url);

        ResponseBody body = response.getBody();

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());

        System.out.println(body.prettyPrint());

        Assert.assertEquals(403,response.getStatusCode());

    }
}
