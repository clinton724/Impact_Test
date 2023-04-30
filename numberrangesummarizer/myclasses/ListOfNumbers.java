package myclasses;

import java.util.Collection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfNumbers implements NumberRangeSummarizer {

    // Validate the format of the input
    public boolean validateInput(String input) {
        int currentNumber = 0;
        int index = input.indexOf(',');
        String substr;
        if (index == -1 || input.indexOf(',') == 0 || input.lastIndexOf(',') == input.length() - 1) {
            return false;
        }
        while (index != -1) {
            substr = input.substring(currentNumber, index + 1);

            if (substr.matches("[0-9]+[,]") == false) {
                return false;
            }
            currentNumber = index + 1;
            index = input.indexOf(',', index + 1);
        }
        int lastIndex = input.lastIndexOf(',');
        substr = input.substring(lastIndex + 1, input.length());

        if (substr.matches("[0-9]+") == false) {
            return false;
        }
        return true;
    }

    // collect the input
    public Collection<Integer> collect(String input) {

        if (input.length() == 0 || validateInput(input) == false) {
            throw new IllegalArgumentException("Invalid input.");
        }
        List<Integer> list = Arrays.asList(input.split(",")).stream().map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
        return list;
    }

    // get the summarized string
    public String summarizeCollection(Collection<Integer> input) {
        String result = "";
        int length = 1;
        if (input.size() == 0) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        List<Integer> sortedList = input.stream().sorted().collect(Collectors.toList());
        int size = sortedList.size();

        for (int index = 1; index <= size; index++) {
            if (index == size || sortedList.get(index) - sortedList.get(index - 1) != 1) {
                if (length == 1) {
                    result = result + Integer.toString(sortedList.get(index - length)) + ", ";
                } else {

                    // Build the range between the first
                    // element of the range and the
                    // current previous element as the i-1
                    // last range.
                    String temp = Integer.toString(sortedList.get(index - length)) +
                            "-" + Integer.toString(sortedList.get(index - 1));
                    result = result + temp + ", ";
                }

                length = 1;
            } else {
                length++;
            }
        }
        String newResult = result.substring(0, result.length() - 2);
        return newResult;
    }
}
