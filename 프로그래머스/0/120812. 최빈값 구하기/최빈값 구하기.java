class Solution {
    public int solution(int[] array) {
        int[] cnt = new int[1001];

        for (int x : array) cnt[x]++;

        int max = 0;
        int mode = -1;
        boolean duplicated = false;

        for (int v = 0; v <= 1000; v++) {
            if (cnt[v] > max) {
                max = cnt[v];
                mode = v;
                duplicated = false;      
            } else if (cnt[v] == max && max != 0) {
                duplicated = true;      
            }
        }

        return duplicated ? -1 : mode;
    }
}