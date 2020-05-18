package com.example.advancecalculator.controller;


import java.io.IOException;

public class CalculatorController {
   private double numberFirst, numberSecond, result;
   String operationSign;

    public CalculatorController() {

    }
    public void calculate() throws IOException {
        if (operationSign== "+" ){
            result= numberFirst + numberSecond;
        }
        else if (operationSign=="-"){
            result=numberFirst - numberSecond;
        }
        else if (operationSign== "*"){
            result=numberFirst * numberSecond;

        }
        else if (operationSign=="/") {
            if (numberSecond == 0) {
               // throw new IOException("Error");
                return;
            } else {
                result = numberFirst / numberSecond;
            }
        }

        else if (operationSign=="^"){
            result=Math.pow(numberFirst,numberSecond);
        }
        else if (operationSign=="^2"){
            result=Math.pow(numberFirst, 2);
        }
        else if (operationSign=="^3"){
            result=Math.pow(numberFirst, 3);
        }
        else if (operationSign=="√"){
            result=Math.sqrt(numberFirst);
        }

        else if (operationSign=="SIN"){

            result=Math.sin(Math.toRadians(numberFirst));
        }
        else if (operationSign=="COS"){
            result=Math.cos(Math.toRadians(numberFirst));
        }
        else if (operationSign=="TAN"){
            result=Math.tan(Math.toRadians(numberFirst));
        }
        else if (operationSign=="LOG"){
            result=Math.log10(numberFirst);
        }
        else if (operationSign=="3.14"){
            result=3.14;
        }
        else if (operationSign=="LN"){
            result=Math.log(numberFirst);
        }
        else if (operationSign=="/1"){
            result=1/numberFirst;
        }
    }
    public String printResults(){
            return String.valueOf(result);

    }
    public String printEquation(){
        return new StringBuilder().append(numberFirst).append(operationSign).append(numberSecond).append(" = ").append(result).toString();
    }

    public double getNumberFirst() {
        return numberFirst;
    }

    public void setNumberFirst(double numberFirst) {
        this.numberFirst = numberFirst;
    }

    public double getNumberSecond() {
        return numberSecond;
    }

    public void setNumberSecond(double numberSecond) {
        this.numberSecond = numberSecond;
    }


    public void setOperation(String operation) {

        switch (operation){
            case "ADDITION":
                this.operationSign= "+";
                break;
            case "SUBTRACTION":
                this.operationSign= "-";
                break;
            case "MULTIPLICATION":
                this.operationSign= "*";
                break;
            case "DIVISION":
                this.operationSign="/" ;
                break;
            case "POWER":
                this.operationSign= "^";
                break;
            case "SQUARE":
                this.operationSign= "^2";
                break;
            case "CUBE":
                this.operationSign= "^3";
                break;
            case "UNDERROOT":
                this.operationSign= "√";
                break;
            case "FACTORIAL":
                this.operationSign= "!";
                break;
            case "SIN":
                this.operationSign= "SIN";
                break;
            case "COS":
                this.operationSign= "COS";
                break;
            case "TAN":
                this.operationSign= "TAN";
                break;
            case "LOG":
                this.operationSign= "LOG";
                break;
            case "LN":
                this.operationSign= "LN";
                break;
            case "PI":
                this.operationSign= "3.14";
                break;
            case "INVERSE":
                this.operationSign= "/1";
                break;
        }
    }
}
