import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int prefixSum = 0;
        map.put(0, new ArrayList<>(Arrays.asList(-1))); 

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum)) {
                for (int startIndex : map.get(prefixSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }
            
            map.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, -3, 3, -1, 2};
        int[] arr2 = {4, -1, -3, 1, 2, -1};
        int[] arr3 = {0, 0, 0};
        int[] arr4 = {-3, 1, 2, -3, 4, 0};
        int[] arr5 = {1, 2, 3, 4};

        System.out.println(format(findZeroSumSubarrays(arr1))); 
        System.out.println(format(findZeroSumSubarrays(arr2))); 
        System.out.println(format(findZeroSumSubarrays(arr3))); 
        System.out.println(format(findZeroSumSubarrays(arr4))); 
        System.out.println(format(findZeroSumSubarrays(arr5))); 
    }

    private static String format(List<int[]> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            int[] range = list.get(i);
            sb.append("(").append(range[0]).append(", ").append(range[1]).append(")");
            if (i < list.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
