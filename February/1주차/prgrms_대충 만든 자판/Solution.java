class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int idx = 101, tmp, count;

        for (int i = 0; i < targets.length; i++) {
            count = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                for (int k = 0; k < keymap.length; k++) {
                    tmp = findIndex(keymap[k], targets[i].charAt(j));

                    if (tmp == -1) {
                        if (!(idx > 0 && idx < 101))
                            idx = tmp;
                    } else {
                        if (idx == -1)
                            idx = tmp;
                        else
                            idx = Math.min(idx, tmp);
                    }
                }

                if (idx == -1)
                    break;

                count += idx;
                idx = 101;
            }

            if (idx == -1)
                answer[i] = idx;
            else
                answer[i] = count;
        }

        return answer;
    }

    public int findIndex(String str, char c) {
        int idx = str.indexOf(c);
        return idx == -1 ? -1 : idx + 1;
    }
}