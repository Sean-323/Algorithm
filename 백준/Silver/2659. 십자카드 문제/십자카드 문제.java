import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    // 숫자의 최소 회전형태 계산
    static int minRotation(String num) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            String rotated = num.substring(i) + num.substring(0, i);
            min = Math.min(min, Integer.parseInt(rotated));
        }
        return min;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        String cards = br.readLine().replace(" ", "");
        int target = minRotation(cards);
        
        // 전체 최소 회전형태 목록 생성
        Set<Integer> rotations = new HashSet<>();
        for (int n = 1111; n < 10000; n++) {
            String numStr = String.valueOf(n);
            if (!numStr.contains("0")) {  // 조건: 숫자에 0이 없어야 함
                rotations.add(minRotation(numStr));
            }
        }
        
        // 정렬 후 위치 찾기
        List<Integer> sortedRots = new ArrayList<>(rotations);
        Collections.sort(sortedRots);
        
        System.out.println(sortedRots.indexOf(target) + 1);
    }
}