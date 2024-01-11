class Solution {
    public int[] solution(int[] answers) {
        int[] result = {};

        int[] stuA = {1, 2, 3, 4, 5};
        int[] stuB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stuC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a = 0, b = 0, c = 0;
        int cntA = 0, cntB = 0, cntC = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == stuA[a])
                cntA++;
            if (answers[i] == stuB[b])
                cntB++;
            if (answers[i] == stuC[c])
                cntC++;
            a++; b++; c++;
            if (a == stuA.length)
                a = 0;
            if (b == stuB.length)
                b = 0;
            if (c == stuC.length)
                c = 0;
        }


        if (cmpNum(cntA, cntB).equals("1")) { //a가 더 클 경우
            if (cmpNum(cntA, cntC).equals("0")) //같으면 1 3 리턴
                result = new int[]{1, 3};
            else if (cmpNum(cntA, cntC).equals("1")) //a가 더 크면
                result = new int[]{1};
            else if (cmpNum(cntA, cntC).equals("-1")) //c가 더 클 경우
                result = new int[]{3};
        } else if (cmpNum(cntA, cntB).equals("-1")) {//b가 더 클 경우
            if (cmpNum(cntB, cntC).equals("0"))
                result = new int[]{2, 3};
            else if (cmpNum(cntB, cntC).equals("1"))
                result = new int[]{2};
            else if (cmpNum(cntB, cntC).equals("-1"))
                result = new int[]{3};
        } else if (cmpNum(cntA, cntB).equals("0")) {
            if (cmpNum(cntA, cntC).equals("0"))
                result = new int[]{1, 2, 3};
            else if (cmpNum(cntA, cntC).equals("1"))
                result = new int[]{1, 2};
            else if (cmpNum(cntA, cntC).equals("-1"))
                result = new int[]{3};
        }

        return result;
    }

    public String cmpNum(int a, int b) { //1 0 -1
        if (a>b)
            return "1";
        else if (a==b)
            return "0";
        else // a<b
            return "-1";
    }
}