package org.example.Lab_17.elements.label;

import lombok.Data;

@Data
public class CreateLabelRequest {
    private String key;
    private String token;
    private String name;
    private String idBoard;
    private String color;
}
