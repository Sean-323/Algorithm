import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        // 입력
        int n = Integer.parseInt(br.readLine());
        
        // 중복 제거를 위해 HashSet 사용
        HashSet<String> wordSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            wordSet.add(br.readLine());
        }
        
        // Set을 List로 변환
        List<String> words = new ArrayList<>(wordSet);
        
        // 길이에 따라 정렬하고, 길이가 같으면 사전순으로 정렬
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2); // 사전순 정렬
                }
                return s1.length() - s2.length(); // 길이순 정렬
            }
        });
        
        for (String word : words) sb.append(word).append("\n");
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}