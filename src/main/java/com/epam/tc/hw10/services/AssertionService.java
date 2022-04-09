package com.epam.tc.hw10.services;

import com.epam.tc.hw10.DTO.ResponseDTO;
import com.epam.tc.hw10.DTO.TextDTO;
import com.epam.tc.hw10.DTO.TextsDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionService {

    public AssertionService checkErrorCode(ResponseDTO[] response, TextDTO textDTO) {

        if (response.length != 0) {
            assertEquals(response[0].getCode(), textDTO.getCode(), "Invalid error code!");
            return this;
        }
        System.out.println("Empty response");
        return null;
    }

    public AssertionService checkIncorrectWord(ResponseDTO[] response, TextDTO textDTO) {

        if (response.length != 0) {
            assertEquals(response[0].getWord(), textDTO.getWord(), "Incorrect word!");
            return this;
        }
        System.out.println("Empty response");
        return null;
    }

    public AssertionService checkResponseFixedWord(ResponseDTO[] response, TextDTO textDTO) {

        List<String> list = Arrays.asList(response[0].getS());
        assertTrue(list.contains(textDTO.getS()), "Incorrect fixed word!");
        return this;
    }

    public AssertionService checkLength(ResponseDTO[] response, TextDTO textDTO) {


        assertEquals(Integer.parseInt(response[0].getLen()), textDTO.getText().length(), "Incorrect length!");
        return this;
    }

    public AssertionService checkAllIncorrectWords(ResponseDTO[][] response, TextsDTO textsDTO) {

        if (response.length != 0) {
            IntStream.range(0, response[0].length).forEach(i -> {
                List<ResponseDTO[]> listDTO = Arrays.asList(response);
                List<String> list = Collections.singletonList(listDTO.get(0)[i].getWord());
                String incorrectWord = textsDTO.getWord()[i];
                assertTrue(list.contains(incorrectWord), "Incorrect words!");
            });
            return null;
        }
        System.out.println("Empty response");
        return null;
    }
}
