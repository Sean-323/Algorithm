import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 최적화를 위한 Reader 클래스 사용
        Reader in = new Reader();
        int N = in.nextInt();
        
        // 각 수를 저장할 배열 (short로 메모리 절약)
        short[] arr = new short[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextShort();
        }
        
        // 메모리 절약을 위해 byte 배열 사용 (최대 길이가 N이므로 byte로 충분)
        byte[] dp = new byte[N];
        
        // 결과값
        byte max = 0;
        
        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 자기 자신은 길이 1
            
            // 이전 값들을 체크하여 감소 수열 찾기
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = (byte)(dp[j] + 1);
                }
            }
            
            // 최대값 갱신 (별도의 루프 없이 진행)
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        
        // 결과 출력 (StringBuilder 없이 직접 출력)
        System.out.print(max);
    }
    
    // 입력 속도 최적화를 위한 커스텀 Reader 클래스
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }
        
        public short nextShort() throws IOException {
            short ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = (short) (ret * 10 + c - '0');
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? (short) -ret : ret;
        }
        
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
        
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }
}