package com.skeletonhexa.domain.entities;

public class Equipo {
    private int id;
    private String name;
    private String yearfoundation;
    private String coach;
    public Equipo(int id, String name, String yearfoundation, String coach) {
        this.id = id;
        this.name = name;
        this.yearfoundation = yearfoundation;
        this.coach = coach;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getYearfoundation() {
        return yearfoundation;
    }
    public String getCoach() {
        return coach;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setYearfoundation(String yearfoundation) {
        this.yearfoundation = yearfoundation;
    }
    public void setCoach(String coach) {
        this.coach = coach;
    }

    
}
