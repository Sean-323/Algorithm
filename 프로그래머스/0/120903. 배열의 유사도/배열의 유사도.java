import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> a = new HashSet<>(Arrays.asList(s1));
        Set<String> b = new HashSet<>(Arrays.asList(s2));

        a.retainAll(b);

        return a.size();
    }
}