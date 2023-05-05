package Lab_16;


import org.example.Lab_14.AllureListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.net.http.HttpClient;
import java.io.File;
import static io.restassured.RestAssured.given;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.UUID;

@Listeners({AllureListener.class})
public class ApiTest {
    private Properties properties = new Properties();

    @BeforeTest
    void init() throws IOException {
        properties.load(new FileReader(new File("src/main/resources/application.properties")));
    }

    @Test
    void crudTest(){
        String trelloKey = properties.getProperty("trello.key");
        String trelloToken = properties.getProperty("trello.token");
        String nameBoard = UUID.randomUUID().toString().substring(2,10);
        String idBoard = given().contentType("application/json").accept("application/json")
                .log().all().when().post("https://api.trello.com/1/boards/?" +
                "name=+"+ nameBoard +"&"+
                "key=" + trelloKey +"&" +
                "token=" + trelloToken)
                .then().assertThat().statusCode(200).extract().jsonPath().getString("id");

        String listName = UUID.randomUUID().toString().substring(3,10);

        String idList = given().contentType("application/json").accept("application/json")
                .log().all().when().post("https://api.trello.com/1/lists?" +
                        "key=" + trelloKey + "&" +
                        "token="+ trelloToken +"&" +
                        "name="+ listName +"&" +
                        "idBoard=" + idBoard)
                .then().assertThat().statusCode(200).extract().jsonPath().getString("id");

        String cardName = UUID.randomUUID().toString().substring(3,10);

        String idCard = given().contentType("application/json").accept("application/json")
                .log().all().when().post("https://trello.com/1/cards?" +
                        "key="+ trelloKey + "&" +
                        "token="+ trelloToken + "&" +
                        "idList="+idList+ "&" +
                        "name=" + cardName)
                .then().assertThat().statusCode(200).extract().jsonPath().getString("id");

        String labelName = UUID.randomUUID().toString().substring(3,10);
        String idLabel = given().contentType("application/json").accept("application/json")
                .log().all().when().post("https://api.trello.com/1/labels?" +
                        "key="+trelloKey+"&" +
                        "token="+trelloToken+"&" +
                        "idBoard="+ idBoard +"&" +
                        "name="+ labelName +"&" +
                        "color=red")
                .then().assertThat().statusCode(200).extract().jsonPath().getString("id");

        given().contentType("application/json").accept("application/json")
                .log().all().when().post("https://api.trello.com/1/cards/" +
                        idCard +"/" +
                        "idLabels?" +
                        "key="+ trelloKey +"&" +
                        "token="+trelloToken+"&" +
                        "value="+ idLabel)
                .then().assertThat().statusCode(200);

        given().contentType("application/json").accept("application/json")
                .log().all().when().put("https://api.trello.com/1/labels/" +
                        idLabel + "/" +
                        "color?" +
                        "key="+ trelloKey+"&" +
                        "token="+ trelloToken +"&" +
                        "value=blue")
                .then().assertThat().statusCode(200);

        given().contentType("application/json").accept("application/json")
                .log().all().when().delete("https://api.trello.com/1/cards/" +
                        idCard + "/" +
                        "idLabels/" +
                        idLabel + "?" +
                        "key="+ trelloKey +"&" +
                        "token=" + trelloToken)
                .then().assertThat().statusCode(200);
    }

    @Test
    public void ApiTestHttpRequest() throws URISyntaxException, IOException, InterruptedException {
        String nameBoard = UUID.randomUUID().toString().substring(2,10);
        String trelloKey = properties.getProperty("trello.key");
        String trelloToken = properties.getProperty("trello.token");
        HttpRequest createBoardRequest = (HttpRequest) HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL("https://api.trello.com/1/boards/?name="+nameBoard+"&key="+trelloKey+"&token=" + trelloToken).toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8)).build();
            HttpResponse createBoardResponse = HttpClient.newBuilder().build().send(createBoardRequest, HttpResponse.BodyHandlers.ofString());
            Assert.assertEquals(createBoardResponse.statusCode(), 200);

    }
}
