import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        String str = br.readLine().trim();


        String result = reverseWords(str);

        //출력
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    //로직
    private static String reverseWords(String str) {

        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean isTag = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 태그 시작
            if (ch == '<') {
                // 태그 시작 전 단어가 있으면 뒤집어서 추가
                if (temp.length() > 0) {
                    result.append(temp.reverse());
                    temp.setLength(0);
                }

                isTag = true;
                result.append(ch);
            }

            // 태그 끝
            else if (ch == '>') {
                isTag = false;
                result.append(ch);
            }

            // 태그 내부 문자
            else if (isTag) result.append(ch);

                // 공백
            else if (ch == ' ') {
                // 공백 전 단어가 있으면 뒤집어서 추가
                if (str.length() > 0) {
                    result.append(temp.reverse());
                    temp.setLength(0);
                }

                result.append(ch);
            }
            // 일반 문자
            else temp.append(ch);
        }

        if (temp.length() > 0) result.append(temp.reverse());

        return result.toString();
    }
}
