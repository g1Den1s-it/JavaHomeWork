package Lab_17;


import org.example.Lab_17.bo.TrelloBO;
import org.example.Lab_17.elements.board.CreateBoardRequest;
import org.example.Lab_17.elements.board.CreateBoardResponse;
import org.example.Lab_17.elements.board.TrelloBoard;
import org.example.Lab_17.elements.card.Card;
import org.example.Lab_17.elements.card.CreateCardRequest;
import org.example.Lab_17.elements.card.CreateCardResponse;
import org.example.Lab_17.elements.label.CreateLabelRequest;
import org.example.Lab_17.elements.label.CreateLabelResponse;
import org.example.Lab_17.elements.label.Label;
import org.example.Lab_17.elements.list.CreateListRequest;
import org.example.Lab_17.elements.list.CreateListResponse;
import org.example.Lab_17.elements.list.TrelloList;
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

        expectedCreateBoardResponse.setStatusCode(200);
        expectedCreateBoardResponse.setBody(new TrelloBoard());
        expectedCreateBoardResponse.getBody().setName(nameBoard);

        //some test for board
        Assert.assertEquals(createBoardResponse.getBody().getName(), expectedCreateBoardResponse.getBody().getName());
        Assert.assertEquals(createBoardResponse.getStatusCode(), expectedCreateBoardResponse.getStatusCode());

        //create list
        CreateListRequest createListRequest = new CreateListRequest();

        String listName = UUID.randomUUID().toString().substring(3,10);

        createListRequest.setIdBoard(createBoardResponse.getBody().getId());
        createListRequest.setName(listName);
        createListRequest.setKey(trelloKey);
        createListRequest.setToken(trelloToken);

        CreateListResponse createListResponse = trelloBO.createList(createListRequest);
        CreateListResponse expectedCreateListResponse = new CreateListResponse();

        expectedCreateListResponse.setStatusCode(200);
        expectedCreateListResponse.setBody(new TrelloList());
        expectedCreateListResponse.getBody().setName(listName);
        expectedCreateListResponse.getBody().setIdBoard(createBoardResponse.getBody().getId());

        //test for list
        Assert.assertEquals(createListResponse.getStatusCode(), expectedCreateListResponse.getStatusCode());
        Assert.assertEquals(createListResponse.getBody().getName(), expectedCreateListResponse.getBody().getName());
        Assert.assertEquals(createListResponse.getBody().getIdBoard(), expectedCreateListResponse.getBody().getIdBoard());


        //Create Card
        String cardName = UUID.randomUUID().toString().substring(3,10);
        CreateCardRequest createCardRequest = new CreateCardRequest();

        createCardRequest.setKey(trelloKey);
        createCardRequest.setToken(trelloToken);
        createCardRequest.setName(cardName);
        createCardRequest.setIdList(createListResponse.getBody().getId());

        CreateCardResponse createCardResponse = trelloBO.createCard(createCardRequest);
        CreateCardResponse expectedCreateCardResponse = new CreateCardResponse();

        expectedCreateCardResponse.setStatusCode(200);
        expectedCreateCardResponse.setBody(new Card());
        expectedCreateCardResponse.getBody().setName(cardName);
        expectedCreateCardResponse.getBody().setIdList(createListResponse.getBody().getId());
        expectedCreateCardResponse.getBody().setIdBoard(createBoardResponse.getBody().getId());

        //test for Card
        Assert.assertEquals(createCardResponse.getStatusCode(), expectedCreateCardResponse.getStatusCode());
        Assert.assertEquals(createCardResponse.getBody().getName(), expectedCreateCardResponse.getBody().getName());
        Assert.assertEquals(createCardResponse.getBody().getIdBoard(), expectedCreateCardResponse.getBody().getIdBoard());
        Assert.assertEquals(createCardResponse.getBody().getIdList(), expectedCreateCardResponse.getBody().getIdList());




        //create label
        String labelName = UUID.randomUUID().toString().substring(3,10);
        CreateLabelRequest createLabelRequest = new CreateLabelRequest();

        createLabelRequest.setKey(trelloKey);
        createLabelRequest.setToken(trelloToken);
        createLabelRequest.setName(labelName);
        createLabelRequest.setColor("red");
        createLabelRequest.setIdBoard(createBoardResponse.getBody().getId());

        CreateLabelResponse createLabelResponse = trelloBO.creaetLabel(createLabelRequest);
        CreateLabelResponse expectedCreateLabelResponse = new CreateLabelResponse();

        expectedCreateLabelResponse.setStatusCode(200);
        expectedCreateLabelResponse.setBody(new Label());
        expectedCreateLabelResponse.getBody().setName(labelName);
        expectedCreateLabelResponse.getBody().setIdBoard(createBoardResponse.getBody().getId());
        expectedCreateLabelResponse.getBody().setColor("red");

        //test for label
        Assert.assertEquals(createLabelResponse.getStatusCode(), expectedCreateLabelResponse.getStatusCode());
        Assert.assertEquals(createLabelResponse.getBody().getName(), expectedCreateLabelResponse.getBody().getName());
        Assert.assertEquals(createLabelResponse.getBody().getColor(), expectedCreateLabelResponse.getBody().getColor());
        Assert.assertEquals(createLabelResponse.getBody().getIdBoard(), expectedCreateLabelResponse.getBody().getIdBoard());


        //connect label to card
        trelloBO.connectLable(createCardResponse,createLabelResponse.getBody().getId() ,trelloKey, trelloToken);


        //Update color label
        createLabelResponse = trelloBO.updateLabel(createLabelRequest, createLabelResponse);

        //Delete label
        trelloBO.deleteLabel(createCardResponse.getBody().getId(), createLabelResponse.getBody().getId(), trelloKey, trelloToken);
    }
}
