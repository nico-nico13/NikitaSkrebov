package com.epam.tc.hw10;

import com.epam.tc.hw10.DTO.TextDTO;
import com.epam.tc.hw10.DTO.TextsDTO;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.IntStream;

public class ParserJsonToDP {

    public String CheckTextDataJson = "src/test/resources/checkTextData.json";
    public String CheckTextsDataJson = "src/test/resources/checkTextsData.json";
    public Object[][] resultArray;

    public Object[][] parseFromJsonToDataProvider(String path) {

        Gson gson = new Gson();
        try {
            if (path.equals(CheckTextDataJson)) {
                TextDTO[] textDTO = gson.fromJson(new FileReader(path), TextDTO[].class);
                resultArray = new Object[textDTO.length][1];
                IntStream.range(0, textDTO.length).forEach(i -> resultArray[i][0] = textDTO[i]);
            }
            if (path.equals(CheckTextsDataJson)) {
                TextsDTO[] textsDTO = gson.fromJson(new FileReader(path), TextsDTO[].class);
                resultArray = new Object[textsDTO.length][1];
                IntStream.range(0, textsDTO.length).forEach(i -> resultArray[i][0] = textsDTO[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return resultArray;
    }
}
