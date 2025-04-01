import java.util.*;

public class Main {

    static class Brick implements Comparable<Brick> {
        int index, s, h, w;

        Brick(int index, int s, int h, int w) {
            this.index = index;
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.s - this.s; // 넓이 내림차순
        }
    }

    static int[] dy;
    static int[] prev;

    private static void solution(ArrayList<Brick> arr) {
        Collections.sort(arr);
        int n = arr.size();
        dy = new int[n];
        prev = new int[n];

        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            dy[i] = arr.get(i).h;
            prev[i] = -1; // 초기화
            for (int j = 0; j < i; j++) {
                if (arr.get(j).w > arr.get(i).w && dy[j] + arr.get(i).h > dy[i]) {
                    dy[i] = dy[j] + arr.get(i).h;
                    prev[i] = j;
                }
            }
            if (dy[i] > dy[maxIdx]) maxIdx = i;
        }

        LinkedList<Integer> answer = new LinkedList<>();
        while (maxIdx != -1) {
            answer.addFirst(arr.get(maxIdx).index);
            maxIdx = prev[maxIdx];
        }

        System.out.println(answer.size());
        for (int i = answer.size() - 1; i >= 0; i--) System.out.println(answer.get(i));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Brick> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Brick(i + 1, s, h, w)); 
        }

        solution(arr);
    }
}
