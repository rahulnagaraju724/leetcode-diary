class Solution {
    public String customSortString(String order, String s) {
        //791. Custom Sort String
        int[] frequency=new int[26];
        for(int i=0;i<s.length();i++){
            frequency[s.charAt(i)-'a']++;
        }
        
        StringBuilder str=new StringBuilder();

        for(int i=0;i<order.length();i++){
            char element=order.charAt(i);
            while(frequency[element-'a']>0){
                str.append(element);
                frequency[element-'a']--;
            }
        }
        for(int i=0;i<26;i++){
           while(frequency[i]>0){
                str.append((char)(i+'a'));
                frequency[i]--;
            } 
        }
        return str.toString();
    }
}