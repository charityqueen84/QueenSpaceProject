package com.example.QueenSpaceProject.models;

public class Facts {
    private String fact; //add source category later? So I can name my info source (Ex: NASA)

    public Facts(String fact) {
        this.fact = fact;
    }
    public String getFact() {
        return fact;
    }
}
