package Week1_OOP;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input first number");
        double num1 = sc.nextDouble();
        System.out.println("Input second number");
        double num2 = sc.nextDouble();

        double sum = num1 + num2;
        System.out.println("The sum: " + sum);

        double difirence = num1 - num2;
        System.out.println("The difirent: " + difirence);
        
        double product = num1 * num2;
        System.out.println("The product: "+ product);

        if(num2 != 0){
            double quotient = num1 / num2;
            System.out.println("The quotient: "+ quotient);
        }
        else {
            System.out.println("ERROR division for zero!");
        }
        sc.close();
    }
}
