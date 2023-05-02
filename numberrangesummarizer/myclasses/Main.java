package myclasses;
import java.util.Collection;

public class Main {
    public static void main(String args[]) {
      
        ListOfNumbers numbers = new ListOfNumbers();
        String nums = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        if(numbers.isInputValid(nums) == true) {
            Collection<Integer> num = numbers.collect(nums);
            String result = numbers.summarizeCollection(num); 
        }
     }
}
