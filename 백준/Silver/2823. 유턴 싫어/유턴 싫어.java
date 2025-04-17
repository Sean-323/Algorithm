import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] grid;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        grid = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        System.out.println(isUturnRequired() ? 1 : 0);
    }
    
    static boolean isUturnRequired() {
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (grid[x][y] == '.') {

                    int adjacentRoads = 0;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (0 <= nx && nx < R && 0 <= ny && ny < C && grid[nx][ny] == '.') {
                            adjacentRoads++;
                        }
                    }

                    if (adjacentRoads <= 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}