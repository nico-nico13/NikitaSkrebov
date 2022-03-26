//package com.epam.tc.hw7;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.FileReader;
//
//public class JsonParser {
//
//    public static void jsonParse() {
//
//        JSONParser parser = new JSONParser();
//
//        try {
//            JSONObject a = (JSONObject) parser.parse(new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json"));
//            for (JSONObject data : a) {
//
//
//            }
//
//            JSONObject data_1 = (JSONObject) a.get("data_1");
//
//            JSONArray summary1 = (JSONArray) data_1.get("summary");
//            for (Object s : summary1) {
//                System.out.println(s);
//            }
//
//            JSONArray elements = (JSONArray) data_1.get("elements");
//            for (Object e : elements) {
//                System.out.println(e);
//            }
//
//            String color = (String) data_1.get("color");
//            System.out.println(color);
//
//            String metals = (String) data_1.get("metals");
//            System.out.println(metals);
//
//            JSONArray vegetables1 = (JSONArray) data_1.get("vegetables");
//            for (Object v : vegetables1) {
//                System.out.println(v);
//            }
//
//
//        } catch (FileNotFoundException fileNotFoundException) {
//            fileNotFoundException.printStackTrace();
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        } catch (ParseException parseException) {
//            parseException.printStackTrace();
//        }
//    }
//}