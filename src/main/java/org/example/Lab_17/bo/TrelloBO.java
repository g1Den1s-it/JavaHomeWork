package org.example.Lab_17.bo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.checkerframework.checker.units.qual.C;
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class TrelloBO {
    private String BASE_URL = "https://api.trello.com/";
    private ObjectMapper objectMapper = new ObjectMapper();

    public CreateBoardResponse crateBoard(CreateBoardRequest createBoardRequest) throws IOException, InterruptedException, URISyntaxException {

        HttpRequest httpRequest = (HttpRequest) HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(BASE_URL+"1/boards/?name="+
                        createBoardRequest.getName()+
                        "&key="+createBoardRequest.getKey()+
                        "&token=" + createBoardRequest.getToken()).toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8)).build();
        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 200);

        CreateBoardResponse createBoardResponse = new CreateBoardResponse();
        createBoardResponse.setStatusCode(httpResponse.statusCode());
        System.out.println("Board Response - " + httpResponse.body());
        TrelloBoard trelloBoard = objectMapper.readValue(httpResponse.body()+ "", TrelloBoard.class);
        createBoardResponse.setBody(trelloBoard);

        return createBoardResponse;
    }

    public CreateListResponse createList(CreateListRequest createListRequest) throws IOException, URISyntaxException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(BASE_URL +"1/lists?" +
                        "key=" + createListRequest.getKey() + "&" +
                        "token="+ createListRequest.getToken() +"&" +
                        "name="+ createListRequest.getName() +"&" +
                        "idBoard=" + createListRequest.getIdBoard()).toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 200);

        CreateListResponse res = new CreateListResponse();
        res.setStatusCode(httpResponse.statusCode());
        System.out.println("List Response - " + httpResponse.body());

        TrelloList trelloList = objectMapper.readValue(httpResponse.body() + "", TrelloList.class);
        res.setBody(trelloList);

        return res;
    }

    public CreateCardResponse createCard(CreateCardRequest createCardRequest) throws IOException, URISyntaxException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(BASE_URL +"1/cards?" +
                        "key="+ createCardRequest.getKey() +
                        "&token="+ createCardRequest.getToken() +
                        "&idList="+ createCardRequest.getIdList() +
                        "&name=" + createCardRequest.getName()).toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 200);

        CreateCardResponse res = new CreateCardResponse();
        res.setStatusCode(httpResponse.statusCode());
        System.out.println("Card Response - " + httpResponse.body());
        Card card = objectMapper.readValue(httpResponse.body() + "", Card.class);
        res.setBody(card);

        return res;
    }

    public CreateLabelResponse creaetLabel(CreateLabelRequest createLabelRequest) throws IOException, URISyntaxException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(BASE_URL+ "1/labels?" +
                        "key="+ createLabelRequest.getKey() +
                        "&token="+ createLabelRequest.getToken() +
                        "&idBoard="+ createLabelRequest.getIdBoard() +
                        "&name="+ createLabelRequest.getName() +
                        "&color=" + createLabelRequest.getColor()).toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 200);

        CreateLabelResponse res = new CreateLabelResponse();
        res.setStatusCode(httpResponse.statusCode());
        System.out.println("Label Response - "+ httpResponse.body());

        Label label = objectMapper.readValue(httpResponse.body() + "", Label.class);

        res.setBody(label);
        return res;
    }

    public CreateLabelResponse updateLabel(CreateLabelRequest createLabelRequest, CreateLabelResponse createLabelResponse) throws IOException, URISyntaxException, InterruptedException {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(BASE_URL + "1/labels/" +
                        createLabelResponse.getBody().getId() +
                        "/color" +
                        "?key="+ createLabelRequest.getKey() +
                        "&token="+createLabelRequest.getToken() +
                        "&value="+ "red").toURI())
                .PUT(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8)).build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 200);

        CreateLabelResponse res = new CreateLabelResponse();
        res.setStatusCode(httpResponse.statusCode());

        System.out.println("Update Label Response - "+ httpResponse.body());

        Label label = createLabelResponse.getBody();

        label = objectMapper.readValue(httpResponse.body() + "", Label.class);

        res.setBody(label);
        return res;
    }

    public void connectLable(CreateCardResponse createCardResponse, String idLabel, String key, String token) throws IOException, URISyntaxException, InterruptedException {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(BASE_URL + "1/cards/" +
                        createCardResponse.getBody().getId() +
                        "/idLabels" +
                        "?key="+ key +
                        "&token="+ token +
                        "&value=" + idLabel ).toURI())
                .POST(HttpRequest.BodyPublishers.ofString("", StandardCharsets.UTF_8))
                .build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 200);
    }

    public void deleteLabel(String idCard, String idLabel, String trelloKey, String trelloToken) throws IOException, URISyntaxException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(new URL(BASE_URL+
                        "1/cards/" +
                        idCard +
                        "/idLabels/" +
                        idLabel +
                        "?key="+ trelloKey +
                        "&token=" + trelloToken).toURI())
                .DELETE().build();

        HttpResponse httpResponse = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(httpResponse.statusCode(), 200);
    }
}
