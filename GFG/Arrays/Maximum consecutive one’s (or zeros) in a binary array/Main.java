// https://www.geeksforgeeks.org/maximum-consecutive-ones-or-zeros-in-a-binary-array/

// Java program to count maximum consecutive
// 1's in a binary array.
class Main {
    
    // Returns count of maximum consecutive 1's
    // in binary array arr[0..n-1]
    static int getMaxLength(int arr[], int n)
    {
        int count = 0;
        int ans = 0;

        for(int val:arr) {
            if(val == 0) {
                count = 0;
            } else {
                count++;
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
    
    // Driver method
    public static void main(String[] args)
    {
        int arr[] = {1, 1, 0, 0, 
                         1, 0, 1, 0,
                           1, 1, 1, 1};
                           
        int n = arr.length;
        
        System.out.println(getMaxLength(arr, n));
    }
}