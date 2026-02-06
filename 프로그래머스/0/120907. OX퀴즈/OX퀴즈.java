class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] t = quiz[i].split(" "); 
            int a = Integer.parseInt(t[0]);
            
            String op = t[1];
            int b = Integer.parseInt(t[2]);
            
            int expected = Integer.parseInt(t[4]);

            int calc = op.equals("+") ? (a + b) : (a - b);
            answer[i] = (calc == expected) ? "O" : "X";
        }

        return answer;
    }
}