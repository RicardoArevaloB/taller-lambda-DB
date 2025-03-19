package com.skeletonhexa.domain.entities;

public class Jugadores {
    private int id;
    private int equipo_id;
    private String dorsal;
    private String name;
    private String nationality;
    private String age;
    private String height;
    private String weight;
    private String position;
    public Jugadores(int id, int equipo_id, String dorsal, String name, String nationality, String age, String height,
            String weight, String position) {
        this.id = id;
        this.equipo_id = equipo_id;
        this.dorsal = dorsal;
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.position = position;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getEquipo_id() {
        return equipo_id;
    }
    public void setEquipo_id(int equipo_id) {
        this.equipo_id = equipo_id;
    }
    public String getDorsal() {
        return dorsal;
    }
    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    

}
