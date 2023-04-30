package Tests;
import org.junit.*;
import myclasses.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.Collection;
import java.util.ArrayList;

public class NumberRangeSummarizerTests {
    @Test
    public void FunctionReturnType_isString_True(){
        ListOfNumbers numbers = new ListOfNumbers();
        String input = "7,3,6,1,8,12,13,14,31,21,22,23,24,15";
        Collection<Integer> convertedInput = numbers.collect(input);
        String result = numbers.summarizeCollection(convertedInput); 
        assertEquals("String",result.getClass().getSimpleName());
    }

    @Test
    public void FunctionReturnType_isArrayList_True() {
        ListOfNumbers numbers = new ListOfNumbers();
        String input = "7,3,6,1,8,12,13,14,31,21,22,23,24,15";
        Collection<Integer> convertedInput = numbers.collect(input);
        assertEquals("ArrayList", convertedInput.getClass().getSimpleName());
    }

    @Test
    public void inputStringValid_isEmpty_throwsException() {
        
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            ListOfNumbers listOfNumbers = new ListOfNumbers();
            String nums = "";
            listOfNumbers.collect(nums);
        });
        assertEquals("Invalid input.", exception.getMessage());
    }

    @Test 
    public void inputArrayValid_isEmpty_throwsException(){
        ArrayList<Integer> myList = new ArrayList<Integer>();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            ListOfNumbers listOfNumbers = new ListOfNumbers();
            listOfNumbers.summarizeCollection(myList);
        });
        assertEquals("Input cannot be empty", exception.getMessage());
    }

    @Test 
    public void inputFormat_isValid_false() {
        ListOfNumbers listOfNumbers = new ListOfNumbers();
        String input = "23$5^%&&pdfgndj";
        assertEquals(false,listOfNumbers.validateInput(input));
    }

    @Test
    public void inputFormat_isValid_true() {
        ListOfNumbers listOfNumbers = new ListOfNumbers();
        String input = "1,2,5,4,78,12,13,4,0,1,800,600,1500,34";
        assertEquals(true,listOfNumbers.validateInput(input));
    }
   
    @Test
    public void outputFormat_isValid_false() {
        ListOfNumbers numbers = new ListOfNumbers();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> num = numbers.collect(input);
        String result = numbers.summarizeCollection(num); 
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31",result);
        
    }

    @Test
    public void outputFormat_isValid_true() {
        ListOfNumbers numbers = new ListOfNumbers();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> num = numbers.collect(input);
        String result = numbers.summarizeCollection(num); 
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31",result);
    }

    @Test
    public void handlingDuplicates_isValid_false() {
        ListOfNumbers numbers = new ListOfNumbers();
        String input = "1,2,5,4,78,12,13,4,0,1,800,600,1500,34";
        Collection<Integer> num = numbers.collect(input);
        String result = numbers.summarizeCollection(num);
        assertEquals("0-1, 1-2, 4, 4-5, 12-13, 34, 78, 600, 800, 1500",result);
    }     
}
