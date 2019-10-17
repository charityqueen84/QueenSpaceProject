package com.example.QueenSpaceProject.models;

public class Facts {
    private String fact;
    private int id;


    public Facts(int id, String fact) {
        this.id = id;
        this.fact = fact;

    }
    public String getFact() {
        return fact;
    }
    public int getId() {
        return id;
    }
}

