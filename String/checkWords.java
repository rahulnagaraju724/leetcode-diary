class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Check if words present
        int counter=0;
        for(int i=0;i<wordDict.size();i++){
            int k=0;
            boolean found=false;
            for(int j=0;j<s.length() && !found;j++){
                if( k< wordDict.get(i).length() && wordDict.get(i).charAt(k)==s.charAt(j)){
                    k++;
                }
                else if(k==wordDict.get(i).length()){
                    found=true;
                    counter+=1;
                }
            }

        }

        return (counter>0)? true:false;   
    }
}