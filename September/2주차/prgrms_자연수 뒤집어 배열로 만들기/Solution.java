import java.util.*;
class Solution {
    public ArrayList solution(long n) {
        ArrayList<Long> arr = new ArrayList<>();
        while(n>0){
            arr.add(n%10);
            n=n/10;
        }
        return arr;
    }
}