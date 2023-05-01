package Tests;

import org.junit.*;
import myclasses.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.ArrayList;

public class NumberRangeSummarizerTests {

    /*
     * The following test checks and tests that the summarizeCollection() method
      returns a string.
     */
    @Test
    public void summarizeCollection_ReturnString_True() {
        ListOfNumbers numbers = new ListOfNumbers();
        String input = "7,3,6,1,8,12,13,14,31,21,22,23,24,15";
        Collection<Integer> convertedInput = numbers.collect(input);
        String result = numbers.summarizeCollection(convertedInput);
        assertEquals("String", result.getClass().getSimpleName());
    }

    /*
     * The test below checks and tests that the collect() method returns and
      ArrayList (Collection)
     */
    @Test
    public void collect_ReturnArrayList_True() {
        ListOfNumbers numbers = new ListOfNumbers();
        String input = "7,3,6,1,8,12,13,14,31,21,22,23,24,15";
        Collection<Integer> convertedInput = numbers.collect(input);
        assertEquals("ArrayList", convertedInput.getClass().getSimpleName());
    }

    /*
     * The test below tests the collect() to check if an exception is thrown if the
      input string is empty.
     */
    @Test
    public void collect_InputIsEmpty_ThrowsException() {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            ListOfNumbers listOfNumbers = new ListOfNumbers();
            String nums = "";
            listOfNumbers.collect(nums);
        });
        assertEquals("Invalid input.", exception.getMessage());
    }

    /*
     * The test below tests the summarizeCollection() method to check if an
      exception is thrown if the input array is empty.
     */
    @Test
    public void summarizeCollection_ArrayIsEmpty_ThrowsException() {
        ArrayList<Integer> myList = new ArrayList<Integer>();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            ListOfNumbers listOfNumbers = new ListOfNumbers();
            listOfNumbers.summarizeCollection(myList);
        });
        assertEquals("Input cannot be empty", exception.getMessage());
    }
    
    /*
     * The test below checks whether the isInputValid() method returns false if the format of the 
       input string is incorrect.
     */
    @Test
    public void isInputValid_InvalidInput_False() {
        ListOfNumbers listOfNumbers = new ListOfNumbers();
        String input = "23$5^%&&pdfgndj";
        assertFalse(listOfNumbers.isInputValid(input));
    }

    /*
     * The test below checks whether the isInputValid() method returns true if the format of the 
       input string is correct.
     */
    @Test
    public void isInputValid_ValidInput_True() {
        ListOfNumbers listOfNumbers = new ListOfNumbers();
        String input = "1,2,5,4,78,12,13,4,0,1,800,600,1500,34";
        assertTrue(listOfNumbers.isInputValid(input));
    }

    /*
     * The test below checks that the output of the summarizeCollection() method is correct.
     */
    @Test
    public void summarizeCollection_ValidOutput_Success() {
        ListOfNumbers numbers = new ListOfNumbers();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> num = numbers.collect(input);
        String result = numbers.summarizeCollection(num);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }

    /*
     * The following test checks if the summarizeCollection() method handles inputs with duplicate 
       elements correctly.
     */
    @Test
    public void summarizeCollection_HandlingDuplicates_Success() {
        ListOfNumbers numbers = new ListOfNumbers();
        String input = "1,2,5,4,78,12,13,4,0,1,800,600,1500,34";
        Collection<Integer> num = numbers.collect(input);
        String result = numbers.summarizeCollection(num);
        assertEquals("0-1, 1-2, 4, 4-5, 12-13, 34, 78, 600, 800, 1500", result);
    }
}
