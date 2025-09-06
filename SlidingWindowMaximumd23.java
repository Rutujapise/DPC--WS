import java.util.*;

public class SlidingWindowMaximum {
    
    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k == 0) return new int[0];
        if (k == 1) return arr; // Each element is its own max
        
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices
        
        for (int i = 0; i < n; i++) {
            // Remove indices out of current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            // Remove smaller values from back
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            
            // Add current index
            dq.offerLast(i);
            
            // Store result for this window
            if (i >= k - 1) {
                result[i - k + 1] = arr[dq.peekFirst()];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 5, 3, 2, 4, 6}, 3)));
        // Output: [5, 5, 4, 6]

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 2, 3, 4}, 2)));
        // Output: [2, 3, 4]

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{7, 7, 7, 7}, 1)));
        // Output: [7, 7, 7, 7]

        
    }
}
