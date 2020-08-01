package com.example.mijsmartmeter.Models;

public class InstantMo {
    private String details;
    private String value;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public InstantMo() {
    }

    public InstantMo(String details, String value) {
        this.details = details;
        this.value = value;
    }
}
