// https://www.geeksforgeeks.org/find-maximum-product-of-a-triplet-in-array/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            long ans = new Solution().maxProduct(arr);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// solution 1 : time - O(n3) , space = O(1)
class Solution {
    long maxProduct(int[] arr) {
        long ans = Long.MIN_VALUE;
        
        for(int i=0;i<arr.length-2;i++) {
            for(int j=i+1;j<arr.length-1;j++) {
                for(int k=j+1;k<arr.length;k++) {
                    ans = Math.max(ans, arr[i]*arr[j]*arr[k]);
                }
            }
        }
        
        return ans;
    }
}
