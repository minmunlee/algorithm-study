import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
                String s1IndexS = s1.substring(n,n+1);
                String s2IndexS = s2.substring(n,n+1);
                if(s1IndexS.equals(s2IndexS)){
                    return s1.compareTo(s2);
                }
				return s1IndexS.compareTo(s2IndexS);
			}
		});
        return strings;
    }
}