class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int worstRank = 0;
        int bestRank = 0;
        int matchedCount = 0; // 0이 아닌 숫자들 중 맞춘 번호 개수 (최소 개수)
        int zeroCount = 0;

        for (int n : lottos) {
            if (n == 0) {
                zeroCount++;
            } else {
                for (int wn : win_nums) {
                    if (n == wn) {
                        matchedCount++;
                        break;
                    }
                }
            }
        }

        int totalMatches = matchedCount + zeroCount; // 최대 개수

        worstRank = getRank(matchedCount);
        bestRank = getRank(totalMatches);

        int[] answer = {bestRank, worstRank};

        return answer;
    }

    // 랭크를 구하는 메서드
    public int getRank(int matchedCount) {
        switch (matchedCount) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}
