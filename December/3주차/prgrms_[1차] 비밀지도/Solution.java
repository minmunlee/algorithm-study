class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String format = "%" + n + "s";
        for(int i=0;i<n;i++){
            String[] map1 = String.format(format, Integer.toBinaryString(arr1[i])).split("");
            String[] map2 = String.format(format, Integer.toBinaryString(arr2[i])).split("");
            StringBuilder sb = new StringBuilder("");
            for(int j=0;j<n;j++){
                if(map1[j].equals("1") || map2[j].equals("1")) sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}