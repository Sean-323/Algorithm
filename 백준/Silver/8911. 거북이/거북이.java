import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        String[] commands = new String[n];
        for (int i = 0; i < n; i++) {
            commands[i] = br.readLine().trim();
        }
        
        StringBuilder sb = new StringBuilder();
        for (String command : commands) {
            sb.append(turtle(command)).append('\n');
        }
        
        System.out.print(sb.toString());
    }
    
    static int turtle(String command) {
        int x = 0, y = 0; 
        int direction = 0;  

        int[] dx = {0, 1, 0, -1};  
        int[] dy = {1, 0, -1, 0};  

        List<int[]> visited = new ArrayList<>();
        visited.add(new int[]{x, y});

        for (char c : command.toCharArray()) {
            if (c == 'F') {
                x += dx[direction];
                y += dy[direction];
            } else if (c == 'B') {
                x -= dx[direction];
                y -= dy[direction];
            } else if (c == 'L') {
                direction = (direction + 3) % 4;  
            } else if (c == 'R') {
                direction = (direction + 1) % 4;  
            }
            visited.add(new int[]{x, y});
        }

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for (int[] pos : visited) {
            minX = Math.min(minX, pos[0]);
            maxX = Math.max(maxX, pos[0]);
            minY = Math.min(minY, pos[1]);
            maxY = Math.max(maxY, pos[1]);
        }

        return (maxX - minX) * (maxY - minY);
    }
}