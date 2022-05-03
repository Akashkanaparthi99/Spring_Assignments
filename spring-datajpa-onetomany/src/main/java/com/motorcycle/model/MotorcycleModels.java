package com.motorcycle.model;

public class MotorcycleModels {
    private String chasisNumber; //primary key
    private String model;
    private String name;
    private Seater seater; // 2 seater , single seater
    private String engine;
    private Brake brake; // front, rear
    private double onRoadPrice;
    private boolean abs;
    private MotorcyclesCompany company;
}
