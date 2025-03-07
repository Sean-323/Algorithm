import java.io.*;
import java.util.*;

public class Main {
    // 최대공약수 구하기
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // 최소공배수 구하기
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
    
    // 세 수의 최소공배수 구하기
    public static int lcmV3(int a, int b, int c) {
        return lcm(lcm(a, b), c);
    }
    
    public static int solution(int[] num) {
        int minLcm = Integer.MAX_VALUE;
        
        // 세 수의 조합 모두 찾기
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                for (int k = j + 1; k < num.length; k++) {
                    int currentLcm = lcmV3(num[i], num[j], num[k]);
                    minLcm = Math.min(minLcm, currentLcm);
                }
            }
        }
        
        return minLcm;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        // 입력
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[input.length];
        
        for (int i = 0; i < input.length; i++) numbers[i] = Integer.parseInt(input[i]);
       
        int result = solution(numbers);
        
        // 출력
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}