package calculate.simple;

import calculate.Calculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("plus")
//@Component
public class Plus implements Calculate {

    public Double calculate(Double a, Double b) {
        return  (a + b);
    }
}
