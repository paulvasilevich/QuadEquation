package calculate.simple.impl;

import calculate.simple.Calculate;
import org.springframework.stereotype.Component;

@Component("multiplication")
//@Component
public class MultiplicationImpl implements Calculate{
    public Double calculate(Double a, Double b) {
    return  (a * b);
}
}
