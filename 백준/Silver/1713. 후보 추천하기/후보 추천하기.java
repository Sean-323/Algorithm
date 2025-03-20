import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        int N = Integer.parseInt(br.readLine().trim());
        int R = Integer.parseInt(br.readLine().trim());
        
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int[] candidates = new int[R];
        for (int i = 0; i < R; i++) {
            candidates[i] = Integer.parseInt(st.nextToken());
        }
        
        // 사진틀 (후보 번호를 키로, [추천 수, 게시 시간]을 값으로 관리)
        HashMap<Integer, int[]> frame = new HashMap<>();
        int time = 0;  // 게시 시간 (후보가 게시된 순서)
        
        for (int candidate : candidates) {
            if (frame.containsKey(candidate)) {
                // 이미 게시된 후보라면 추천 수 증가
                frame.get(candidate)[0]++;
            } else {
                // 새로운 후보인 경우
                if (frame.size() == N) {
                    // 사진틀이 꽉 찬 경우, 추천 수와 게시 시간 기준으로 제거
                    int minRecommend = Integer.MAX_VALUE;
                    int earliestTime = Integer.MAX_VALUE;
                    int toRemove = -1;
                    
                    for (Map.Entry<Integer, int[]> entry : frame.entrySet()) {
                        int[] value = entry.getValue();
                        if (value[0] < minRecommend || (value[0] == minRecommend && value[1] < earliestTime)) {
                            minRecommend = value[0];
                            earliestTime = value[1];
                            toRemove = entry.getKey();
                        }
                    }
                    
                    frame.remove(toRemove);
                }
                
                // 새로운 후보 추가
                frame.put(candidate, new int[] {1, time});
            }
            
            time++;
        }
        
        // 남아있는 후보를 오름차순으로 정렬하여 출력
        List<Integer> result = new ArrayList<>(frame.keySet());
        Collections.sort(result);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i < result.size() - 1) {
                sb.append(" ");
            }
        }
        
        System.out.println(sb.toString());
        
        br.close();
    }
}