class Solution {
    static int[] n;
    static int t;
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        n = numbers;
        t = target;
        dfs(0, 0);
        return answer;
    }
    
    static void dfs(int idx, int sum) {
        if(idx == n.length) {
            if(t == sum) answer++;
            return;
        }
        
        dfs(idx+1, sum + n[idx]);
        dfs(idx+1, sum - n[idx]);
    }
}