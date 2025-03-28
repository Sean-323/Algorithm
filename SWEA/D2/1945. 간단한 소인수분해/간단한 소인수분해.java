import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int[] primeNumbers = new int[5];
            int N = Integer.parseInt(br.readLine().trim());
            int[] primes = {2, 3, 5, 7, 11};

            for (int i = 0; i < primes.length; i++) {
                while (N % primes[i] == 0) {
                    primeNumbers[i]++;
                    N /= primes[i];
                }
            }

            System.out.print("#" + tc + " ");

            for (int i = 0; i < primeNumbers.length; i++) {
                System.out.print(primeNumbers[i] + " ");
            }
            System.out.println();
        }
	}
}