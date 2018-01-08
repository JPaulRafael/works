/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author admision
 */

import java.util.ArrayList;
import modelo.User;


public class QuickSort  {
  private static ArrayList<User> numbers;
  private static int number;

  public static ArrayList<User> sort(ArrayList<User> values) {
    // check for empty or null array
    if (values ==null || values.size()==0){
      return null;
    }
    numbers = values;
    number = values.size();
    quicksort(0, number - 1);
    
    return new ArrayList<User>(numbers); 
  }

  private static void quicksort(int low, int high) {
    int i = low, j = high;
    //Find the item in the middle of the list
    User pivot = numbers.get(low + (high-low)/2);

    //Split the list into two groups
    while (i <= j) {
      // If the current value from the left list is greater then the pivot
      // element then get the next element from the left list
    	
    	//Select an element from the first half that is greater than the middle value
      while (numbers.get(i).getPoints()> pivot.getPoints()) {
        i++;
      }
      //Select an element from the second half that is less than middle value 
      while (numbers.get(j).getPoints() < pivot.getPoints()) {
        j--;
      }
      
      //if the selected value from the left list is less than or equal to the element in the right list.
      //Exchange them. Before moving to the next element
      if (i <= j) {
        exchange(i, j);
        i++;
        j--;
      }
    }
    // Recursion
    if (low < j)
      quicksort(low, j);
    if (i < high)
      quicksort(i, high);
  }

  private static void exchange(int i, int j) {
    User temp = numbers.get(i);

    numbers.set(i, numbers.get(j));
    numbers.set(j, temp);
  }
} 