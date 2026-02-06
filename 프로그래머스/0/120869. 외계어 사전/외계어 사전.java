import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] spell, String[] dic) {
        Set<Character> spellSet = new HashSet<>();
        for (String s : spell) spellSet.add(s.charAt(0));
        
        for (String word : dic) {
            if (word.length() != spell.length) continue;
            
            Set<Character> wordSet = new HashSet<>();
            for (int i = 0; i < word.length(); i++) wordSet.add(word.charAt(i));
            
            if (wordSet.equals(spellSet)) return 1;
        }
        return 2;
    }
}