class Solution {
    public String solution(String polynomial) {
        String[] terms = polynomial.split(" \\+ ");

        int xCoeff = 0;
        int constant = 0;

        for (String t : terms) {
            if (t.contains("x")) {
                if (t.equals("x")) xCoeff += 1;
                else xCoeff += Integer.parseInt(t.substring(0, t.length() - 1));
            } else constant += Integer.parseInt(t);
        }

        if (xCoeff == 0) return String.valueOf(constant);
        if (constant == 0) return (xCoeff == 1) ? "x" : (xCoeff + "x");
        return (xCoeff == 1) ? ("x + " + constant) : (xCoeff + "x + " + constant);
    }
}