import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] expectedRanks = new int[n];
        
        for (int i = 0; i < n; i++) {
            expectedRanks[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(expectedRanks);
        long totalDifference = 0;
        for (int i = 0; i < n; i++) {
            int actualRank = i + 1;
            totalDifference += Math.abs(expectedRanks[i] - actualRank);
        }
        System.out.println(totalDifference);
        
        br.close();
    }
}