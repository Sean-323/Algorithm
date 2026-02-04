import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();

        char[] chars = my_string.toCharArray();
        Set<Character> set = new LinkedHashSet<>();
        for (char c : chars) if (set.add(c)) answer.append(c);
        
        return answer.toString();
    }
}