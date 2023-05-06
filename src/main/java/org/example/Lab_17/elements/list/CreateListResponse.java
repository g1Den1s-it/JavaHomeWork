package org.example.Lab_17.elements.list;


import lombok.Data;

@Data
public class CreateListResponse {
    private Integer statusCode;
    private TrelloList Body;
}
