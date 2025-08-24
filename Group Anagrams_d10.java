import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars); 
            String key = new String(chars);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        
        return new ArrayList<>(map.values());
    }

    
    public static void main(String[] args) {
        String[][] testCases = {
            {"eat", "tea", "tan", "ate", "nat", "bat"},
            {""},
            {"a"},
            {"abc", "bca", "cab", "xyz", "zyx", "yxz"},
            {"abc", "def", "ghi"}
        };
        
        for (String[] test : testCases) {
            System.out.println("Input: " + Arrays.toString(test));
            System.out.println("Output: " + groupAnagrams(test));
            System.out.println("-----");
        }
    }
}
