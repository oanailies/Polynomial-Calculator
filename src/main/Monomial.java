package org.example;

import java.util.*;
public class Monomial {
    private Integer exponent;
    private Double coeficient;
    public Monomial(Integer exponent, Double coeficient)
    {
        this.exponent=exponent;
        this.coeficient=coeficient;
    }
    public Integer getExponent()
    {
        return exponent;
    }
    public Double getCoeficient()
    {
        return coeficient;
    }
    public void setExponent(Integer exponent)
    {
        this.exponent=exponent;
    }
    public void setCoeficient(Double coeficient)
    {
        this.coeficient=coeficient;
    }
}

