class Solution {
    public int solution(int num, int k) {
        String s = String.valueOf(num);
        int idx = s.indexOf(String.valueOf(k)); 
        return (idx == -1) ? -1 : idx + 1;   
    }
}