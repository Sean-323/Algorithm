import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] grid;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        
        int maxCandy = 0;
        
        // 격자 탐색 (모든 칸에서 인접한 칸과 교환 시도)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 오른쪽과 교환
                if (j + 1 < n) {
                    swap(i, j, i, j + 1);  // 교환
                    maxCandy = Math.max(maxCandy, checkMaxLength());
                    swap(i, j, i, j + 1);  // 복구
                }
                
                // 아래쪽과 교환
                if (i + 1 < n) {
                    swap(i, j, i + 1, j);  // 교환
                    maxCandy = Math.max(maxCandy, checkMaxLength());
                    swap(i, j, i + 1, j);  // 복구
                }
            }
        }
        
        // 결과 출력
        System.out.println(maxCandy);
    }
    
    // 두 위치의 사탕을 교환하는 함수
    static void swap(int i1, int j1, int i2, int j2) {
        char temp = grid[i1][j1];
        grid[i1][j1] = grid[i2][j2];
        grid[i2][j2] = temp;
    }
    
    // 현재 격자 상태에서 최대 연속 길이를 계산하는 함수
    static int checkMaxLength() {
        int maxLength = 0;
        
        // 가로 방향 탐색
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == grid[i][j - 1]) {
                    count++;
                } else {
                    maxLength = Math.max(maxLength, count);
                    count = 1;
                }
            }
            maxLength = Math.max(maxLength, count);  // 마지막 연속 확인
        }
        
        // 세로 방향 탐색
        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (grid[i][j] == grid[i - 1][j]) {
                    count++;
                } else {
                    maxLength = Math.max(maxLength, count);
                    count = 1;
                }
            }
            maxLength = Math.max(maxLength, count);  // 마지막 연속 확인
        }
        
        return maxLength;
    }
}