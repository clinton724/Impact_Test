package myclasses;

import java.util.Collection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfNumbers implements NumberRangeSummarizer {
  
      public  Collection<Integer> collect(String input) {
          if(input.length() == 0) {
            throw new IllegalArgumentException("Input cannot be empty");
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
