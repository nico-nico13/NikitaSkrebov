package com.epam.tc.hw7.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jdiai.tools.DataClass;

import java.util.ArrayList;
import java.util.List;

public class TestData extends DataClass<TestData> {

    @JsonProperty("summary")
    private List<String> summary;

    private String odds;
    private String even;

    @JsonProperty("elements")
    private List<String> elements;

    @JsonProperty("color")
    private String color;

    @JsonProperty("metals")
    private String metals;

    @JsonProperty("vegetables")
    private List<String> vegetables;

    public TestData() {
    }

    public TestData(List<String> elements, String color, String metals,
                    List<String> vegetables, String odds, String even) {
        this.odds = odds;
        this.even = even;
        this.elements = elements;
        this.metals = metals;
        this.color = color;
        this.vegetables = vegetables;

    }

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public List<String> resultLogRows() {
        List<String> resultLogs = new ArrayList<>();
        int sum = Integer.parseInt(summary.get(0)) + Integer.parseInt(summary.get(1));
        String ele = String.join(", " , elements);
        String veg = String.join(", " , vegetables);
        resultLogs.add("Summary: " + sum);
        resultLogs.add("Elements: " + ele);
        resultLogs.add("Color: " + color);
        resultLogs.add("Metal: " + metals);
        resultLogs.add("Vegetables: " + veg);
        System.out.println(resultLogs);
        return resultLogs;
    }
}
