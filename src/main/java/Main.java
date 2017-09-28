import calculate.Discriminant;
import calculate.Scan;
import calculate.roots.Root;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Double a;
        Double b;
        Double c;
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Scan scan = context.getBean(calculate.simple.Scan.class);

        a = scan.scanValue("a", scanner);
        b = scan.scanValue("b", scanner);
        c = scan.scanValue("c", scanner);

        Discriminant discriminant = (Discriminant) context.getBean("discriminant");
        double discr = discriminant.calculate(a, b, c);
        Root roots = (Root) context.getBean("roots");
        String result = roots.calculate(discr, a, b);
        System.out.println(result);
    }
}
