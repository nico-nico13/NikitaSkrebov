package com.epam.tc.hw10.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextDTO {

    private String text;
    private String lang;
    private String options;
    private String word;
    private String s;
    private String code;
}
