package calculate.simple;

import calculate.Calculate;
import org.springframework.stereotype.Component;

@Component("minus")
//@Component
public class Minus implements Calculate {
    public Double calculate(Double a, Double b) {
        return  (a - b);
    }
}
