// https://www.geeksforgeeks.org/find-second-largest-element-array/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// solution 1 : time - O(nlogn) space - O(1)
// class Solution {
//     public int getSecondLargest(int[] arr) {
//         Arrays.sort(arr);
//         int n = arr.length;

//         for(int i=n-2;i>=0;i--) {
//             if(arr[i]!=arr[n-1]) {
//                 return arr[i];
//             }
//         }

//         return -1;
//     }
// }

// solution 2 : time - O(2*n) , space - O(1)
// class Solution {
//     public int getSecondLargest(int[] arr) {
//         int n = arr.length;
//         int largest = -1;
//         int secondLargest = -1;

//         // find the largest
//         for(int i=0;i<n;i++) {
//             if(arr[i]>largest) {
//                 largest = arr[i];
//             }
//         }

//         for(int i=0;i<n;i++) {
//             if(arr[i]>secondLargest && arr[i] != largest) {
//                 secondLargest = arr[i];
//             }
//         }

//         return secondLargest;
//     }
// }

// solution 3 : time - O(n) , space - O(1)
class Solution {
    public int getSecondLargest(int[] arr) {
        int n = arr.length;
        int largest = -1;
        int secondLargest = -1;

        for(int i=0;i<n;i++) {
            if(arr[i]>largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i]<largest && arr[i]>secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
}