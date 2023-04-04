package me.minikuma.chapter_01;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TicketPrice {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Reader readerInvoices = new FileReader("src/main/resources/chapter_01/invoices.json");
        Reader readerPlays = new FileReader("src/main/resources/chapter_01/plays.json");

        JSONArray invoices = (JSONArray) jsonParser.parse(readerInvoices);
        JSONObject plays = (JSONObject) jsonParser.parse(readerPlays);

        System.out.println(invoices);
        System.out.println(plays);
    }
}
