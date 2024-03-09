package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OperatiiTest {
    Operatii op=new Operatii();
    @org.junit.Test
    public void addTest() throws Exception
    {
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();
        p1.addMonom(2, 2.0);
        p2.addMonom(2, 1.0);
        p1.addMonom(1, 2.0);
        p2.addMonom(1, 3.0);
        p1.addMonom(0, -1.0);
        p2.addMonom(0, 1.2);
        r=op.addPolynomials(p1, p2);
        System.out.println(r.toString());
        assertEquals(r.toString(), "3,000x^2 + 5,000x + 0,200");

    }

    @org.junit.Test
    public void addTestRau() throws Exception
    {
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();
        p1.addMonom(2, 2.0);
        p2.addMonom(2, 1.0);
        p1.addMonom(1, 2.0);
        p2.addMonom(1, 3.0);
        p1.addMonom(0, -1.0);
        p2.addMonom(0, 1.2);
        r=op.addPolynomials(p1, p2);
        System.out.println(r.toString());
        assertEquals(r.toString(), "3x^2+5x^1+0.2x^0");
    }
    @org.junit.Test
    public void subTest() throws Exception
    {
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();
        p1.addMonom(2, 2.0);
        p2.addMonom(2, 1.0);
        p1.addMonom(1, 2.0);
        p2.addMonom(1, 3.0);
        p1.addMonom(0, -1.0);
        p2.addMonom(0, 1.2);
        r=op.subtractPolynomials(p1, p2);
        System.out.println(r.toString());
        assertEquals(r.toString(), "x^2 - x - 2,200");

    }

    @org.junit.Test
    public void subTestRau() throws Exception
    {
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();
        p1.addMonom(2, 2.0);
        p2.addMonom(2, 1.0);
        p1.addMonom(1, 2.0);
        p2.addMonom(1, 3.0);
        p1.addMonom(0, -1.0);
        p2.addMonom(0, 1.2);
        r=op.subtractPolynomials(p1, p2);
        System.out.println(r.toString());
        assertEquals(r.toString(), "x^2 + 2x - 2,200");
    }

    @org.junit.Test
    public void mulTest() throws Exception
    {
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();
        p1.addMonom(2, 2.0);
        p2.addMonom(2, 1.0);
        p1.addMonom(1, 2.0);
        p2.addMonom(1, 3.0);
        p1.addMonom(0, -1.0);
        p2.addMonom(0, 1.2);
        r=op.mulPolynomials(p1, p2);
        System.out.println(r.toString());
        assertEquals(r.toString(), "2,000x^4 + 8,000x^3 + 7,400x^2 - 0,600x - 1,200");

    }

    @org.junit.Test
    public void mulTestRau() throws Exception
    {
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        Polynomial r=new Polynomial();
        p1.addMonom(2, 2.0);
        p2.addMonom(2, 1.0);
        p1.addMonom(1, 2.0);
        p2.addMonom(1, 3.0);
        p1.addMonom(0, -1.0);
        p2.addMonom(0, 1.2);
        r=op.mulPolynomials(p1, p2);
        System.out.println(r.toString());
        assertEquals(r.toString(), "2,123x^4 + 8,000x^3x - 1,200");

    }

    @org.junit.Test
    public void derivTest() throws Exception
    {
        Polynomial p1=new Polynomial();
        p1.addMonom(2, 2.0);
        p1.addMonom(1, 2.0);
        p1.addMonom(0, -1.0);
        p1=op.derivatePolynomial(p1);
        System.out.println(p1.toString());
        assertEquals(p1 .toString(), "4,000x + 2,000");

    }

    @org.junit.Test
    public void derivTestRau() throws Exception
    {
        Polynomial p1=new Polynomial();
        p1.addMonom(2, 2.0);
        p1.addMonom(1, 2.0);
        p1.addMonom(0, -1.0);
        p1=op.derivatePolynomial(p1);
        System.out.println(p1.toString());
        assertEquals(p1 .toString(), "4,000x - 2,000X+ derivare");

    }

    @org.junit.Test
    public void integrareTest() throws Exception
    {
        Polynomial p1=new Polynomial();
        p1.addMonom(2, 2.0);
        p1.addMonom(1, 2.0);
        p1.addMonom(0, -1.0);
        p1=op.integratePolynomial(p1);
        System.out.println(p1.toString());
        assertEquals(p1 .toString(), "0,667x^3 + x^2 - x");

    }

    @org.junit.Test
    public void integrareTestRau() throws Exception
    {
        Polynomial p1=new Polynomial();
        p1.addMonom(2, 2.0);
        p1.addMonom(1, 2.0);
        p1.addMonom(0, -1.0);
        p1=op.integratePolynomial(p1);
        System.out.println(p1.toString());
        assertEquals(p1 .toString(), "x^3/3 + x^2/1 - x.1");

    }


}
