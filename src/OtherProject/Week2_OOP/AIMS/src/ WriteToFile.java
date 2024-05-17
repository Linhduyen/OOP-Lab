import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("alphabet.txt");
            char[] alphabet = new char[26];

            // Tạo mảng chứa các ký tự trong bảng chữ cái
            for (int i = 0; i < alphabet.length; i++) {
                alphabet[i] = (char) ('a' + i);
            }

            // Ghi 10 ký tự đầu tiên của bảng chữ cái vào file
            for (int i = 0; i < 10; i++) {
                writer.write(alphabet[i]);
            }

            writer.close();
            System.out.println("Đã ghi 10 ký tự đầu tiên của bảng chữ cái vào file alphabet.txt");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}