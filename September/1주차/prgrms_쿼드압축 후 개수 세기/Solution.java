class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2]; // 0 또는 1의 값
        int len = arr.length;
        int r = len; // 변하는 값 size = 8 일 경우 8 -> 4 -> 2로 변함
        int count = 0;
        
        for(int temp = len; temp > 1; temp/=2) {
            count++; 
        }

        for(int c = 0; c<count; c++) { // len = 2의 count 제곱. count만큼 반복. 8이면 3번, 16이면 4번
            for(int i=0; i<len; i+=r) { // 검사 시작위치 i 지정
                for(int j=0; j<len; j+=r) { // 검사 시작위치 j 지정
                    boolean isSame = true;
                    int before = -1;
                    for(int ci=0; ci<r; ci++) { // 정해진 시작위치부터 설정한 범위(+0 ~ +r)까지 반복하며 같은 숫자인지 검사
                        for(int cj=0; cj<r; cj++) {
                            if(ci == 0 && cj == 0) {
                                before = arr[i+ci][j+cj];
                                continue;
                            }
                            // 직전 숫자와 다르거나, 이미 전에 하나로 합쳐진 곳이면 반복 끝  
                            if(arr[i+ci][j+cj] != before || (arr[i+ci][j+cj] != 0 && arr[i+ci][j+cj] != 1)) {
                                isSame = false;
                                break;
                            }
                            before = arr[i+ci][j+cj];
                        }
                        if(!isSame) break;
                    }
                    if(isSame) { // 지정한 범위의 숫자가 모두 같을 때
                        for(int ci=0; ci<r; ci++) {
                            for(int cj=0; cj<r; cj++) {
                                arr[i+ci][j+cj] = -1; // 이미 합쳐진 거라고 표시
                            }
                        }
                        answer[before]++; // 다 합쳐서 하나의 수가 됐으니 그 숫자 개수 +1; 
                    }
                }
            }
            r /= 2; // 범위 줄여나감
        }

        for(int i=0; i<len; i++) { // 마지막까지 합쳐지지 못한 것들 카운트 
            for(int j=0; j<len; j++) {
                if(arr[i][j] == 0) {
                    answer[0]++;
                }
                else if(arr[i][j] == 1) {
                    answer[1]++;
                }
            }
        }
        
        return answer;
    }
}