package calculate.roots;

import calculate.Discriminant;
import calculate.Roots;
import calculate.simple.Degree;
import calculate.simple.Minus;
import calculate.simple.Multiplication;
import calculate.simple.Plus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("roots")
//@Component
public  class Root implements Roots {

//    @Resource(name = "degree")
    @Autowired
    private Degree degree;
//    @Resource(name = "minus")
    @Autowired
    private Minus minus;
//    @Resource(name = "plus")
    @Autowired
    private Plus plus;
//    @Resource(name = "multiplication")
    @Autowired
    private Multiplication multiplication;
//    @Resource(name = "discriminant")
    @Autowired
    private Discriminant discriminant;

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Minus getMinus() {
        return minus;
    }

    public void setMinus(Minus minus) {
        this.minus = minus;
    }

    public Plus getPlus() {
        return plus;
    }

    public void setPlus(Plus plus) {
        this.plus = plus;
    }

    public Multiplication getMultiplication() {
        return multiplication;
    }

    public void setMultiplication(Multiplication multiplication) {
        this.multiplication = multiplication;
    }

    public Discriminant getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(Discriminant discriminant) {
        this.discriminant = discriminant;
    }

    public Root() {
    }

    public String calculate(Double discriminant, Double a, Double b) {
        String result;
        if (discriminant < 0) {
            result = "You are missed.";
        } else if (discriminant == 0) {
            result = roots(a, b);
        } else {
            result = roots(discriminant, a, b);
        }
        return result;
    }

    private String roots(Double discriminant, Double a, Double b) {
        double chislitelMinus = minus.calculate((-b), (Math.sqrt(discriminant)));
        double chislitelPlus = plus.calculate((-b), (Math.sqrt(discriminant)));
        double znamenatel = multiplication.calculate((double) 2, a);
        double rootOne = degree.calculate(chislitelMinus, znamenatel);
        double rootTwo = degree.calculate(chislitelPlus, znamenatel);
        String result = "Equation roots: root 1 - " + rootOne + "; root 2 - " + rootTwo + " .";
        return result;
    }

    private String roots(Double a, Double b) {
        double znamenatel = multiplication.calculate((double) 2, a);
        double root = degree.calculate((-b), znamenatel);
        String result = "Equation root: root - " + root +  " .";
        return result;
    }


}
