package calculate.simple;

import java.util.Scanner;

public class Scan implements calculate.Scan{

    public Scan() {
    }

//    private void setValues(Double a, Double b, Double c) {
//        a = scanValue("a",  scan);
//        b = scanValue("b",  scan);
//        c = scanValue("c",  scan);
//    }

    public Double scanValue(String name, Scanner scan) {
        Double value;

//        do {
//            System.out.println("Enter " + name + ": ");
//            value = scan.nextDouble();
//        } while (!scan.hasNextDouble());

        System.out.println("Enter " + name + ": ");
        while (!scan.hasNextDouble()) {
            System.out.println("You enter wrong value. Try again!");
            scan.next();
        }
        value = scan.nextDouble();
        return value;
    }
}
