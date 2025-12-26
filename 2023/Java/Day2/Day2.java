package Day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        String inputLocation = "2023/Java/Day2/2AOC2023.txt";
        int resultPartOne = 0;
        int resultPartTwo = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(inputLocation))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine(); // reads first line.
            resultPartOne += adventOfCodeDayTwoPartOne(line);
            resultPartTwo += adventOfCodeDayTwoPartTwo(line);
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                if (line != null) { // reads remaining lines
                    resultPartOne += adventOfCodeDayTwoPartOne(line);
                    resultPartTwo += adventOfCodeDayTwoPartTwo(line);
                }
            }
            System.out.printf("PART 1:\n" + resultPartOne + "\n");
            System.out.printf("PART 2:\n" + resultPartTwo + "\n");
            String everything = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // This was designed to solve the second part of the question and modified to solve the first part.
    public static int adventOfCodeDayTwoPartOne(String line) throws NumberFormatException{
        line = line.substring(5);
        int maxRed = 0;
        int maxBlue = 0;
        int maxGreen = 0;
        int temp = 0;
        String eachValue;
        int gameID;
        // removes the lines of code detailing the game ID
        if (isInteger(line.substring(0, 3))) {
            gameID = Integer.parseInt(line.substring(0,3));
            line = line.substring(5);
        }
        else if (isInteger(line.substring(0, 2))){
            gameID = Integer.parseInt(line.substring(0,2));
            line = line.substring(4);
        }
        else {
            gameID = Integer.parseInt(line.substring(0,1));
            line = line.substring(3);
        }
        String[] StringListLarge = line.split("; "); // splits based on different games
        List<List<String>> StringList = new ArrayList<>();
        List<String> StringList1D = new ArrayList<>();
        String eachPart;
        for (String s : StringListLarge) {
            eachPart = s;
            List<String> StringListBig = new ArrayList<>(Arrays.asList(eachPart.split(", ")));
            StringList.add(StringListBig);
        }
        for (int i = 0; i < StringList.size(); i++) {
            for (int j = 0; j < StringList.get(i).size(); j++) { // iterates through each element of the list
                eachValue = StringList.get(i).get(j);
                try {
                    temp = Integer.parseInt(eachValue.substring(0,3));
                }
                catch(NumberFormatException ignored) {}
                try {
                    temp = Integer.parseInt(eachValue.substring(0,2));
                }
                catch (NumberFormatException z) {
                    temp = Integer.parseInt(eachValue.substring(0,1));
                }
                // sets each of the maximums to the max value seen in a given game
                if (eachValue.contains("red") && temp > maxRed) maxRed = temp;
                if (eachValue.contains("blue") && temp > maxBlue) maxBlue = temp;
                if (eachValue.contains("green") && temp > maxGreen) maxGreen = temp;
                if (maxRed > 12 || maxBlue > 14 || maxGreen > 13) return 0;
            }
        }
        return gameID;
    }
    public static int adventOfCodeDayTwoPartTwo(String line) throws NumberFormatException{
        line = line.substring(5);
        int maxRed = 0;
        int maxBlue = 0;
        int maxGreen = 0;
        int temp = 0;
        String eachValue;
        int gameID;
        // removes the lines of code detailing the game ID
        if (isInteger(line.substring(0, 3))) {
            gameID = Integer.parseInt(line.substring(0,3));
            line = line.substring(5);
        }
        else if (isInteger(line.substring(0, 2))){
            gameID = Integer.parseInt(line.substring(0,2));
            line = line.substring(4);
        }
        else {
            gameID = Integer.parseInt(line.substring(0,1));
            line = line.substring(3);
        }
        String[] StringListLarge = line.split("; "); // splits based on different games
        List<List<String>> StringList = new ArrayList<>();
        List<String> StringList1D = new ArrayList<>();
        String eachPart;
        for (String s : StringListLarge) {
            eachPart = s;
            List<String> StringListBig = new ArrayList<>(Arrays.asList(eachPart.split(", ")));
            StringList.add(StringListBig);
        }
        for (int i = 0; i < StringList.size(); i++) {
            for (int j = 0; j < StringList.get(i).size(); j++) { // iterates through each element of the list
                eachValue = StringList.get(i).get(j);
                try {
                    temp = Integer.parseInt(eachValue.substring(0,3));
                }
                catch(NumberFormatException ignored) {}
                try {
                    temp = Integer.parseInt(eachValue.substring(0,2));
                }
                catch (NumberFormatException z) {
                    temp = Integer.parseInt(eachValue.substring(0,1));
                }
                // sets each of the maximums to the max value seen in a given game
                if (eachValue.contains("red") && temp > maxRed) maxRed = temp;
                if (eachValue.contains("blue") && temp > maxBlue) maxBlue = temp;
                if (eachValue.contains("green") && temp > maxGreen) maxGreen = temp;
            }
        }
        return maxBlue * maxGreen * maxRed;
    }
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
