class Solution {
    public boolean halvesAreAlike(String s) {
        //1704. Determine if String Halves Are Alike
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int countA=0;
        int countB=0;
        int n=s.length();
        for(int i=0;i<n/2;i++){
            if(vowels.contains((s.charAt(i)))){
                countA++;
            }
            if(vowels.contains((s.charAt(n-1-i)))){
                countB++;
            }
            // if(s.charAt(i)=='a' ||s.charAt(i)=='e' ||s.charAt(i)=='i' ||s.charAt(i)=='o' ||s.charAt(i)=='u'
            // ||s.charAt(i)=='A'||s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U'){
            //     countA++;
            // }
            // if(s.charAt(n-1-i)=='a' ||s.charAt(n-1-i)=='e' ||s.charAt(n-1-i)=='i' ||s.charAt(n-1-i)=='o' ||s.charAt(n-1-i)=='u'
            // ||s.charAt(n-1-i)=='A'||s.charAt(n-1-i)=='E' || s.charAt(n-1-i)=='I' || s.charAt(n-1-i)=='O' || s.charAt(n-1-i)=='U'){
            //     countB++;
            // }
        
        }
        return countA==countB;
    }
}