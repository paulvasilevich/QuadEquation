package calculate.discriminant;

import calculate.simple.Minus;
import calculate.simple.Multiplication;

public class Discriminant implements calculate.Discriminant{

    private Minus minus;
    private Multiplication fourAC;

    public Minus getMinus() {
        return minus;
    }

    public void setMinus(Minus minus) {
        this.minus = minus;
    }

    public Multiplication getFourAC() {
        return fourAC;
    }

    public void setFourAC(Multiplication fourAC) {
        this.fourAC = fourAC;
    }

    public Discriminant() {
    }

    public Double calculate(Double a, Double b, Double c) {
        double first = Math.pow(b, 2);
        double second = fourAC.calculate(fourAC.calculate((double) -4, a), c);
        double discriminant =  (minus.calculate(first, second));
        if (discriminant < 0) {
            System.out.println("Discriminant is < 0, equation don't have root... ");
            return (double) -1;
        }
        return discriminant;
    }
}
