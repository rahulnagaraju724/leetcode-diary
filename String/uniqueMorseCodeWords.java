class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        //804. Unique Morse Code Words
        String[] charToMorse={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> uniqueMorseCodes=new HashSet<>();
        for(int i=0;i<words.length;i++){
            StringBuilder str=new StringBuilder("");
            for(int j=0;j<words[i].length();j++){
                str.append(charToMorse[words[i].charAt(j)-'a']);
            }
            uniqueMorseCodes.add(str.toString());

        }
        return uniqueMorseCodes.size();
    }
}