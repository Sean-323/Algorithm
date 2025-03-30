import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
class Solution {
 
    static int N; 
    static char[] tree;
    static int[] leftChild, rightChild; 
    static StringBuilder result; 
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 1; t <= 10; t++) { 
            N = Integer.parseInt(br.readLine()); 
            tree = new char[N + 1];
            leftChild = new int[N + 1];
            rightChild = new int[N + 1];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken()); 
                tree[index] = st.nextToken().charAt(0); 
                if (st.hasMoreTokens()) leftChild[index] = Integer.parseInt(st.nextToken()); 
                if (st.hasMoreTokens()) rightChild[index] = Integer.parseInt(st.nextToken());
            }
            result = new StringBuilder();
            inorder(1);
            bw.write("#" + t + " " + result.toString() + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    static void inorder(int node) {
        if (node == 0) return; 
        inorder(leftChild[node]); 
        result.append(tree[node]); 
        inorder(rightChild[node]); 
    }
}