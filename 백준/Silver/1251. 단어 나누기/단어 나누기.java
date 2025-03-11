import java.io.*;

public class Main {
    public static String smallestWord(String word) {
        int n = word.length();
        String smallest = null;
        
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                StringBuilder part1 = new StringBuilder(word.substring(0, i)).reverse();
                StringBuilder part2 = new StringBuilder(word.substring(i, j)).reverse();
                StringBuilder part3 = new StringBuilder(word.substring(j)).reverse();
                
                String combined = part1.toString() + part2.toString() + part3.toString();
                
                if (smallest == null || combined.compareTo(smallest) < 0) {
                    smallest = combined;
                }
            }
        }
        
        return smallest;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String word = br.readLine().trim();
        String result = smallestWord(word);
        
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}