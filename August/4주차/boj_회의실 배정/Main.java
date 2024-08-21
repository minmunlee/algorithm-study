package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[][] time = new int[N][2];

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                time[i][0] = Integer.parseInt(st.nextToken());
                time[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(time, (o1, o2) -> { // 종료시간 기준 오름차순 정렬
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0]; // 종료시간이 같으면 시작시간이 빠른 게 먼저 오게
                }
                return o1[1] - o2[1];
            });

            int now = 0, count = 0;

            for(int i=0; i<N; i++) {
                if(now <= time[i][0]) {
                    now = time[i][1];
                    count++;
                }
            }

            System.out.print(count);
    }
}