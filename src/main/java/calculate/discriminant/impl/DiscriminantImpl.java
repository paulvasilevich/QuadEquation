package calculate.discriminant.impl;

import calculate.discriminant.Discriminant;
import calculate.simple.impl.MinusImpl;
import calculate.simple.impl.MultiplicationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("discriminant")
//@Component
public class DiscriminantImpl implements Discriminant {

//    @Resource(name = "minus")
    @Autowired
    private MinusImpl minus;

//    @Resource(name = "multiplication")
    @Autowired
    private MultiplicationImpl fourAC;

    public MinusImpl getMinus() {
        return minus;
    }

    public void setMinus(MinusImpl minus) {
        this.minus = minus;
    }

    public MultiplicationImpl getFourAC() {
        return fourAC;
    }

    public void setFourAC(MultiplicationImpl fourAC) {
        this.fourAC = fourAC;
    }

    public DiscriminantImpl() {
    }

    public Double calculate(Double a, Double b, Double c) {
        double first = Math.pow(b, 2);
        double second = fourAC.calculate(fourAC.calculate((double) -4, a), c);
        double discriminant =  (minus.calculate(first, second));
        if (discriminant < 0) {
            System.out.println("DiscriminantImpl is < 0, equation don't have root... ");
            return (double) -1;
        }
        return discriminant;
    }

//    public Double calculate(Double a, Double b) {
//        return null;
//    }
}
