import java.util.Scanner;

public class IntegerToHexConversion {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       Integer intNumber = null;

       try {
           System.out.println("Hãy nhập vào một số nguyên: ");
           String strNumber = input.nextLine();
           intNumber = Integer.parseInt(strNumber);
           System.out.println("Chuyển thành Hexa: " + Integer.toHexString(intNumber));
       } catch (NumberFormatException e) {
           System.out.println("Vui lòng nhập vào một số nguyên");
       } catch (NullPointerException e) {
           System.out.println("Giá trị intNumber không hợp lệ");
       }

       input.close();
   }
}