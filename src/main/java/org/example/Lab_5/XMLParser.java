package org.example.Lab_5;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLParser {
    public void run() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        DateEntity xmlDate = xmlMapper.readValue(new File("input.xml"), DateEntity.class);
        System.out.println(xmlDate);

        xmlDate.setDate("2023-11-11");
        xmlDate.setEvent("Night party");

        String xmlToString = xmlMapper.writeValueAsString(xmlDate);
        FileWriter file1 = new FileWriter("output.xml");
        file1.write(xmlToString);
        file1.close();
    }
}
