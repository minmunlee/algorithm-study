import java.util.ArrayList;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        ArrayList<String> arrA = new ArrayList<>();
        ArrayList<String> arrB = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        String[] result;


        for(int i=0; i<arr1.length; i++) {
            arrA.add(Integer.toString(arr1[i], 2));
            arrB.add(Integer.toString(arr2[i], 2));
        }
        arrA = formatting(n, arrA);
        arrB = formatting(n, arrB);

        for (int i = 0; i < arrA.size(); i++) {
            StringBuffer sb1 = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();
            for (int j = 0; j < arrA.get(i).length(); j++) {
                if (arrA.get(i).charAt(j)=='1' || (arrB.get(i).charAt(j)=='1'))
                    sb1 = sb1.append("1");
                else
                    sb1 = sb1.append("0");
            }
            for (int k=0; k<arrA.get(i).length(); k++) {
                if(sb1.charAt(k)=='1')
                    sb2.append("#");
                else
                    sb2.append(" ");
            }
            res.add(sb2.toString());
        }

        result = res.toArray(new String[res.size()]);
        return result;
    }

    private ArrayList<String> formatting(int n, ArrayList<String> lst) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb;

        for (int i = 0; i < lst.size(); i++) {
            sb = new StringBuilder();
            if (lst.get(i).length() < n)
                sb.append("0".repeat(n - lst.get(i).length()));
            sb.append(lst.get(i));
            result.add(sb.toString());
        }
        return result;
    }
}