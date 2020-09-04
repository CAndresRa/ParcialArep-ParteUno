package edu.escuelaing.arep.model;

public class Tan implements ICalculate{
    private double number;
    public Tan (Double number){
        this.number = number;
    }

    @Override
    public String getJson() {
        double result = Math.tan(number);
        return "{\"result\":"+result+"}";
    }
}
