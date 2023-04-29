package Tests;
import org.junit.*;
import myclasses.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.Collection;
import java.util.ArrayList;

public class NumberRangeSummarizerTests {
    @Test
    public void checkFunctionReturnTypes(){
        ListOfNumbers numbers = new ListOfNumbers();
        String input = "7,3,6,1,8,12,13,14,31,21,22,23,24,15";
        Collection<Integer> convertedInput = numbers.collect(input);
        String result = numbers.summarizeCollection(convertedInput); 
        assertEquals(result.getClass().getSimpleName(), "String");
        assertEquals(convertedInput.getClass().getSimpleName(), "ArrayList");
    }

    @Test
    public void emptyInputStringThrowsException() {
        
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            ListOfNumbers listOfNumbers = new ListOfNumbers();
            String nums = "";
            listOfNumbers.collect(nums);
        });
        assertEquals("Invalid input.", exception.getMessage());
    }

    @Test 
    public void emptyInputListThrowsException(){
        ArrayList<Integer> myList = new ArrayList<Integer>();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            ListOfNumbers listOfNumbers = new ListOfNumbers();
            listOfNumbers.summarizeCollection(myList);
        });
        assertEquals("Input cannot be empty", exception.getMessage());
    }

    @Test 
    public void validateInput() {
        ListOfNumbers listOfNumbers = new ListOfNumbers();
        String input = "23$5^%&&pdfgndj";
        assertEquals(listOfNumbers.validateInput(input), false);
        input = "2364758";
        assertEquals(listOfNumbers.validateInput(input), false);
        input = ",23445";
        assertEquals(listOfNumbers.validateInput(input), false);
        input = "23,45,";
        assertEquals(listOfNumbers.validateInput(input), false);
        input = "5,e,t,w,7";
        assertEquals(listOfNumbers.validateInput(input), false);
        input = "1,2,5,4,78,12,13,4,0,1,800,600,1500,34";
        assertEquals(listOfNumbers.validateInput(input), true);
    }

    @Test
    public void validateOutput() {
        ListOfNumbers numbers = new ListOfNumbers();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> num = numbers.collect(input);
        String result = numbers.summarizeCollection(num); 
        assertEquals(result, "1, 3, 6-8, 12-15, 21-24, 31");
    }
}
