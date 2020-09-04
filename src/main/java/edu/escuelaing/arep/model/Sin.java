package edu.escuelaing.arep.model;

public class Sin implements ICalculate{
    private double number;
    public Sin (Double number){
        this.number = number;
    }

    @Override
    public String getJson() {
        double result = Math.sin(number);
        return "{\"result\":"+result+"}";
    }
}
