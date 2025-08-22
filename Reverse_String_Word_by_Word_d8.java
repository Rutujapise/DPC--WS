public class ReverseWords {
    public static String reverseWords(String s) {
        s = s.trim();
  
        String[] words = s.split("\\s+");
        
        //  Reverse words
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));   
        System.out.println(reverseWords("  hello world  "));   
        System.out.println(reverseWords("a good   example"));  
        System.out.println(reverseWords("    "));              
        System.out.println(reverseWords("word"));              
    }
}
