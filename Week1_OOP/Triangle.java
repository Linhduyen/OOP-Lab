import java.util.Scanner;
public class Triangle {
    public static void main(String[] ags){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Height of n stars");
        int n = scanner.nextInt();
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n - i; j++) System.out.print(" ");
            for(int j = 1; j <= 2* i - 1; j++) System.out.print("*");
            System.out.println();
        }
        scanner.close();
    }
}
