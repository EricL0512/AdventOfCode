import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ericl\\IdeaProjects\\AOC 2023\\src\\1AOC2023.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                System.out.println(line);
            }
            String everything = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}