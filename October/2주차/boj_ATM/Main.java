import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 사람의 수 N 입력 받음
		
		// 입력된 수를 담을 배열 선언
		int[] nums = new int[N];
		int idx = 0;

		// 각 사람이 돈을 인출하는데 걸리는 시간 공백으로 구분하여 입력받음
		for(String num : br.readLine().split(" ")){
			nums[idx++] = Integer.parseInt(num);
		}

		Arrays.sort(nums); // 오름차순으로 정렬

		int[] sums = new int[N+1]; // 각 자리수의 합을 구할 배열 선언
		int sum = 0; // 각 자리수의 합들을 모두 더할 변수 선언

		for(int i=1; i<=N; i++) { // 각 자리수 합 더한 뒤, 자리수 합들을 모두 더함
			sums[i] = sums[i-1] + nums[i-1];
			sum += sums[i];
		}

		System.out.println(sum);
	}
}