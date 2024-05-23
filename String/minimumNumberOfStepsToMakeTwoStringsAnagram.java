class Solution {
    public int minSteps(String s, String t) {
        //1347. Minimum Number of Steps to Make Two Strings Anagram
        int frequencyOfS[]= new int[26];
        int frequencyOfT[]=new int[26];
        for(int i=0;i<s.length();i++){
            frequencyOfS[s.charAt(i)-97]++;
            frequencyOfT[t.charAt(i)-97]++;
        }

        // System.out.println("Array elements: ");
        // for (int i = 0; i < frequencyOfT.length; i++) {
        //     System.out.print(frequencyOfT[i] + " ");
        // }
        // System.out.println("Array elements: ");
        // for (int i = 0; i < frequencyOfS.length; i++) {
        //     System.out.print(frequencyOfS[i] + " ");
        // }

        int changes=0;
        for(int j=0;j<26;j++){
            if( frequencyOfS[j]!=0 && frequencyOfS[j]>frequencyOfT[j]){
                changes=changes + frequencyOfS[j]-frequencyOfT[j];
            }
            
        }
        return changes;
    }
}