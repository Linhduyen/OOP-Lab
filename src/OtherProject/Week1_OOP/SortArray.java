
import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");

        int s = 0;
        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
            s += arr[i];
        }

        Arrays.sort(arr);
        System.out.println("The sorted array: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Cals(arr);
        sc.close();
    }
    public static void  Cals(int[] array) {
		int s=0;
        
		for (int num:array) {
			s+=num;
		}
		double avg= (double)s/array.length;
		System.out.println("s of the array elemnts: "+ s);
		System.out.println("Averange of the array elemnts: "+ avg);
		
	}

}