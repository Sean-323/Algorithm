class Solution {
    public int solution(int n) {
        int count = 0;
        int x = 0;
        
        while (count < n) {
            x++;
            
            if (x % 3 == 0) continue;
            if (String.valueOf(x).contains("3")) continue;
            
            count++;
        }
        
        return x;
    }
}