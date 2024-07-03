import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        if(N == K) {
            System.out.print(0 + "\n" + N);
        }
        else {
            BFS(N, K);
        }
    }

    public static void BFS(int N, int K) {
        int len = N < K ? K * 2 + 1 : N + 1; // 메모리 절약 위함
        int[] time = new int[len];
        int[] back = new int[len];
        Queue<Integer> que = new LinkedList<>();
        que.add(N);

        while(!que.isEmpty()) {
            int zum = que.poll();

            for(int move : new int[]{zum + 1, zum - 1, zum * 2}) {
                if(move < 0 || move >= len || time[move] != 0) continue;

                time[move] = time[zum] + 1;
                back[move] = zum; // 어디서 왔는지를 저장함 (4->5로 왔으면 back[5] = 4)
                que.add(move);
            }
        }

        System.out.println(time[K]);

        StringBuilder sb = new StringBuilder();
        int end = K;

        while(end != N) {
            sb.insert(0, end+" "); // insert로 뒤가 아닌 앞에 문자열 넣음
            end = back[end];
        }
        sb.insert(0, N+" ");
        System.out.print(sb);
    }
}