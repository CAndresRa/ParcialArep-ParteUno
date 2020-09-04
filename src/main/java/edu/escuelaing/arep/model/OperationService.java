package edu.escuelaing.arep.model;



public class OperationService {
    private ICalculate calculo;

    public OperationService (String operation , double number){
        if(operation.equals("sin")) {
            calculo = new Sin(number);
        }
        else if (operation.equals("cos")){
            calculo = new Cos(number);
        }
        else if (operation.equals("tan")){
            calculo = new Tan(number);
        }
    }

    public String getResult(){
        return calculo.getJson();
    }
}
