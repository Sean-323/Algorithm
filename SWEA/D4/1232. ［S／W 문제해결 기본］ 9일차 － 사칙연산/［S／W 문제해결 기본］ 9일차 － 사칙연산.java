import java.io.*;
 
class Solution
{
    static int N;
    static String[] values; // 연산자 또는 숫자 저장
    static int[][] children; // [노드번호][0] = left, [노드번호][1] = right
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = 10; // SWEA 문제에서 항상 10개 테스트케이스 제공
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine()); // 노드 개수 입력
            values = new String[N + 1]; // 노드 값 저장 (숫자 or 연산자)
            children = new int[N + 1][2]; // 자식 노드 정보 저장
 
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                int num = Integer.parseInt(input[0]);
                values[num] = input[1]; // 연산자 또는 숫자 저장
 
                if (input.length > 2) { // 연산자 노드인 경우 자식 저장
                    children[num][0] = Integer.parseInt(input[2]); // 왼쪽 자식
                    children[num][1] = Integer.parseInt(input[3]); // 오른쪽 자식
                }
            }
 
            double result = postOrder(1); // 루트(1번 노드)부터 연산 수행
            System.out.println("#" + tc + " " + (int) result); // 결과를 정수형으로 변환하여 출력
        }
    }
 
    static double postOrder(int node) {
        if (children[node][0] == 0 && children[node][1] == 0) { // 숫자 노드
            return Double.parseDouble(values[node]);
        }
 
        double leftValue = postOrder(children[node][0]); // 왼쪽 자식 계산
        double rightValue = postOrder(children[node][1]); // 오른쪽 자식 계산
 
        switch (values[node]) {
            case "+": return leftValue + rightValue;
            case "-": return leftValue - rightValue;
            case "*": return leftValue * rightValue;
            case "/": return leftValue * 1.0 / rightValue;
        }
        return 0;
    }
}