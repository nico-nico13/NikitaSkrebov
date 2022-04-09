package com.epam.tc.hw10.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    private String code;
    private String col;
    private String len;
    private String pos;
    private String row;
    private String[] s;
    private String word;
}
