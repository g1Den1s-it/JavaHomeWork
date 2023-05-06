package org.example.Lab_17.elements.list;


import lombok.Data;

@Data
public class TrelloList {
    private String id;
    private String name;
    private Boolean closed;
    private String idBoard;
    private Integer pos;
    private Object status;
    private Object limits;
}
