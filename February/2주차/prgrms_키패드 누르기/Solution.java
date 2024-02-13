class Solution {
    public static int left = 10, right = 10;
    public static StringBuilder sb = new StringBuilder();

    public String solution(int[] numbers, String hand) {
        for (int i = 0; i < numbers.length; i++) {
            // 왼손으로 누르는 키패드
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                left = numbers[i];
            }
            // 오른손으로 누르는 키패드
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                right = numbers[i];
            }
            // 왼손, 오른손 둘 다 누를 수 있는 키패드
            else {
                int leftDistance = -1, rightDistance = -1, distance = -1;
                if(left == 10 && right == 10) { // 맨 처음에 중간 키패드를 눌러야 할 경우
                    if(hand.equals("left")) {
                        sb.append("L");
                        left = numbers[i];
                    }
                    else {
                        sb.append("R");
                        right = numbers[i];
                    }
                    continue;
                }
                if (numbers[i] == 2) { // 2를 눌러야 할 때
                    for (int j = 0; j < 2; j++) { // 왼손, 오른손 거리 구하기 (그래서 2번)
                        int tmp = j == 0 ? left : right;
                        switch (tmp) { // 거리를 구함
                            case 2:
                                distance = 0;
                                continue;
                            case 1:
                            case 3:
                            case 5:
                                distance = 1;
                                break;
                            case 4:
                            case 6:
                            case 8:
                                distance = 2;
                                break;
                            case 7:
                            case 9:
                            case 0:
                                distance = 3;
                                break;
                            case 10:
                                distance = 4;
                                break;
                        }
                        if (tmp == left) leftDistance = distance; // 왼손
                        else rightDistance = distance; // 오른손
                    }
                    // 더 거리가 가까운 손을 찾기
                    checkRightOrLeft(leftDistance, rightDistance, numbers[i], hand);
                } else if (numbers[i] == 5) { // 5를 눌러야 할 때
                    for (int j = 0; j < 2; j++) {
                        int tmp = j == 0 ? left : right;
                        switch (tmp) {
                            case 5:
                                distance = 0;
                                break;
                            case 2:
                            case 4:
                            case 6:
                            case 8:
                                distance = 1;
                                break;
                            case 1:
                            case 3:
                            case 7:
                            case 9:
                            case 0:
                                distance = 2;
                                break;
                            case 10:
                                distance = 3;
                                break;
                        }
                        if (tmp == left) leftDistance = distance;
                        else rightDistance = distance;
                    }
                    checkRightOrLeft(leftDistance, rightDistance, numbers[i], hand);
                } else if (numbers[i] == 8) { // 8을 눌러야 할 때
                    for (int j = 0; j < 2; j++) {
                        int tmp = j == 0 ? left : right;
                        switch (tmp) {
                            case 8:
                                distance = 0;
                                break;
                            case 5:
                            case 7:
                            case 9:
                            case 0:
                                distance = 1;
                                break;
                            case 4:
                            case 2:
                            case 6:
                            case 10:
                                distance = 2;
                                break;
                            case 1:
                            case 3:
                                distance = 3;
                                break;
                        }
                        if (tmp == left) leftDistance = distance;
                        else rightDistance = distance;
                    }
                    checkRightOrLeft(leftDistance, rightDistance, numbers[i], hand);
                } else if (numbers[i] == 0) {
                    for (int j = 0; j < 2; j++) {
                        int tmp = j == 0 ? left : right;
                        switch (tmp) {
                            case 0:
                                distance = 0;
                                break;
                            case 8:
                            case 10:
                                distance = 1;
                                break;
                            case 7:
                            case 5:
                            case 9:
                                distance = 2;
                                break;
                            case 4:
                            case 2:
                            case 6:
                                distance = 3;
                                break;
                            case 1:
                            case 3:
                                distance = 4;
                                break;
                        }
                        if (tmp == left) leftDistance = distance;
                        else rightDistance = distance;
                    }
                    checkRightOrLeft(leftDistance, rightDistance, numbers[i], hand);
                }
            }
        }

        return sb.toString();
    }

    public static void checkRightOrLeft(int leftDistance, int rightDistance, int number, String hand) {
        if (leftDistance < rightDistance) {
            left = number; // 직전 손 위치에 넣어줌
            sb.append("L");
        } else if (leftDistance > rightDistance) {
            right = number;
            sb.append("R");
        } else { // 거리가 같을 때
            if (hand.equals("left")) {
                left = number;
                sb.append("L");
            } else {
                right = number;
                sb.append("R");
            }
        }
    }
}