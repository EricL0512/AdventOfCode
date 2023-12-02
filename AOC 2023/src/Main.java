import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String inputLocation = "C:\\Users\\ericl\\IdeaProjects\\AOC 2023\\src\\1AOC2023.txt"; //I have no idea how to read files from the same project, so I used absolute path
        int result = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(inputLocation))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            result += adventOfCodeDayOnePartOne(line); // tests for the first line in the code
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                if (line != null) {
                    result += adventOfCodeDayOnePartOne(line); // tests for the following lines in the code.
                }
            }
            System.out.println(result);
            String everything = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int adventOfCodeDayOnePartOne(String line) throws InputMismatchException {
        boolean strOrInt;
        String firstPart = null;
        String secondPart = null;
        for (int i = 0; i < line.length(); i++)
        {
            strOrInt = isInteger(line.substring(i, i+1));
            if (strOrInt) {
                firstPart = line.substring(i, i+1);
                strOrInt = false;
                break;
            }
        }
        for (int i = line.length()-1; i >= 0; i--)
        {
            strOrInt = isInteger(line.substring(i, i+1));
            if (strOrInt) {
                secondPart = line.substring(i, i+1);
                strOrInt = false;
                break;
            }
        }
        String combinedParts = firstPart + secondPart;
        int combinedPartsInt = Integer.parseInt(combinedParts);
        return combinedPartsInt;
    }
    public static boolean isInteger(String str)
    {
        try{
            Integer.parseInt(str);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}