import java.util.Collection;

public class Main {
   public static void main(String []args) {
      
      ListOfNumbers numbers = new ListOfNumbers();
      String nums = "7,3,6,1,8,12,13,14,31,21,22,23,24,15";
      Collection<Integer> num = numbers.collect(nums);
      String result = numbers.summarizeCollection(num);  
     
      for (int i = 0; i < result.length(); i++) {
 
        // Print current character
        System.out.print(result.charAt(i));
    }
   }
}
