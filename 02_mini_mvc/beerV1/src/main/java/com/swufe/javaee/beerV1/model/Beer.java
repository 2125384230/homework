package com.swufe.javaee.beerV1.model;


public class Beer {
    private  int year;
    private String location;



    public Beer(int year, String location){
        this.year = year;
        this.location = location;

    }
    @Override
    public String toString(){
        return "beer{" +
                "year=" + year +
                ", location='" + location + '\'' +
                '}';
    }
}
