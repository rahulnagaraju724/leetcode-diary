// Most Optimal Solution
class Solution {
    public String toLowerCase(String str) {
        //709. To Lower Case
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a'); // Fav line of code
        return new String(a);
    }
}

// Good solution
class Solution {
    public String toLowerCase(String s) {
        //709. To Lower Case
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ans.append(c > 64 && c < 91 ? (char)(c + 32) : c);
        }
        return new String(ans);
    }
}