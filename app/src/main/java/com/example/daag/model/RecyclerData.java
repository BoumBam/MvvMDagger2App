package com.example.daag.model;

public class RecyclerData {

    private String name;
    private String description;
    private Owner owner;

    public RecyclerData(String name, String description, Owner owner) {
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Owner getOwner() {
        return owner;
    }

}
