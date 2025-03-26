import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine().trim());
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 최소 힙
        
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            
            if (x != 0) {
                heap.offer(x); // x가 0이 아닌 경우 힙에 추가
            } else { // x가 0인 경우
                if (!heap.isEmpty()) { // 힙이 비어 있지 않다면 최솟값을 결과에 추가
                    sb.append(heap.poll()).append("\n");
                } else { // 힙이 비어 있다면 결과에 0을 추가
                    sb.append(0).append("\n");
                }
            }
        }
        
        System.out.print(sb.toString());
        br.close();
    }
}