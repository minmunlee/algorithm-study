class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder("");
        for(int i=1;i<food.length;i++){
            for(int j=0;j<food[i]/2;j++){
                sb.append(i);
            }
        }
        String left = sb.toString();
        sb.append("0").append(new StringBuilder(left).reverse().toString());
        return sb.toString();
    }
}