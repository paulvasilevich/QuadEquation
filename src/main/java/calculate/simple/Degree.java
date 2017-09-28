package calculate.simple;

import calculate.Calculate;
import org.springframework.stereotype.Component;

@Component("degree")
//@Component
public class Degree implements Calculate {
    public Double calculate(Double a, Double b) {
        return  (a / b);
    }
}
