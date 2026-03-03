import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] M = new int[10][10];
    static int[] S = {0 , 5, 5, 5, 5, 5}; // 남은 색종이 수
    static int result = Integer.MAX_VALUE; // 최소로 사용한 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) M[i][j] = Integer.parseInt(st.nextToken());
        }
        
        bakctracking(0, 0);
        
        if (result == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(result);
    }
    
    private static void bakctracking(int xy, int useCnt) {
        if (xy == 100) {
            result = Math.min(result, useCnt);
            return;
        }
        
        int x = xy % 10;
        int y = xy / 10;
        
        if (result <= useCnt) return;
        
        if ((M[y][x]) == 1) {
            for (int i = 5; i > 0; i--) {
                if (S[i] > 0 && check (x, y, i)) {
                    S[i]--;
                    fill(x, y, i, 0);
                    
                    bakctracking(xy + 1, useCnt + 1);
                    S[i]++;
                    fill(x, y, i, 1);
                }
            }
        } else bakctracking(xy + 1, useCnt);
    }
    
    private static void fill(int x, int y, int size, int num) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                M[i][j] = num;
            }
        }
    }
    
    private static boolean check(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) return false;
        
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (M[i][j] != 1) return false;
            }
        }
        
        return true;
    }

}
