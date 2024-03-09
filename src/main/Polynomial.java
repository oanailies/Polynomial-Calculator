package org.example;
import java.util.*;
public class Polynomial {

    private Map<Integer, Monomial> polinom;
    public Polynomial() {

        this.polinom = new HashMap<>();
    }
    Monomial mzero=new Monomial(0, 0.0);
    public Polynomial(Integer key, Monomial value)
    {
       key=0;
       value=mzero;
    }
    String input="";

    public void setPolinom1(Map<Integer, Monomial> polinom1) {
        this.polinom = polinom1;
    }
    public void addMonom(Integer power, Double coeff) {
        Monomial m = new Monomial(power, coeff);
        this.polinom.put(power, m);
    }

    public Map<Integer, Monomial> getPolinom() {
        return polinom;
    }
    
    @Override
    public String toString() {
            String myString =new String("");
            List<Integer> keys = new ArrayList<>(polinom.keySet());
            keys.sort(Comparator.reverseOrder());
            for (Integer power : keys) {
                Monomial monomial = polinom.get(power);
                Double coeff = monomial.getCoeficient();
                if (coeff != 0) {
                    String x = "";
                    if (power > 0) {
                        x = "x";
                        if (power > 1) {
                            x = x + "^" + power;}}
                    if (coeff > 0) {
                        if (!myString.isEmpty()) {
                            myString = myString + " + ";}
                    } else if (coeff < 0) {
                        myString = myString + " - ";
                    }
                    if (Math.abs(coeff) != 1 || x.equals("")) {
                        myString = myString + String.format("%.3f", Math.abs(coeff));}
                    myString = myString + x;}}
            if (polinom.isEmpty()) {
                return "0";}
            return myString;
    }
}
