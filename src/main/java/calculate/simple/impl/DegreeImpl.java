package calculate.simple.impl;

import calculate.simple.Calculate;
import org.springframework.stereotype.Component;

@Component("degree1")
//@Component
public class DegreeImpl implements Calculate {
    public Double calculate(Double a, Double b) {
        return  (a / b);
    }
}
