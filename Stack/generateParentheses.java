class Solution {
    public List<String> generateParenthesis(int n) {
        //22. Generate Parentheses
        List<String> resultList=new ArrayList<>();
        Stack<String> stack=new Stack<>();
        backtrackParenthesis(n,0,0,resultList,stack);

        return resultList;
        
    }

    public void backtrackParenthesis(int n, int open, int closed,List<String> resultList, Stack<String> stack){
        if(open == n && closed == n){
            StringBuilder concatenatedString = new StringBuilder();
            for (String str : stack) {
                concatenatedString.append(str);
            }

            String result = concatenatedString.toString();
            resultList.add(result);
            return;
        }

        if(open<n){
            stack.push("(");
            backtrackParenthesis(n,open+1,closed,resultList,stack);
            stack.pop();
        }
        if(closed<open){
            stack.push(")");
            backtrackParenthesis(n,open,closed+1,resultList,stack);
            stack.pop();
        }



    }
}


(0, 0, '')
|	
(1, 0, '(')  
/           \
(2, 0, '((')      (1, 1, '()')
/                 \
(2, 1, '(()')           (2, 1, '()(')
/                       \
(2, 2, '(())')                (2, 2, '()()')
|	                             |
res.append('(())')             res.append('()()')


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return res;
    }
    
    public void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        
        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }
        
        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }
	// See above tree diagram with parameters (left, right, s) for better understanding
}


public List<String> generateParenthesis(int n) {
	List<String> result = new ArrayList<String>();
	if (n == 0) {
		result.add("");
	} else {
		for (int i = n - 1; i >= 0; i--) {
			List<String> insertSub = generateParenthesis(i);
			List<String> tailSub = generateParenthesis(n - 1 - i);
			for (String insert : insertSub) {
				for (String tail : tailSub) {
					result.add("(" + insert + ")" + tail);
				}
			}

		}
	}
	return result;
}