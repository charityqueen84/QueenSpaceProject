package com.example.QueenSpaceProject.models;

public class Facts {
    private String fact; //add source category later? So I can name my info source (Ex: NASA)



    private  int id; //do I need id?

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
