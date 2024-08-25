class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //139. Word Break

        List<Boolean> list=new ArrayList<>(Arrays.asList(new Boolean[s.length()+1]));
        Collections.fill(list, Boolean.FALSE);
        list.set(list.size()-1,Boolean.TRUE);
        //System.out.println(list);

        for(int i=s.length()-1;i>=0;i--){
            for(int j=0;j<wordDict.size();j++){
                if(i+wordDict.get(j).length() <= s.length()  &&  s.substring(i, i + wordDict.get(j).length()).equals(wordDict.get(j))){
                   list.set(i, list.get(i+wordDict.get(j).length()));
                }
                
                if(list.get(i)){
                    break;
                }
            }
        }

        //System.out.println(list);
        return list.get(0);
    }
}