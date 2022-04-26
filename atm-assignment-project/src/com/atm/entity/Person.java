package com.atm.entity;

public class Person {

    private long id;
    private String name;
    private String surname;
    private String gender;
    private String race;
    private String address;

    public Person() {
    }

    public Person(long id, String name, String surname, String gender, String race, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.race = race;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
