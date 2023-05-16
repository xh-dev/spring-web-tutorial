package org.example.web.service;

public class CompoentB {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName(){
        return String.format("component B (%s)", key);
    }
}
