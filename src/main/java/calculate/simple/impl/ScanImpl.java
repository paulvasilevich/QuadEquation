package calculate.simple.impl;

import calculate.simple.Scan;
import org.springframework.stereotype.Component;

import java.util.Scanner;

//@Component("scan")
@Component
public class ScanImpl implements Scan {

    public ScanImpl() {
    }

//    private void setValues(Double a, Double b, Double c) {
//        a = scanValue("a",  scan);
//        b = scanValue("b",  scan);
//        c = scanValue("c",  scan);
//    }

    public Double scanValue(String name, Scanner scan) {
//        do {
//            System.out.println("Enter " + name + ": ");
//            value = scan.nextDouble();
//        } while (!scan.hasNextDouble());

        System.out.print("Enter " + name + ": ");
        while (!scan.hasNextDouble()) {
            System.out.println("You enter wrong value. Try again!");
            scan.next();
        }
        return scan.nextDouble();
    }
}
