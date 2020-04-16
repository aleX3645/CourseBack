package com.example.CourseBack.Entity;

import com.example.CourseBack.ChartConstructor.Chart;
import org.hibernate.result.Output;

public class EquationResponse {

    public EquationResponse(Equation equation, Chart chart) {
        this.type = chart.getType();
        this.data = chart.getData();
        this.func = getFunction(equation.getEquationjs(), equation.getEquationcoefficientsjs());

        findMinMaxX(equation.getXml());

        this.minX = equation.getXmin();
        this.maxX = equation.getXmax();
        this.StepX = 0.1;
    }

    private String type;
    private String data;
    private String func;
    private Double minParam;
    private Double maxParam;
    private Double minX;
    private Double maxX;
    private Double StepX;

    private String getFunction(String equation, String params) {
        String result = "";
        String[] temp = params.split(";");

        equation.replaceAll("l","T");

        for(int i = 0; i<temp.length; i++){
            result += "var " + temp[i] + ";";
        }

        result+=equation;

        return result;
    }

    private void findMinMaxX(String xml){
        xml.replaceAll("l", "T");

        String temp = xml.substring(xml.indexOf("min=\"") + 5);
        minX = Double.parseDouble(temp.substring(0,temp.indexOf("\" max")));

        temp = xml.substring(xml.indexOf("max=\"") + 5);
        maxX = Double.parseDouble(temp.substring(0,temp.indexOf("\" desc")));
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public String getFunc() {
        return func;
    }

    public Double getMinParam() {
        return minParam;
    }

    public Double getMaxParam() {
        return maxParam;
    }

    public Double getMinX() {
        return minX;
    }

    public Double getMaxX() {
        return maxX;
    }

    public Double getStepX() {
        return StepX;
    }
}
