import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        int N = Integer.parseInt(br.readLine().trim());
        int[][] dices = new int[N][6];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 각 면의 마주 보는 면 인덱스 설정
        Map<Integer, Integer> opposite = new HashMap<>();
        opposite.put(0, 5);
        opposite.put(1, 3);
        opposite.put(2, 4);
        opposite.put(3, 1);
        opposite.put(4, 2);
        opposite.put(5, 0);
        
        int maxSum = 0;
        
        // 첫 번째 주사위의 아랫면을 모든 면으로 설정하며 최대 합을 구한다
        for (int startFace = 0; startFace < 6; startFace++) {
            int total = 0;
            int currentBottom = dices[0][startFace];
            int currentTop = dices[0][opposite.get(startFace)];
            
            // 첫 주사위에서 윗면, 아랫면을 제외한 나머지 면 중 최대 값 선택
            int firstDiceMax = 0;
            for (int i = 0; i < 6; i++) {
                if (i != startFace && i != opposite.get(startFace)) {
                    firstDiceMax = Math.max(firstDiceMax, dices[0][i]);
                }
            }
            total += firstDiceMax;
            
            // 두 번째 주사위부터는 위의 주사위의 윗면이 현재 주사위의 아랫면이 된다
            for (int i = 1; i < N; i++) {
                currentBottom = currentTop;
                
                // 현재 주사위에서 아랫면의 인덱스 찾기
                int currentBottomIndex = -1;
                for (int j = 0; j < 6; j++) {
                    if (dices[i][j] == currentBottom) {
                        currentBottomIndex = j;
                        break;
                    }
                }
                
                int currentTopIndex = opposite.get(currentBottomIndex);
                currentTop = dices[i][currentTopIndex];
                
                // 현재 주사위에서 윗면과 아랫면을 제외한 네 면 중 최대 값 선택
                int currentDiceMax = 0;
                for (int j = 0; j < 6; j++) {
                    if (j != currentBottomIndex && j != currentTopIndex) {
                        currentDiceMax = Math.max(currentDiceMax, dices[i][j]);
                    }
                }
                total += currentDiceMax;
            }
            
            // 최대 합 갱신
            maxSum = Math.max(maxSum, total);
        }
        
        System.out.println(maxSum);
        br.close();
    }
}