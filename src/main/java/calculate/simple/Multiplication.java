package calculate.simple;

import calculate.Calculate;
import org.springframework.stereotype.Component;

@Component("multiplication")
//@Component
public class Multiplication implements Calculate{
    public Double calculate(Double a, Double b) {
    return  (a * b);
}
}
