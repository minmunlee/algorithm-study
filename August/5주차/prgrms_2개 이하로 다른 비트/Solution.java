class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            long tmp = n;
            
            while (true) {
                tmp++;
                if (countDifferentBit(n, tmp) <= 2) {
                    answer[i] = tmp;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public static int countDifferentBit(long n1, long n2) {
        String bin1 = Long.toBinaryString(n1);
        String bin2 = Long.toBinaryString(n2);
        
        int maxLen = Math.max(bin1.length(), bin2.length());
        bin1 = String.format("%" + maxLen + "s", bin1).replace(' ', '0');
        bin2 = String.format("%" + maxLen + "s", bin2).replace(' ', '0');
        
        int cnt = 0;
        for (int i = 0; i < maxLen; i++) {
            if (bin1.charAt(i) != bin2.charAt(i)) {
                cnt++;
            }
        }
        
        return cnt;
    }
}