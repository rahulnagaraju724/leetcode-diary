class Solution {
    public List<List<String>> partition(String s) {
        //131. Palindrome Partitioning
        List<List<String>> results=new ArrayList<>();
        partition(s,results,0,new ArrayList<>());
        return results;
    }
    public void partition(String s, List<List<String>> results,int index,List<String> answer) {
        if(index==s.length()){
            results.add(new ArrayList<>(answer));
            return;
        }
        if(index<s.length()){
            for(int i=1;index+i<=s.length();i++){
                if(isp(s.substring(index,index+i))){// check if palindrome
                    answer.add(s.substring(index,index+i));
                    partition(s,results,index+i,answer);
                    answer.remove(answer.size()-1);
                }
                
        }
    }
}
    // public boolean isPalindrome(String str){
    //     int strLength = str.length();
    //     for(int i=0; i< str.length()/2;i++){
    //         if(str.charAt(i) != str.charAt(strLength-1-i)){
    //             return false;
    //         }
    //     }

    //     return true;

    // }

    // public boolean isp(String s)
    // {
    //     StringBuffer sb=new StringBuffer(s);
    //     sb=sb.reverse();
    //     return s.equals(""+sb);
    // }
    
    public boolean isp(String s){
        StringBuilder reversed = new StringBuilder(s).reverse();
        return s.equals(reversed.toString());

    }

}