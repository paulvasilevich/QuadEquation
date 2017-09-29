import calculate.simple.Scan;
import calculate.roots.impl.RootImpl;
import calculate.simple.impl.ScanImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

//        Scan scan = (calculate.simple.Scan) context.getBean("scan");
        Scan scan = context.getBean(ScanImpl.class);

        Double a = scan.scanValue("a", scanner);
        Double b = scan.scanValue("b", scanner);
        Double c = scan.scanValue("c", scanner);

//        Discriminant discriminant = (Discriminant) context.getBean("discriminant");
//        DiscriminantImpl discriminant = context.getBean(calculate.discriminant
//                .DiscriminantImpl.class);
//        double discr = discriminant.calculate(a, b, c);
//        RootImpl roots = (RootImpl) context.getBean("roots");
        RootImpl roots = context.getBean(RootImpl.class);
        System.out.println(roots.calculate(a, b, c));
//        String result = roots.calculate(a, b, c);
//        System.out.println(result);
    }
}
