class Solution {
    public List<String> commonChars(String[] words) {
        //1002. Find Common Characters

        int frequencyArray[][] = new int[words.length][26];
        for(int j=0; j<words.length; j++){
            for(int i=0;i<words[j].length();i++){
                frequencyArray[j][words[j].charAt(i)-'a']++;
            }
        }
        List<String> repeatedString=new ArrayList<>();

        for(int i=0;i<26;i++){
            int count=Integer.MAX_VALUE;
            for(int j=0;j<frequencyArray.length;j++){
                int value=frequencyArray[j][i];
                if(value==0){
                    count=0;
                    break;
                }
                else{
                    if(value<count){
                        count=value;
                    }
                }
            }
            String str=Character.toString((char)(i+'a'));
            for(int k=0;k<count;k++){
                repeatedString.add(str);
            }
        }
        return repeatedString;
    }
}