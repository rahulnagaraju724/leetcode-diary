class Solution {
    public boolean closeStrings(String word1, String word2) {
        // 1657. Determine if Two Strings Are Close
        if(word1.length()!=word2.length()){
             System.out.println("Returning false inside length not equal");
            return false;
        }
        int [] frequencyOfWord1=new int[26];
        int [] frequencyOfWord2=new int[26];
        for(int i=0;i<word1.length();i++){
            frequencyOfWord1[word1.charAt(i)-97]++;
            frequencyOfWord2[word2.charAt(i)-97]++;
        }
        //Not needed at all, will sort and then check
        // int sum1=0,sum2=0;
        for(int i=0;i<26;i++){
            // if(frequencyOfWord1[i]!=frequencyOfWord2[i]){
            //     return false;
            // }
            if(frequencyOfWord1[i]!=0 && frequencyOfWord2[i]==0 || frequencyOfWord1[i]==0 && frequencyOfWord2[i]!=0){
                System.out.println("Returning false inside 0");
                return false;
            }
            // sum1+=frequencyOfWord1[i];
            // sum2+=frequencyOfWord2[i];
        }
        // if(sum1!=sum2){
        //     System.out.println("Returning false inside sum if");
        //     return false;
        // }
        Arrays.sort(frequencyOfWord1);
        Arrays.sort(frequencyOfWord2);

        for (int i = 0; i < 26; i++) {
            if (frequencyOfWord1[i] != frequencyOfWord2[i]) {
                return false;
            }
        }
        return true;
    }
}