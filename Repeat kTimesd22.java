import java.util.*;

public class FirstElementToRepeatKTimes {
    public static int firstElementToRepeatKTimes(int[] arr, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Find first element with frequency == k
        for (int num : arr) {
            if (freq.get(num) == k) {
                return num;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
    
        System.out.println(firstElementToRepeatKTimes(new int[]{2, 3, 4, 2, 2, 5, 5}, 2));        // 5
        System.out.println(firstElementToRepeatKTimes(new int[]{1, 1, 1, 1}, 1));                  // -1
        System.out.println(firstElementToRepeatKTimes(new int[]{10}, 1));                          // 10
        System.out.println(firstElementToRepeatKTimes(new int[]{6, 6, 6, 6, 7, 7, 8, 8, 8}, 3));   // 8
    }
}
