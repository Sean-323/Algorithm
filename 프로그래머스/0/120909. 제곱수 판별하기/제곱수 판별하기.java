class Solution {
    public int solution(int n) {
        int r = (int) Math.sqrt(n);  
        return (r * r == n) ? 1 : 2;  
    }
}