package calculate.simple.impl;

import calculate.simple.Calculate;
import org.springframework.stereotype.Component;

@Component("plus")
//@Component
public class PlusImpl implements Calculate {

    public Double calculate(Double a, Double b) {
        return  (a + b);
    }
}
