// https://www.geeksforgeeks.org/third-largest-element-array-distinct-elements/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (long i : array)
                arr[idx++] = (int) i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.thirdLargest(arr));

            System.out.println("~");
        }
    }
}

// solution 1 : time - O(nlogn) , time - O(1)
// class Solution {
//      int thirdLargest(int arr[]) {
//          // Your code here
//          int n = arr.length;
//             if(n<3) {
//                return -1;
//              }

//          Arrays.sort(arr);

//          return arr[n-3];
//      }
// }

// solution 2 : O(3n) , time - O(1)
// class Solution {
//     int thirdLargest(int arr[]) {
//         int n = arr.length;
//         if(n<3) {
//             return -1;
//         }
        
//         int first = arr[0];
//         for(int val: arr) {
//             if(val>first) {
//                 first = val;
//             }
//         }
        
//         int second = Integer.MIN_VALUE;
//         for(int val:arr) {
//             if(val>second && val<first) {
//                 second = val;
//             }
//         }
        
//         int third = Integer.MIN_VALUE;
//         for(int val:arr) {
//             if(val>third && val<second) {
//                 third = val;
//             }
//         }
        
//         return third;
//     }
// }


// solution 3 : time - O(n) , space - O(1)
class Solution {
    int thirdLargest(int arr[]) {
        int n = arr.length;
        if(n<3) {
            return -1;
        }
        
        int first = arr[0], second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        
        for(int i=1;i<n;i++) {
            if(arr[i]>first) {
                third = second;
                second = first;
                first = arr[i];
            } else if(arr[i]>second) {
                third = second;
                second = arr[i];
            } else if(arr[i]>third) {
                third = arr[i];
            }
        }
        
        return third;
    }
}