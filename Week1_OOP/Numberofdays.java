import java.util.Scanner;

public class Numberofdays {
    public static void main(String args[]) {
        String[] monthStrings = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Aug", "Sep", "Oct", "Nov",
                "Dec", "Jan.", "Feb", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept", "Oct.", "Nov.", "Dec." };
        int[] day_normal_year = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] day_leap_year = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        Scanner sc = new Scanner(System.in);
        String month;
        boolean inputmonth = false;
        int count = 0;
        while (!inputmonth) {
            System.out.println("Enter the month in the correct format");
            month = sc.nextLine();
            count = -1;
            for (String element : monthStrings) {
                count++;
                if (month.equals(element)) {
                    inputmonth = true;
                    break;
                }
            }
        }


        int year;
        boolean inputyear = false;
        while (!inputyear) {
            System.out.println("Enter the year in the correct format");
            year = sc.nextInt();
            if (year > 0) {
                inputyear = true;
                if (year % 4 == 0) {
                    if ((year % 100 == 0) && (year % 400 != 0)) {
                        System.out.println("The day in that month is " + day_normal_year[count % 12]);

                    } else {
                        System.out.println("The day in that month is " + day_leap_year[count % 12]);
                    }
                } else {
                    System.out.println("The day in that month is " + day_normal_year[count % 12]);
                }
            }
        }
        sc.close();
    }
}