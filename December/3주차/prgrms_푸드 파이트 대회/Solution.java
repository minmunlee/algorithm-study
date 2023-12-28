class Solution {
    public String solution(int [] food) {
        StringBuffer sb = new StringBuffer();
        StringBuffer answer = new StringBuffer();
        for (int i = 1; i < food.length; i++)
            sb.append(String.valueOf(i).repeat(food[i]/2));

        answer.append(sb);
        answer.append(sb.reverse());
        answer.insert(answer.length() / 2, "0");
        return answer.toString();
    }
}