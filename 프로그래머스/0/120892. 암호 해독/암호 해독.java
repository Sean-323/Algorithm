class Solution {
    public String solution(String cipher, int code) {
        StringBuilder answer = new StringBuilder();

        char[] arr = cipher.toCharArray();

        for (int i = code - 1; i < arr.length; i += code) answer.append(arr[i]);

        return answer.toString();
    }
}