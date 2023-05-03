package org.example.Lab_5;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        //run JSON parser
        JSONParser jsonParser = new JSONParser();
        jsonParser.run();
        //run XML parser
        XMLParser xmlParser = new XMLParser();
        xmlParser.run();
    }
}