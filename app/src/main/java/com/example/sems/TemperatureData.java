package com.example.sems;

class TemperatureData {
 private double room1temp;
 private double room2temp;
 private double room3temp;

    public TemperatureData(double room1temp, double room2temp, double room3temp) {
        this.room1temp = room1temp;
        this.room2temp = room2temp;
        this.room3temp = room3temp;
    }

    public double getRoom1temp() {
        return room1temp;
    }

    public void setRoom1temp(double room1temp) {
        this.room1temp = room1temp;
    }

    public double getRoom2temp() {
        return room2temp;
    }

    public void setRoom2temp(double room2temp) {
        this.room2temp = room2temp;
    }

    public double getRoom3temp() {
        return room3temp;
    }

    public void setRoom3temp(double room3temp) {
        this.room3temp = room3temp;
    }
}
