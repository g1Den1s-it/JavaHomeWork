package org.example.Lab_5;

import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSONParser {
    public  void run() throws IOException {
        JsonMapper jsonMapper = new JsonMapper();

        DateEntity jsonDate = jsonMapper.readValue(new File("input.json"), DateEntity.class);
        System.out.println(jsonDate);

        jsonDate.setDate("2023-11-11");
        jsonDate.setEvent("Night party");

        String jsonToString = jsonMapper.writeValueAsString(jsonDate);
        FileWriter file = new FileWriter("output.json");
        file.write(jsonToString);
        file.close();
    }
}
