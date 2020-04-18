package com.example.CourseBack.Entity;

import com.example.CourseBack.ChartConstructor.Chart;
import org.hibernate.result.Output;

public class EquationResponse {

    public EquationResponse(Equation equation, String lang, Chart chart) {
        this.type = chart.getType();
        this.func = getFunction(equation.getEquationjs(), equation.getEquationcoefficientsjs());

        switch (lang){
            case("eng"):{
                label = equation.getEquationnameeng();
            }
            break;
            case("rus"):{
                label = equation.getEquationnamerus();
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + lang);
        }

        findMinMaxParam(equation.getXml());

        this.xAxis = equation.getXaxis();
        this.yAxis = equation.getYaxis();
        this.minX = equation.getXmin();
        this.maxX = equation.getXmax();
        this.stepX = 0.1;
    }

    private String type;
    private String label;
    private String xAxis;
    private String yAxis;
    private String func;
    private Double minParam;
    private Double maxParam;
    private Double minX;
    private Double maxX;
    private Double stepX;

    private String getFunction(String equation, String params) {
        String result = "";
        String[] temp = params.split(";");

        equation = equation.replaceAll("l","T");

        for(int i = 0; i<temp.length; i++){
            result += "var " + temp[i] + ";";
        }

        result+=equation;

        return result;
    }

    private void findMinMaxParam(String xml){
        String temp = xml.substring(xml.indexOf("min=\"") + 5);
        minParam = Double.parseDouble(temp.substring(0,temp.indexOf("\" max")));

        temp = xml.substring(xml.indexOf("max=\"") + 5);
        maxParam = Double.parseDouble(temp.substring(0,temp.indexOf("\" desc")));
    }

    public String getType() {
        return type;
    }

    public String getLabel() { return label; }

    public String getxAxis() {return xAxis; }

    public String getyAxis() { return yAxis; }

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
        return stepX;
    }
}
