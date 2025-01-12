import java.util.*;

// Sort method
// Time complexity: O(n logn) and Space Complexity: O(1)

// Brute force is Optimal
// Time complexity: O(n) and Space Complexity: O(1)
public class tuf {
 
  public static void main(String args[]) {
    
    int arr1[] =  {2,5,1,3,0};
    System.out.println("The Largest element in the array is: "+findLargestElement(ar
    r1));
 
    int arr2[] =  {8,10,5,7,9};
    System.out.println("The Largest element in the array is: "+findLargestElement(ar
    r2));
  }
  static int findLargestElement(int arr[]) {
    int max= arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max= arr[i];
      }
    }
    return max;
  }
}

