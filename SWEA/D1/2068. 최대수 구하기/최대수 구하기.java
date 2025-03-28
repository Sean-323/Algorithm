import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
         Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int[] nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = sc.nextInt();
            }
            int mx = 0;
 
            for (int i = 0; i < nums.length; i++) {
                if (mx < nums[i]) {
                    mx = nums[i];
                }
            }
            System.out.println("#" + tc + " " + mx);
        }
    }
}