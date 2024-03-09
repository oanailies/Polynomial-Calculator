package org.example;
import javax.swing.*;
import java.util.*;

public class Operatii
{
    public Polynomial addPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Monomial> i : p1.getPolinom().entrySet())
        {
            Integer power = i.getKey();
            Monomial m1 = i.getValue();
            Double c = m1.getCoeficient();
            if (p2.getPolinom().containsKey(power))
            {
                Monomial m2 = p2.getPolinom().get(power);
                c += m2.getCoeficient();
                p2.getPolinom().remove(power);
            }
            result.addMonom(power, c);
        }
        for (Map.Entry<Integer, Monomial> j : p2.getPolinom().entrySet())
        {
            Integer power = j.getKey();
            Monomial m2 = j.getValue();
            result.addMonom(power, m2.getCoeficient());
        }
        if (result.getPolinom().isEmpty())
        {
            return new Polynomial();
        }
        return result;
    }
    public Polynomial subtractPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Monomial> i : p1.getPolinom().entrySet())
        {
            Integer power = i.getKey();
            Monomial m1 = i.getValue();
            Double c = m1.getCoeficient();
            if (p2.getPolinom().containsKey(power))
            {
                Monomial m2 = p2.getPolinom().get(power);
                c -= m2.getCoeficient();
                p2.getPolinom().remove(power);
            }
            result.addMonom(power, c);
        }
        for (Map.Entry<Integer, Monomial> j : p2.getPolinom().entrySet())
        {
            Integer power = j.getKey();
            Monomial m2 = j.getValue();
            result.addMonom(power, -m2.getCoeficient());
        }
        if (result.getPolinom().isEmpty())
        {
            return new Polynomial();
        }
        return result;
    }
    public Polynomial mulPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> i: p1.getPolinom().entrySet())
        {
            Integer power1=i.getKey();
            Monomial m1=i.getValue();
            for(Map.Entry<Integer, Monomial> j: p2.getPolinom().entrySet())
            {
                Integer power2=j.getKey();
                Monomial m2=j.getValue();
                Integer power=power1 + power2;
                Double coeficient= m1.getCoeficient() * m2.getCoeficient();
                Boolean ok=false;
                for(Map.Entry<Integer, Monomial> k: result.getPolinom().entrySet())
                {
                    if(k.getKey().equals(power))
                    {
                        result.addMonom(power, k.getValue().getCoeficient()+coeficient);
                        ok=true;
                        break;
                    }
                }
                if(ok==false)
                {
                    result.addMonom(power, coeficient);
                }
            }
        }
        if(result.getPolinom().isEmpty())
        {
            return new Polynomial();
        }
        return result;
    }
    public Polynomial divPolynomials(Polynomial p1, Polynomial p2)
    {
        Polynomial result = new Polynomial();
        Polynomial remainder = new Polynomial(p1);
        if (p2.isZero() || p1.getDegree() < p2.getDegree())
        {
            return result; // Return 0
        }

        while (remainder.getDegree() >= p2.getDegree())
        {
            int currentDegree = remainder.getDegree() - p2.getDegree();
            double currentCoefficient = remainder.getCoefficientForDegree(remainder.getDegree()) /
                                        p2.getCoefficientForDegree(p2.getDegree());
            result.addMonom(currentDegree, currentCoefficient);
            Polynomial termToSubtract = p2.multiplyByScalar(currentCoefficient).raiseDegree(currentDegree);
            remainder = subtractPolynomials(remainder, termToSubtract);
        }

        return result;
    }


    public Polynomial integratePolynomial(Polynomial p)
    {
        Polynomial result= new Polynomial();
        for(Map.Entry<Integer, Monomial> i: p.getPolinom().entrySet())
        {
            Integer power=i.getKey();
            Double coeff=i.getValue().getCoeficient();
            coeff=coeff/(power+1);
            if(power>=0)
            {
                result.addMonom(power + 1, coeff);
            }

        }
        return result;
    }

    public Polynomial derivatePolynomial(Polynomial p)
    {
        Polynomial result= new Polynomial();
        for(Map.Entry<Integer, Monomial> i: p.getPolinom().entrySet())
        {
            Integer power=i.getKey();
            Double coeff=i.getValue().getCoeficient();
            if(power>0)
            {
                result.addMonom(power - 1, coeff * power);
            }
        }
        return result;
    }

}



