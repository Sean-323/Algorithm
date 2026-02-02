import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer;
        
        Arrays.sort(numbers);
        answer = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        
        return answer;
    }
}
