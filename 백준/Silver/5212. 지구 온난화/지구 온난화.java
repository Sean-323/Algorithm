import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        char[][] grid = new char[R][C];
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                grid[r][c] = line.charAt(c);
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        List<int[]> toChange = new ArrayList<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 'X') {
                    int seaCount = 0;
                    for (int[] dir : directions) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (nr < 0 || nr >= R || nc < 0 || nc >= C || grid[nr][nc] == '.') {
                            seaCount++;
                        }
                    }
                    if (seaCount >= 3) {
                        toChange.add(new int[]{r, c});
                    }
                }
            }
        }

        for (int[] pos : toChange) {
            grid[pos[0]][pos[1]] = '.';
        }

        int minRow = R, maxRow = 0;
        int minCol = C, maxCol = 0;
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 'X') {
                    minRow = Math.min(minRow, r);
                    maxRow = Math.max(maxRow, r);
                    minCol = Math.min(minCol, c);
                    maxCol = Math.max(maxCol, c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (minRow <= maxRow && minCol <= maxCol) { 
            for (int r = minRow; r <= maxRow; r++) {
                for (int c = minCol; c <= maxCol; c++) {
                    sb.append(grid[r][c]);
                }
                sb.append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}