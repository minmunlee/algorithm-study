import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 각 사용자의 인덱스를 저장할 맵
        Map<String, Integer> map = new HashMap<>();
        // 각 사용자를 신고한 신고자 목록을 저장할 맵
        Map<String, HashSet<String>> sin = new HashMap<>();
        
        // 각 사용자의 인덱스와 신고 대상을 맵에 저장
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i], i); 
            sin.put(id_list[i], new HashSet<>()); 
        }
        
        // 각 사용자가 신고한 대상을 저장하는 맵에 데이터 저장
        for(String s : report) {
            String[] str = s.split(" ");
            String reporter = str[0]; // 신고자
            String singo = str[1]; // 신고 대상자
            sin.get(singo).add(reporter); // 신고 대상자를 신고한 신고자 추가
        }
        
        // 각 사용자의 신고를 확인하여 k번 이상 신고된 경우 처리
        for(int i=0; i<id_list.length; i++) {
            HashSet<String> hashset = sin.get(id_list[i]); // 해당 사용자의 신고 목록 조회
            if(hashset.size() >= k) {
                for(String name : hashset) {
                    answer[map.get(name)]++;
                }
            }
        }
        
        return answer; // 결과 반환
    }
}
