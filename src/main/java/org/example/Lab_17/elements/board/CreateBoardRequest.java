package org.example.Lab_17.elements.board;

import lombok.Data;

@Data
public class CreateBoardRequest {
    private String name;
    private String token;
    private String key;
}
