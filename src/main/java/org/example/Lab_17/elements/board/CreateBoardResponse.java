package org.example.Lab_17.elements.board;

import lombok.Data;

@Data
public class CreateBoardResponse {
    private Integer statusCode;
    private TrelloBoard Body;
}
