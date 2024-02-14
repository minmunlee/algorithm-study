import java.util.*;

class Solution {
    static Map<Integer, int[]> keypad = new HashMap<>();
    static int[] leftP = new int[]{3, 0};
    static int[] rightP = new int[]{3, 2};

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        keypad.put(1, new int[]{0, 0});
        keypad.put(2, new int[]{0, 1});
        keypad.put(3, new int[]{0, 2});
        keypad.put(4, new int[]{1, 0});
        keypad.put(5, new int[]{1, 1});
        keypad.put(6, new int[]{1, 2});
        keypad.put(7, new int[]{2, 0});
        keypad.put(8, new int[]{2, 1});
        keypad.put(9, new int[]{2, 2});
        keypad.put(0, new int[]{3, 1});

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 3 == 1) { //1, 4, 7일 때
                sb.append("L");
                leftP = keypad.get(numbers[i]);
            } else if (numbers[i] % 3 == 2 || numbers[i] == 0) { //2, 5, 8, 0일 때
                sb.append(detectLR(keypad.get(numbers[i]), leftP, rightP, hand));
            } else { //3, 6, 9일 때
                sb.append("R");
                rightP = keypad.get(numbers[i]);
            }
        }

        return sb.toString();
    }

    public String detectLR(int[] point, int[] left, int[] right, String hand) {
        int l = Math.abs(left[0] - point[0]) + Math.abs(left[1] - point[1]);
        int r = Math.abs(right[0] - point[0]) + Math.abs(right[1] - point[1]);
        String handle;

        if (l < r) { //근거리 L
            leftP = point;
            handle = "L";
        } else if (r < l) { //근거리 R
            rightP = point;
            handle = "R";
        } else { //동일 거리
            if (hand.equals("left")) { //왼손잡이
                leftP = point;
                handle = "L";
            } else { //오른손잡이
                rightP = point;
                handle = "R";
            }
        }

        return handle;
    }
}