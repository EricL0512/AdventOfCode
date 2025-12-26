package Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> EachLine = new ArrayList<>();
        List<List<String>> StringList = new ArrayList<>();
        String inputLocation = "2023/Java/Day3/3AOC2023.txt"; 
        int resultPartTwo = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(inputLocation))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine(); // reads first line.
            EachLine.add(line);
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                if (line != null) { // reads remaining lines
                }
            }
            // WIP
            // System.out.printf("PART 1:\n" + resultPartOne + "\n");
            // System.out.printf("PART 2:\n" + resultPartTwo + "\n");
            String everything = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

