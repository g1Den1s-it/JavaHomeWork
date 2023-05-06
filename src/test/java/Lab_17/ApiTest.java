package Lab_17;


import org.example.Lab_17.bo.TrelloBO;
import org.example.Lab_17.elements.board.CreateBoardRequest;
import org.example.Lab_17.elements.board.CreateBoardResponse;
import org.example.Lab_17.elements.board.TrelloBoard;
import org.example.Lab_17.elements.card.CreateCardRequest;
import org.example.Lab_17.elements.card.CreateCardResponse;
import org.example.Lab_17.elements.label.CreateLabelRequest;
import org.example.Lab_17.elements.label.CreateLabelResponse;
import org.example.Lab_17.elements.list.CreateListRequest;
import org.example.Lab_17.elements.list.CreateListResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.UUID;

import static io.restassured.RestAssured.given;

//@Listeners({AllureListener.class})
public class ApiTest {
    private Properties properties = new Properties();

    @BeforeTest
    void init() throws IOException {
        properties.load(new FileReader(new File("src/main/resources/application.properties")));
    }

    @Test
    void crudTest() throws IOException, URISyntaxException, InterruptedException {
        String trelloKey = properties.getProperty("trello.key");
        String trelloToken = properties.getProperty("trello.token");
        String nameBoard = UUID.randomUUID().toString().substring(2,10);

        CreateBoardRequest createBoardRequest = new CreateBoardRequest();
        createBoardRequest.setName(nameBoard);
        createBoardRequest.setToken(trelloToken);
        createBoardRequest.setKey(trelloKey);

        TrelloBO trelloBO = new TrelloBO();

        CreateBoardResponse createBoardResponse = trelloBO.crateBoard(createBoardRequest);
        CreateBoardResponse expectedCreateBoardResponse = new CreateBoardResponse();

        expectedCreateBoardResponse.setBody(new TrelloBoard());
        expectedCreateBoardResponse.getBody().setName(nameBoard);
        expectedCreateBoardResponse.setStatusCode(200);

        //Assert.assertEquals(createBoardResponse, expectedCreateBoardResponse);


        //create list
        CreateListRequest createListRequest = new CreateListRequest();

        String listName = UUID.randomUUID().toString().substring(3,10);

        createListRequest.setIdBoard(createBoardResponse.getBody().getId());
        createListRequest.setName(listName);
        createListRequest.setKey(trelloKey);
        createListRequest.setToken(trelloToken);

        CreateListResponse createListResponse = trelloBO.createList(createListRequest);
        //test need
        //Assert.assertEquals(createBoardResponse, expectedCreateBoardResponse);


        //Create Card
        String cardName = UUID.randomUUID().toString().substring(3,10);
        CreateCardRequest createCardRequest = new CreateCardRequest();

        createCardRequest.setKey(trelloKey);
        createCardRequest.setToken(trelloToken);
        createCardRequest.setName(cardName);
        createCardRequest.setIdList(createListResponse.getBody().getId());

        CreateCardResponse createCardResponse = trelloBO.createCard(createCardRequest);
        //test need
        //Assert.assertEquals(createBoardResponse, expectedCreateBoardResponse);


        String labelName = UUID.randomUUID().toString().substring(3,10);
        CreateLabelRequest createLabelRequest = new CreateLabelRequest();

        createLabelRequest.setKey(trelloKey);
        createLabelRequest.setToken(trelloToken);
        createLabelRequest.setName(labelName);
        createLabelRequest.setColor("red");
        createLabelRequest.setIdBoard(createBoardResponse.getBody().getId());

        CreateLabelResponse createLabelResponse = trelloBO.creaetLabel(createLabelRequest);

        //connect label to card
        trelloBO.connectLable(createCardResponse,createLabelResponse.getBody().getId() ,trelloKey, trelloToken);


        //Update color label
        createLabelResponse = trelloBO.updateLabel(createLabelRequest, createLabelResponse);

        //Delete label
        trelloBO.deleteLabel(createCardResponse.getBody().getId(), createLabelResponse.getBody().getId(), trelloKey, trelloToken);



//        String labelName = UUID.randomUUID().toString().substring(3,10);
//        String idLabel = given().contentType("application/json").accept("application/json")
//                .log().all().when().post("https://api.trello.com/1/labels?" +
//                        "key="+trelloKey+"&" +
//                        "token="+trelloToken+"&" +
//                        "idBoard="+ idBoard +"&" +
//                        "name="+ labelName +"&" +
//                        "color=red")
//                .then().assertThat().statusCode(200).extract().jsonPath().getString("id");
//
//        given().contentType("application/json").accept("application/json")
//                .log().all().when().post("https://api.trello.com/1/cards/" +
//                        idCard +"/" +
//                        "idLabels?" +
//                        "key="+ trelloKey +"&" +
//                        "token="+trelloToken+"&" +
//                        "value="+ idLabel)
//                .then().assertThat().statusCode(200);
//
//        given().contentType("application/json").accept("application/json")
//                .log().all().when().put("https://api.trello.com/1/labels/" +
//                        idLabel + "/" +
//                        "color?" +
//                        "key="+ trelloKey+"&" +
//                        "token="+ trelloToken +"&" +
//                        "value=blue")
//                .then().assertThat().statusCode(200);
//
//        given().contentType("application/json").accept("application/json")
//                .log().all().when().delete("https://api.trello.com/1/cards/" +
//                        idCard + "/" +
//                        "idLabels/" +
//                        idLabel + "?" +
//                        "key="+ trelloKey +"&" +
//                        "token=" + trelloToken)
//                .then().assertThat().statusCode(200);
    }

//    @Test
//    public void ApiTestHttpRequest() throws URISyntaxException, IOException, InterruptedException {
//        String nameBoard = UUID.randomUUID().toString().substring(2,10);
//        String trelloKey = properties.getProperty("trello.key");
//        String trelloToken = properties.getProperty("trello.token");
//        HttpRequest createBoardRequest = (HttpRequest) HttpRequest.newBuilder()
//                .header("accept", "application/json")
//                .uri(new URL("https://api.trello.com/1/boards/?name="+nameBoard+"&key="+trelloKey+"&token=" + trelloToken).toURI())
//                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8)).build();
//            HttpResponse createBoardResponse = HttpClient.newBuilder().build().send(createBoardRequest, HttpResponse.BodyHandlers.ofString());
//            Assert.assertEquals(createBoardResponse.statusCode(), 200);
//
//    }
}
