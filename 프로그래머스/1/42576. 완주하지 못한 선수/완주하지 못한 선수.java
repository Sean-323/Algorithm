import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> cnt = new HashMap<>();

        for (String name : participant) cnt.put(name, cnt.getOrDefault(name, 0) + 1);

        for (String name : completion) cnt.put(name, cnt.get(name) - 1);
        

        for (Map.Entry<String, Integer> e : cnt.entrySet()) {
            if (e.getValue() != 0) return e.getKey();
        }

        return ""; 
    }
}