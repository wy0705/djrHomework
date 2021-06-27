package com.entity;

public class Pamht {
    private int id;
    private String name;
    private int score;

    public Pamht() {
    }

    public Pamht( String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Pamht(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
