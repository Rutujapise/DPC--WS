import java.util.*;

public class LeadersInArray {
    public static List<Integer> findLeaders(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        int maxFromRight = arr[n-1];  
        leaders.add(maxFromRight);

        for (int i = n-2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }

        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        System.out.println(findLeaders(new int[]{16, 17, 4, 3, 5, 2}));   // [17, 5, 2]
        System.out.println(findLeaders(new int[]{1, 2, 3, 4, 0}));       // [4, 0]
        System.out.println(findLeaders(new int[]{7, 10, 4, 10, 6, 5, 2})); // [10, 6, 5, 2]
        System.out.println(findLeaders(new int[]{5}));                   // [5]
        System.out.println(findLeaders(new int[]{100, 50, 20, 10}));     // [100, 50, 20, 10]
    }
}
