class Solution {
    public String reverseWords(String s) {
        //151.Reverse Words in a String
        int left=s.length()-1;
        int right=left+1;
        if(right==0){ // length==0
            return "";
        }
        StringBuilder str=new StringBuilder();
        while(left>=0){
            if(s.charAt(left)==' '){
                // System.out.println(left+", "+right);
                if(left+1==right){
                    right--;
                    left--;
                    continue;
                }
                str.append(s.substring(left+1,right));
                str.append(" ");
                right=left;                
            }
            left--;
        }
        if(right>left){ // still first word not added
            str.append(s.substring(left+1,right));
        }
        
        if(str.charAt(str.length()-1)==' '){ // remove extra space which is added in while loop
            str.setLength(Math.max(str.length() - 1, 0));
        }

        return str.toString();

    }
}

//Wow
public class Solution {
  
    public String reverseWords(String s) {
      if (s == null) return null;
      
      char[] a = s.toCharArray();
      int n = a.length;
      
      // step 1. reverse the whole string
      reverse(a, 0, n - 1);
      // step 2. reverse each word
      reverseWords(a, n);
      // step 3. clean up spaces
      return cleanSpaces(a, n);
    }
    
    void reverseWords(char[] a, int n) {
      int i = 0, j = 0;
        
      while (i < n) {
        while (i < j || i < n && a[i] == ' ') i++; // skip spaces
        while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
        reverse(a, i, j - 1);                      // reverse the word
      }
    }
    
    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
      int i = 0, j = 0;
        
      while (j < n) {
        while (j < n && a[j] == ' ') j++;             // skip spaces
        while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
        while (j < n && a[j] == ' ') j++;             // skip spaces
        if (j < n) a[i++] = ' ';                      // keep only one space
      }
    
      return new String(a).substring(0, i);
    }
    
    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
      while (i < j) {
        char t = a[i];
        a[i++] = a[j];
        a[j--] = t;
      }
    }
    


}


class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<String>();
        for (String a : s.trim().split(" ")) {
            if (!a.isEmpty())
                st.push(a);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
            sb.append(" ");            
        }
        
        return sb.toString().trim();
    }
}


class Solution {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] str = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = str.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += str[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + str[0];
    }
}