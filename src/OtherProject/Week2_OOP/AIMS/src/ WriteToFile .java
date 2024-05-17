import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class WriteToFile  {
    public static void main(String[] args){
        try{
            FileWriter writer = new FileWriter("alphabet.txt");
            char[] alphabet = new char[26];
            for(int i = 0; i < alphabet.length; i++){
                alphabet[i] = (char)('a' + i);
            }
            for(int i  = 0; i < 10; i++){
                writer.write(alphabet[i]);
            }
            writer.close();
            System.out.println("Write the first 10 characters of the alphabet to file alphabet.txt")
        } catch(IOException e){
            System.out.println("Error when writing file: "+ e.getMessage());
        }
    }
}
