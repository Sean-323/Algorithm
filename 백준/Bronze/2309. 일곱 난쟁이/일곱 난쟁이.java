import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 9명의 난쟁이 키 입력 받기
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 7명의 난쟁이 찾기 (합이 100이 되는 조합)
        int[] result = findSevenDwarfs(arr);
        
        // 결과 출력
        for (int height : result) {
            sb.append(height).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
    
    static int[] findSevenDwarfs(int[] arr) {
        // 모든 9명 중 7명을 선택하는 조합 확인
        for (int a = 0; a < 9; a++) {
            for (int b = a + 1; b < 9; b++) {
                for (int c = b + 1; c < 9; c++) {
                    for (int d = c + 1; d < 9; d++) {
                        for (int e = d + 1; e < 9; e++) {
                            for (int f = e + 1; f < 9; f++) {
                                for (int g = f + 1; g < 9; g++) {
                                    // 7명을 선택하여 배열 생성
                                    int[] selected = {
                                        arr[a], arr[b], arr[c], arr[d], 
                                        arr[e], arr[f], arr[g]
                                    };
                                    
                                    // 합이 100인지 확인
                                    int sum = 0;
                                    for (int height : selected) {
                                        sum += height;
                                    }
                                    
                                    if (sum == 100) {
                                        // 오름차순 정렬
                                        Arrays.sort(selected);
                                        return selected;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        // 결과가 없는 경우 (문제 조건상 항상 해가 존재함)
        return new int[0];
    }
}