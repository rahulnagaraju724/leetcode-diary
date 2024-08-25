class Solution {
    public static String intToRoman(int num) {
        //12. Integer to Roman

        // First divide by largest, then assign roman
        // Then check if remaining remainder in between largest and second largest
        // If not, get below
        // If yes, check if it is in mid between
        char[] symbol=new char[]{'I','V','X','L','C','D','M'};
        int[] value=new int[]{1,5,10,50,100,500,1000};
        int i=6;

        StringBuilder str=new StringBuilder("");

        while(num>0 && i>=0){
            int digit=num/value[i];
            if(digit==0){// First check if it is divisible by largest numeral
                i=i-1;
            }else{
                if(digit==1 && num!=1){ //num!=1
                    int temp=value[i]+4*value[i-1];
                    if(num<temp){
                        //continue assigning roman numeral
                        str.append(symbol[i]);
                        num=num%value[i];
                        i=i-1;
                    }else{
                        // will have to assign ulta
                        str.append(symbol[i-1]);
                        str.append(symbol[i+1]);
                        num=num-temp;
                        i=i-1;
                    }
                }
                else if(digit==1 && num==1){
                    str.append(symbol[i]);
                    num=num-1;
                }
                else{
                    if(digit<=3){
                        for(int k=0;k<digit;k++){
                            str.append(symbol[i]);
                        }
                        num=num%value[i];
                    }else{
                        str.append(symbol[i]);
                        str.append(symbol[i+1]);
                        num=num%value[i];
                    }

                }

            }
        }


        System.out.println(str.toString());
        return str.toString();
    }
}

// Better approach  
class Solution {
    public static String intToRoman(int num) {
        //12. Integer to Roman
    String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}

// Most Optimal Apporach
class Solution {
    public String intToRoman(int num) {
        //12. Integer to Roman
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();

    }
}
