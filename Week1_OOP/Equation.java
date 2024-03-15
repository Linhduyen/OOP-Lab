import java.util.Scanner;
public class Equation {
   public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    while(TRURE){
        System.out.println("The equation in this task: ");
        System.out.println("The first-degree equation (linear equation)");
        System.out.println("The system of first-degree equations (linear system)");
        System.out.println("The second-degree equation");
        System.out.println("EXIT");
        System.out.println("Enter choice");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                solvelinearsystem();
                break;
            case 2: 
                solvelinearsystem();
                break;
            case 3: 
                solveseconddegreeequation();
                break;
            case 4: 
                sc.close();
                System.out.println("EXIT!");
                System.exit(0);
            default: 
                System.out.println("Invalid choice! Please choose again.");
        }
    }
   }
    //The first-degree equation (linear equation) with one variable
    public static void solvelinearsystem(Scanner sc){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Solving first-degree equation: ax + b = 0");
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        if(a == 0){
            if(b == 0) System.out.println("Infinity solution");
            else System.out.println("No solution");
        }
        else{
            Double solution = -b/a;
            System.out.println("The solution is: "+ solution);
        }

    }
    //The system of first-degree equations (linear system) with two variables
    public static void solvelinearsystem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Solving linear system of equations (ax + by = c, dx + ey = f)");
        System.out.println("Enter a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter b: ");
        double b = scanner.nextDouble();
        System.out.println("Enter c: ");
        double c = scanner.nextDouble();
        System.out.println("Enter coefficients for the second equation (dx + ey = f):");
        System.out.println("Enter d: ");
        double d = scanner.nextDouble();
        System.out.println("Enter e: ");
        double e = scanner.nextDouble();
        System.out.println("Enter f: ");
        double f = scanner.nextDouble();
        double determiant1 = a*e - b*d;
        double determiant2 = a*f - c*d;
        double determiant3 = b*f - a*c;
        if(determiant1 == 0 && determiant2 == 0 && determiant3 == 0){
            System.out.println("Infinite solution");
        }
        else if(determiant1 == 0){
            System.out.println("No solution");
        }else{
            double x = (c*e - b*f)/determiant1;
            double y = (a*f - c*d)/determiant1;
            System.out.println("The solution for the system of equations is:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }
    }
    public static void solveseconddegreeequation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Solving second-degree equation (ax^2 + bx + c = 0)");
        System.out.println("Enter a: ");
        double a = scanner.nextDouble();
        if(a == 0){
            System.out.println("This is not a second-degree equation!");
            scanner.close();
            return;
        }
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();
        
        double discriminant = b*b - 4*c*a;
        if(discriminant > 0){
            double root1 = (-b + Math.sqrt(discriminant))/ (2 *a);
            double root2 = (-b + Math.sqrt(discriminant))/ (2 *a);
            System.out.println("Two distinct roots: x1 = "+root1+ ", x2 = "+root2);
        } else if( discriminant = 0){
            double root = -b/2*a;
            System.out.println("The equation has only one root: " + root );
        } else {
            System.out.println("There are no real root in this equation");
        }

    }

}
