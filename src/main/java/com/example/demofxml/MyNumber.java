package com.example.demofxml;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class MyNumber {
    private DoubleProperty number = new SimpleDoubleProperty();

    public double getNumber(){
        return number.get();
    }
    public DoubleProperty numberProperty(){
        return number;
    }
    public void setNumber(double number){
        this.number.set(number);
    }
}
