package myclasses;

import java.util.Collection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfNumbers implements NumberRangeSummarizer {

      public boolean validateInput(String input) {
        int currentNumber = 0;
        int index = input.indexOf(',');
        String substr;
        if(index == -1 || input.indexOf(',') == 0 || input.lastIndexOf(',') == input.length()-1) {
            return false;
        }
        while (index != -1) {
            substr = input.substring(currentNumber,index+1);
            System.out.println(substr);
             if(substr.matches("[0-9]+[,]") == false) {
                return false;
            }
            currentNumber = index+1;
            index = input.indexOf(',', index + 1);
        }
        int lastIndex = input.lastIndexOf(',');
        substr = input.substring(lastIndex+1,input.length());
        System.out.println(substr);
        if(substr.matches("[0-9]+") == false) {
            return false;
        }
        return true; 
      }
  
      public  Collection<Integer> collect(String input) {
          System.out.println(validateInput(input));
          if(input.length() == 0 || validateInput(input) == false) {
            throw new IllegalArgumentException("Invalid input.");
          }
          List<Integer> list = Arrays.asList(input.split(",")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
          return list;
      }
  
      //get the summarized string
      public String summarizeCollection(Collection<Integer> input) {
          String result = "";
          int length = 1;
          if(input.size() == 0) {
            throw new IllegalArgumentException("Input cannot be empty");
          }
          List<Integer> sortedList = input.stream().sorted().collect(Collectors.toList());
          int n = sortedList.size();
          
          for (int i = 1; i <= n; i++) 
          {
              if (i == n || sortedList.get(i) - sortedList.get(i-1) != 1){
                  if (length == 1)
                  {
                     result = result+Integer.toString(sortedList.get(i - length))+", ";
                  }
                  else
                  {
          
                      // Build the range between the first
                      // element of the range and the
                      // current previous element as the i-1
                      // last range.
                      String temp = Integer.toString(sortedList.get(i - length)) +
                                  "-" + Integer.toString(sortedList.get(i - 1));
                      result = result+temp+", ";
                  }
  
                  length = 1;
              }
              else {
                  length++;
              }
          }
          String newResult = result.substring(0, result.length()-2);
          return newResult;
      }
}
