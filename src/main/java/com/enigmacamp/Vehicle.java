package com.enigmacamp;

public class Vehicle {
    private String registrationNum;
    private String type;
    private String colour;

    public Vehicle(String registrationNum, String type, String colour) {
        this.registrationNum = registrationNum;
        this.type = type;
        this.colour = colour;
    }

    public Vehicle() {
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNum='" + registrationNum + '\'' +
                ", type='" + type + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
