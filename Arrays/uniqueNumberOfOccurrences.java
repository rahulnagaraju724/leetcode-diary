class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //1207. Unique Number of Occurrences
        Arrays.sort(arr);

        int prev=arr[0];
        int counter=1;

        HashSet<Integer> countSet=new HashSet<>();

        for(int i=1;i<arr.length;i++){
            if(arr[i]==prev){
                counter++;
            }else{
                if(countSet.contains(counter)){
                    return false;
                }
                else{
                    countSet.add(counter);
                    counter=1;
                    prev=arr[i];
                }

            }

        }

        if(countSet.contains(counter)){
            return false;
        }

        return true;
    }
}

// Optmial approach

// public boolean uniqueOccurrences(int[] arr) {
//     //1207. Unique Number of Occurrences
//     Map<Integer, Integer> countMap = new HashMap<>();
//     Set<Integer> occurrenceSet = new HashSet<>();

//     for (int num : arr) {
//         countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//     }

//     return occurrenceSet.addAll(countMap.values());
// }
