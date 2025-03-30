import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int n = 1000000;
        int[] arr = new int[n];
         
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
         
        QuickSort(arr, 0, n-1);
         
        System.out.println(arr[500000]);
    }
 
    private static void QuickSort(int[] arr, int left, int right) {
        //종료
        if(left >= right)
            return;
        //파티셔닝
        int pivot = partition(arr, left, right);
        QuickSort(arr, left, pivot-1);
        QuickSort(arr, pivot+1, right);
         
    }
 
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
         
        int L = left + 1;
        int R = right;
         
        while(L <= R) {
            while(L <= R && arr[L] <= pivot) {
                L++;
            }
            while(L <= R && arr[R] > pivot) {
                R--;
            }
            if(L < R) {
                swap(arr, L, R);
            }
        }
        //피봇 값 교환..
        swap(arr, left, R);
        return R;
         
    }
 
    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
         
    }
 
}