

import java.util.Arrays;
import java.util.Scanner;

public class SortArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");

        int sum = 0;
        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);
        System.out.println("The sorted array: ");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        CalSum(arr);
    }
    public static void  CalSum(int[] array) {
		int sum=0;
		for (int num:array) {
			sum+=num;
		}
		double avg= (double)sum/array.length;
		System.out.println("Sum of the array elemnts: "+ sum);
		System.out.println("Averange of the array elemnts: "+ avg);
		
	}

}