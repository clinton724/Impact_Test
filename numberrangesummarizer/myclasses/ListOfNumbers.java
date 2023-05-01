package myclasses;

import java.util.Collection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfNumbers implements NumberRangeSummarizer {

    // Validate the format of the input
    public boolean isInputValid(String input) {
        int currentNumber = 0;
        int index = input.indexOf(',');
        String substr;
        /*
         * Check if the first and last characters are commas
         * If they are commas, return false
         */
        if (index == -1 || input.indexOf(',') == 0 || input.lastIndexOf(',') == input.length() - 1) {
            return false;
        }
        /*
         * This while loop continually checks the characters between commas
         * If a non integer is found in between the commas, the while loop
         * breaks and the function returns false
         */
        while (index != -1) {
            substr = input.substring(currentNumber, index + 1);

            if (substr.matches("[0-9]+[,]") == false) {
                return false;
            }
            currentNumber = index + 1;
            index = input.indexOf(',', index + 1);
        }

        /*
         * Once all the commas have been obtained, the last characters after the
         * the last comma are checked if they are integers.
         */
        int lastIndex = input.lastIndexOf(',');
        substr = input.substring(lastIndex + 1, input.length());

        if (substr.matches("[0-9]+") == false) {
            return false;
        }
        return true;
    }

    // collect the input
    public Collection<Integer> collect(String input) {
        /*
         * Check if the string is empty and that the format is correct.
         * If the format is invalid or string is empty, an exception is
         * is thrown.
         */
        if (input.length() == 0 || isInputValid(input) == false) {
            throw new IllegalArgumentException("Invalid input.");
        }

        // The list is sorted before its returned.
        List<Integer> list = Arrays.asList(input.split(",")).stream().map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
        return list;
    }

    // get the summarized string
    public String summarizeCollection(Collection<Integer> input) {
        String result = "";
        int length = 1;
        // If the input is empty, an exception is thrown.
        if (input.size() == 0) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        List<Integer> sortedList = input.stream().sorted().collect(Collectors.toList());
        int size = sortedList.size();

        for (int index = 1; index <= size; index++) {

            /*
             * Check the difference between the
             * current and the previous elements
             * If the difference doesn't equal to 1
             * just increment the length variable.
             */
            if (index == size || sortedList.get(index) - sortedList.get(index - 1) != 1) {
                /*
                 * If the range contains
                 * only one element.
                 * add it into the list
                 */
                if (length == 1) {
                    result = result + Integer.toString(sortedList.get(index - length)) + ", ";
                } else {

                    /*
                     * Build the range between the first
                     * element of the range and the
                     * current previous element as the i-1
                     * last range.
                     */
                    String temp = Integer.toString(sortedList.get(index - length)) +
                            "-" + Integer.toString(sortedList.get(index - 1));
                    result = result + temp + ", ";
                }

                /*
                 * After finding the first range
                 * initialize the length by 1 to
                 * build the next range.
                 */
                length = 1;
            } else {
                length++;
            }
        }
        String newResult = result.substring(0, result.length() - 2);
        return newResult;
    }
}
