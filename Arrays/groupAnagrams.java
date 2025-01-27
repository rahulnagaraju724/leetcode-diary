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
        //49. Group Anagrams
        HashMap<String, ArrayList<String>> map=new HashMap<>();

        for(String str: strs){

            char[] tempArray = str.toCharArray();
            Arrays.sort(tempArray);
            String tempStr=String.valueOf(tempArray);

            if(map.containsKey(tempStr)){
                map.get(tempStr).add(str);
            }
            else{
                ArrayList<String> angs = new ArrayList<>();
                angs.add(str);
                map.put(tempStr,angs);
            }
        }
        
        List<List<String>> anagrams=new ArrayList<>();

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            //System.out.println("key: "+key+", values = "+value.toString());
            anagrams.add(value);
        }
        
        return anagrams;
    }
}

// More optimized one
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
        // One line
        return new ArrayList<>(map.values());
    }
}


//Another approach
class Solution {
    public String getSignature(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            // What is compute if present here
            groups.computeIfAbsent(getSignature(s), k -> new ArrayList<>()).add(s);
        }

        result.addAll(groups.values());

        return result;
    }
}

