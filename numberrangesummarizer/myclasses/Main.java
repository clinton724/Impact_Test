package myclasses;
import java.util.Collection;

public class Main {
    public static void main(String args[]) {
      
        ListOfNumbers numbers = new ListOfNumbers();
        String nums = "1,2,5,4,78,12,13,4,0,1,800,600,1500,34";
        if(numbers.validateInput(nums) == true) {
            Collection<Integer> num = numbers.collect(nums);
            String result = numbers.summarizeCollection(num); 

            for (int i = 0; i < result.length(); i++) {
   
                // Print current character
                System.out.print(result.charAt(i));
            }
        }
       
       
      
     }
}
