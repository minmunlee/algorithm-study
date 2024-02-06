class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = new int[]{-1, 1, 0, 0};
        int[] dw = new int[]{0, 0, -1, 1};

        for (int i = 0; i < dh.length; i++)
            if (h + dh[i] >= 0 && h + dh[i] < board.length &&
                    w + dw[i] >= 0 && w + dw[i] < board.length &&
                    board[h + dh[i]][w + dw[i]].equals(board[h][w]))
                answer++;

        return answer;
    }
}