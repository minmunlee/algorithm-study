import java.util.Arrays;

class Solution {
    public static int solution(int[] nums) {
        int[] arr = Arrays.stream(nums).distinct().toArray();
        return arr.length >= nums.length / 2 ? nums.length / 2 : arr.length;
    }
}
