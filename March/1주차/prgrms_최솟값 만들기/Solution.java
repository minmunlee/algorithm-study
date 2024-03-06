import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        // A, B 배열 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        int size = B.length - 1;
        
        for(int i=0; i<A.length; i++)
            answer += A[i] * B[size-i];

        return answer;
    }
}