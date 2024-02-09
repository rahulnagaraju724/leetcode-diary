// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         int[][] frequencyArrays=new int[strs.length][26];
//         List<List<String>> results=new ArrayList<>();
//         for(int i=0;i<strs.length;i++){
//             for (int j = 0; j < strs[i].length(); j++) {
//                 char ch = strs[i].charAt(j);
//                 frequencyArrays[i][ch - 'a']++;
//             }
//         }

//         int[] visited=new int[frequencyArrays.length];

//         for(int i=0;i<frequencyArrays.length;i++){
//             if(visited[i]==1){
//                 continue;
//             }
//             List<String> result=new ArrayList<>();
//             result.add(strs[i]);
//             visited[i]=1;
//             for(int j=0;j<frequencyArrays.length;j++){
//                 if(visited[j]==1){
//                     continue;
//                 }
//                 //visited[i]=1;
//                 //System.out.println("Here baby");
//                 boolean pair=true;
//                 for(int k=0;k<26;k++){
//                     if(frequencyArrays[i][k]!=frequencyArrays[j][k]){
//                         pair=false;
//                         break;
//                     }
//                 }

//                 if(pair){
//                     //add to arraylist
//                     result.add(strs[j]);
//                     visited[j]=1;
//                 }
//             }

//             results.add(result);
//         }

//         return results;
//     }
// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}