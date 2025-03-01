import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        // 정규식을 사용하여 태그와 일반 텍스트를 분리
        // 스트림을 사용한 "단일 표현식"으로 변환
        System.out.println(
            Pattern.compile("(<.*?>)|([^<>]+)")
                .matcher(input)
                .results()
                .map(match -> {
                    String group = match.group();
                    // 태그인 경우 그대로 반환
                    if (group.startsWith("<") && group.endsWith(">")) {
                        return group;
                    } 
                    // 일반 텍스트인 경우 단어별로 뒤집기
                    return Arrays.stream(group.split(" "))
                            .map(word -> new StringBuilder(word).reverse().toString())
                            .collect(Collectors.joining(" "));
                })
                .collect(Collectors.joining())
        );
    }
}