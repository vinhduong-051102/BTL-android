package com.example.myapplication.lcb;

// Subject.java
public class Subject {
    private String name;
    private String regularScore;
    private String detail;
    private String midtermScore;

    public Subject(String name, String regularScore, String detail, String midtermScore) {
        this.name = name;
        this.regularScore = regularScore;
        this.detail = detail;
        this.midtermScore = midtermScore;
    }

    public String getName() {
        return name;
    }

    public String getRegularScore() {
        return regularScore;
    }

    public String getDetail() {
        return detail;
    }

    public String getMidtermScore() {
        return midtermScore;
    }
}
