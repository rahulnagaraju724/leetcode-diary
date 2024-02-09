// Better approach
class Solution {
    public int romanToInt(String s) {
        //13. Roman to Integer
        HashMap<Character, Integer> hashMap=new HashMap<>(Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000));
        int value=0;
        //int nextValue;
        for(int i=0;i<s.length();i++){
            int tempValue= hashMap.get(s.charAt(i));
            if((i+1<s.length()) && tempValue<hashMap.get(s.charAt(i+1))){
                //value+=hashMap.get(s.charAt(i+1));
                value-=tempValue;
                //i++;
            }else{
                value+=tempValue;
            }
        }
        return value;
    }
}

// Not that great
class Solution {
    public int romanToInt(String s) {
        //13. Roman to Integer
        if(s.length()==0){
            return 0;
        }

        HashMap<Character, Integer> hashMap=new HashMap<>(Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000));

        int value=0;

        //int currValue=0;
        int prevValue=hashMap.get(s.charAt(0));
        value+=prevValue;

        for(int i=1;i<s.length();i++){
            int currValue=hashMap.get(s.charAt(i));
            if(currValue>prevValue){
                value-=prevValue;
                value+=currValue-prevValue;
               
                //i++;
            }else{
                value+=currValue;
            }
            prevValue=currValue;
        }
        return value;
    }
}
