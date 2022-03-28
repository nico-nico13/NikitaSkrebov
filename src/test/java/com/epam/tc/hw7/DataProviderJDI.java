package com.epam.tc.hw7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.epam.tc.hw7.entities.TestData;
import org.testng.annotations.DataProvider;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataProviderJDI {

    private static final String filePath = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";
    Object[][] objDataProv;

    @DataProvider
    public Object[][] dataForMetalColorTest() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            FileInputStream fileInputStream = new FileInputStream(filePath);

            HashMap<String, TestData> map = mapper.readValue(fileInputStream,
                    new TypeReference<HashMap<String, TestData>>() {
                    });
            int i = 0;
            objDataProv = new Object[map.size()][1];
            for (Map.Entry<String, TestData> entry : map.entrySet()) {
                objDataProv[i][0] = entry.getValue();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objDataProv;
    }
}