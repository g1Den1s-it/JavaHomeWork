package org.example.Lab_17.elements.card;

import lombok.Data;

@Data
public class CreateCardRequest {
    private String key;
    private String token;
    private String idList;
    private String name;
}
