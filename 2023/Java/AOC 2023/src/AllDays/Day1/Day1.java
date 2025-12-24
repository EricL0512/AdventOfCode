package Day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputLocation = "C:\\Users\\ericl\\IdeaProjects\\AOC2023\\AOC 2023\\src\\AllDays\\Day1\\1AOC2023.txt"; //I have no idea how to read files from the same project, so I used absolute path
        int resultPartOne = 0;
        int resultPartTwo = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(inputLocation))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            resultPartOne += adventOfCodeDayOnePartOne(line); // tests for the first line in the code
            resultPartTwo += adventOfCodeDayOnePartTwo(line);
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                if (line != null) {
                    resultPartOne += adventOfCodeDayOnePartOne(line); // tests for the following lines in the code.
                    resultPartTwo += adventOfCodeDayOnePartTwo(line);
                }
            }
            System.out.printf("PART 1:\n" + resultPartOne + "\n");
            System.out.printf("PART 2:\n" + resultPartTwo + "\n");
            String everything = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int adventOfCodeDayOnePartOne(String line) {
        boolean isIntegerNumber;
        String firstPart = null;
        String secondPart = null;
        for (int i = 0; i < line.length(); i++) { // finds first part
            isIntegerNumber = isInteger(line.substring(i, i+1));
            if (isIntegerNumber) {
                firstPart = line.substring(i, i+1);
                break;
            }
        }
        for (int i = line.length()-1; i >= 0; i--) { // finds second part
            isIntegerNumber = isInteger(line.substring(i, i+1));
            if (isIntegerNumber) {
                secondPart = line.substring(i, i+1);
                break;
            }
        }
        String combinedParts = firstPart + secondPart;
        try {
            return Integer.parseInt(combinedParts);
        }
        catch (NumberFormatException n) {
            return 0;
        }
    }
    public static int adventOfCodeDayOnePartTwo(String line) throws IndexOutOfBoundsException {
        boolean isIntegerNumber;
        boolean isIntegerString;
        String firstPart = null;
        String secondPart = null;
        for (int i = 0; i < line.length(); i++) { // finds first part
            isIntegerNumber = isInteger(line.substring(i, i+1));
            if (isIntegerNumber) {
                firstPart = line.substring(i, i+1);
                break;
            }
            try {
                isIntegerString = isInteger(line.substring(i, i + 3)) || isInteger(line.substring(i, i + 4)) || isInteger(line.substring(i, i + 5));
                if (isIntegerString) {
                    if (isInteger(line.substring(i, i + 3))) firstPart = line.substring(i, i + 3);
                    else if (isInteger(line.substring(i, i + 4))) firstPart = line.substring(i, i + 4);
                    else if (isInteger(line.substring(i, i + 5))) firstPart = line.substring(i, i + 5);
                    break;
                }
            }
            catch (StringIndexOutOfBoundsException ignored) {}
        }
        for (int i = line.length()-1; i >= 0; i--) { // finds second part
            isIntegerNumber = isInteger(line.substring(i, i + 1));
            if (isIntegerNumber) {
                secondPart = line.substring(i, i+1);
                break;
            }
            try {
                isIntegerString = isInteger(line.substring(i, i + 3)) || isInteger(line.substring(i, i + 4)) || isInteger(line.substring(i, i + 5));
                if (isIntegerString) {
                    if (isInteger(line.substring(i, i + 3))) secondPart = line.substring(i, i + 3);
                    else if (isInteger(line.substring(i, i + 4))) secondPart = line.substring(i, i + 4);
                    else if (isInteger(line.substring(i, i + 5))) secondPart = line.substring(i, i + 5);
                    break;
                }
            }
            catch (StringIndexOutOfBoundsException ignored) {}
        }
        firstPart = stringToInt(firstPart);
        secondPart = stringToInt(secondPart);
        String combinedParts = firstPart + secondPart;
        try {
            return Integer.parseInt(combinedParts);
        }
        catch (NumberFormatException n) {
            return 0;
        }
    }
    public static boolean isInteger(String str) {
        List<String> stringList = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        if (stringList.contains(str)) {
            return true;
        }
        try{
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }
    public static String stringToInt(String str) {
        List<String> stringList = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        if (str.length() == 1) {
            return str;
        }
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).equals(str)) {
                return String.valueOf(i+1);
            }
        }
        return null;
    }
}
