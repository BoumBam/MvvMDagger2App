package com.example.daag.model;

public class TestData {

    private String description;
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestData(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
