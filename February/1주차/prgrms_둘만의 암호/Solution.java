public class Solution {
    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        // skip 문자열에 포함된 문자들을 알파벳 문자열에서 제외
        for (char sk : skip.toCharArray()) {
            alphabet = alphabet.replace(Character.toString(sk), "");
        }

        for (char a : s.toCharArray()) {
            // 각 문자를 주어진 index만큼 오른쪽으로 이동시켜 새로운 문자열을 생성. 알파벳 배열 넘어 갈 경우 길이 나눠서 나머지 값 넣음
            int idx = (alphabet.indexOf(a) + index) % alphabet.length(); 
            answer.append(alphabet.charAt(idx));
        }

        return answer.toString();
    }
}
