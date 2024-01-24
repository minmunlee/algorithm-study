class Solution {
    String[] Pronunciation = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) { 
        int count = 0;
        for(String b : babbling){
            if(check(b)) count++;
        }
        return count;
    }
    public boolean check(String babblingWord){
        for(String p : Pronunciation){
            babblingWord = deletePronunciation(p, babblingWord);
            if(babblingWord.replace(" ","").length()==0) return true;
        }
        return false;
    }
    
    public String deletePronunciation(String pronunciation, String word) {
        int startIndex = 0;
        int size = pronunciation.length();
        while(startIndex+size<=word.length()){
            String subString = word.substring(startIndex, startIndex+size);
            if(subString.equals(pronunciation)){
                word = word.replaceFirst(pronunciation, " ");
                startIndex++;
            }
            startIndex++;
        }
        return word;
    }
}
