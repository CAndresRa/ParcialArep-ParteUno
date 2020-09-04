package edu.escuelaing.arep.model;

public class Cos implements ICalculate{

    private double number;
    public Cos (Double number){
        this.number = number;
    }

    @Override
    public String getJson() {
        double result = Math.cos(number);
        return "{\"result\":"+result+"}";
    }
}
