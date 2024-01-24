class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        int impo = 0; // 발음 불가능한 단어의 개수
        
         // 한 단어씩 살펴보기
        for (String s : babbling) {
            while (s.length() > 0) { // s 단어가 남아있다면 실행
                // 1번 조건 : s가 두 글자 이상이며, 두 글자의 옹알이를 포함할 경우 성공
                if (s.length() >= 2 && (s.startsWith("ye") || s.startsWith("ma"))) {
                    // 추가 조건 : s가 네 글자 이상이며, 앞 두 글자와 뒤 두 글자가 같을 경우 실패
                    if (s.length() >= 4 && s.substring(0, 2).equals(s.substring(2, 4))) {
                        impo++;
                        break;
                    } else {
                        s = s.substring(2);
                    }
                }
                // 2번 조건 : s가 세 글자 이상이며, 세 글자의 옹알이를 포함할 경우
                else if (s.length() >= 3 && (s.startsWith("aya") || s.startsWith("woo"))) {
                    // 추가 조건 : s가 여섯 글자 이상이며, 앞 세 글자와 뒤 세 글자가 같을 경우 실패
                    if (s.length() >= 6 && s.substring(0, 3).equals(s.substring(3, 6))) {
                        impo++;
                        break;
                    } else {
                        s = s.substring(3);
                    }
                } else {
                    impo++;
                    break;
                }
            }
        }
        return answer = babbling.length - impo;
    }
}