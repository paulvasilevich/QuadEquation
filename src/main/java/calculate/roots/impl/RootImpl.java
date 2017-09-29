package calculate.roots.impl;

import calculate.discriminant.Discriminant;
import calculate.simple.Calculate;
import calculate.roots.Roots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("roots")
//@Component
public  class RootImpl implements Roots {

//    @Resource(name = "degree")
    @Autowired
    private Calculate degree1;
//    @Resource(name = "minus")
    @Autowired
    private Calculate minus;
//    @Resource(name = "plus")
    @Autowired
    private Calculate plus;
//    @Resource(name = "multiplication")
    @Autowired
    @Qualifier("multiplication")
    private Calculate multiplication13;
//    @Resource(name = "discriminant")
    @Autowired
    private Discriminant discriminant;

    public Calculate getDegree() {
        return degree1;
    }

    public void setDegree(Calculate degree1) {
        this.degree1 = degree1;
    }

    public Calculate getMinus() {
        return minus;
    }

    public void setMinus(Calculate minus) {
        this.minus = minus;
    }

    public Calculate getPlus() {
        return plus;
    }

    public void setPlus(Calculate plus) {
        this.plus = plus;
    }

    public Calculate getMultiplication() {
        return multiplication13;
    }

    public void setMultiplication(Calculate multiplication) {
        this.multiplication13 = multiplication;
    }

    public Discriminant getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(Discriminant discriminant) {
        this.discriminant = discriminant;
    }

    public RootImpl() {
    }

    public String calculate( Double a, Double b, Double c) {
        double discr = discriminant.calculate(a, b, c);
        if (discr < 0) {
            return  "You are missed.";
        } else if (discr == 0) {
            return  roots(a, b);
        } else {
            return roots(discr, a, b);
        }
    }

    private String roots(Double discriminant, Double a, Double b) {
        double sqrtDiscriminant = Math.sqrt(discriminant);
        double chislitelMinus = minus.calculate((-b), sqrtDiscriminant);
        double chislitelPlus = plus.calculate((-b), sqrtDiscriminant);
        double znamenatel = multiplication13.calculate((double) 2, a);
        double rootOne = degree1.calculate(chislitelMinus, znamenatel);
        double rootTwo = degree1.calculate(chislitelPlus, znamenatel);
        String result =  String.format("Equation roots: root 1 - %f; 2 - %f.",rootOne,
                rootTwo);
        return result;
    }

    private String roots(Double a, Double b) {
        double znamenatel = multiplication13.calculate((double) 2, a);
        double root = degree1.calculate((-b), znamenatel);
        StringBuffer result = new StringBuffer("Equation root: root - ");
        result.append(root);
        result.append(" .");
        return result.toString();
    }


}
