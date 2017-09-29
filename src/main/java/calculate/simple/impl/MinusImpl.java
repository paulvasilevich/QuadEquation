package calculate.simple.impl;

import calculate.simple.Calculate;
import org.springframework.stereotype.Component;

@Component("minus")
//@Component
public class MinusImpl implements Calculate {
    public Double calculate(Double a, Double b) {
        return  (a - b);
    }
}
