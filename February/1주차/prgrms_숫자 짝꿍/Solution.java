
class Solution {
    public static String solution(String x, String y) {

        StringBuilder sb = new StringBuilder();
        int[] a = new int[10];
        int[] b = new int[10];

        add_array(x, a);
        add_array(y, b);

        for(int i=a.length-1; i>=0; i--) { //가장 큰 수부터 차례로 뽑아내야 하기 때문에 내림차순 루프
            while (a[i] >= 1 && b[i] >= 1) { //두 요소 중 하나라도 1 미만이면 겹치는 수가 없는 거
                sb.append(i);
                a[i]--;
                b[i]--;
            }
        }

        if (sb.toString().equals(""))
            return "-1";
        else if (sb.toString().startsWith("0"))
            return "0";
        else
            return sb.toString();

    }
    private static int[] add_array(String str, int[] arr) {
        for (int i=0; i<str.length(); i++)
            arr[str.charAt(i) - '0']++;

        return arr;
    }
}