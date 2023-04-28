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
        assertEquals("Input cannot be empty", exception.getMessage());
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
}
