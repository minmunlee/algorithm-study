import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, V;
    public static boolean[][] arr; // 두 정점이 간선으로 이어져있는지
    public static boolean[] check; // 해당 노드를 방문했는지 확인
    public static Queue<Integer> queue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken()); // 정점의 개수
        M = Integer.parseInt(str.nextToken()); // 간선의 개수
        V = Integer.parseInt(str.nextToken()); // 탐색을 시작할 정점의 번호

        arr = new boolean[N + 1][N + 1];
        check = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(str.nextToken());
            int n2 = Integer.parseInt(str.nextToken());

            arr[n1][n2] = arr[n2][n1] = true;
        }

        dfs(V);
        System.out.println();
        check = new boolean[N + 1];
        bfs(V);

    }

    public static void dfs(int V){
        check[V] = true;
        System.out.print(V + " ");

        for(int i = 1; i <= N; i++){
            if(!check[i] && arr[V][i] == true){
                dfs(i);
            }
        }
    }

    public static void bfs(int V){
        queue = new LinkedList<>();
        queue.add(V);
        check[V] = true;
        System.out.print(V + " ");

        while(!queue.isEmpty()){
            V = queue.poll();
            for(int i = 1; i <= N; i++){
                if(arr[V][i] == true && !check[i]){
                    queue.add(i);
                    check[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

}
