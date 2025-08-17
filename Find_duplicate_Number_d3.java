public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        // Step 1: Detect cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];          // move 1 step
            fast = nums[nums[fast]];    // move 2 steps
        } while (slow != fast);

        // Step 2: Find cycle entry (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // duplicate number
    }

    // Test Cases
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 2, 2};
        int[] arr2 = {3, 1, 3, 4, 2};
        int[] arr3 = {1, 1};
        int[] arr4 = {1, 4, 4, 2, 3};
        int[] arr5 = new int[100000];
        for (int i = 1; i < 100000; i++) {
            arr5[i - 1] = i;
        }
        arr5[99999] = 50000; // duplicate

        System.out.println("Duplicate number: " + findDuplicate(arr1)); // 2
        System.out.println("Duplicate number: " + findDuplicate(arr2)); // 3
        System.out.println("Duplicate number: " + findDuplicate(arr3)); // 1
        System.out.println("Duplicate number: " + findDuplicate(arr4)); // 4
        System.out.println("Duplicate number: " + findDuplicate(arr5)); // 50000
    }
}
