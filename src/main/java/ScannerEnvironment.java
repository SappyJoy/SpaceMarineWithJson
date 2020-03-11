import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerEnvironment {
    Scanner sc;

    public ScannerEnvironment(Scanner sc) {
        this.sc = sc;
    }

    int nextInt() {
        while (true) {
            try {
                int x = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
            }
        }
    }

    String next() {
        while(true) {
            try {
                String s = sc.next();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
            }
        }
    }

    boolean nextBoolean() {
        while (true) {
            try {
                boolean bool = sc.nextBoolean();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
            }
        }
    }

    float nextFloat() {
        while (true) {
            try {
                float fl = sc.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
            }
        }
    }
}
