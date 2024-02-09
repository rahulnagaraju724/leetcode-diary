class Solution {
    public int[] plusOne(int[] digits) {
        //66. Plus One
        List<Integer> resultList=new ArrayList<>();
        int carry=0;

        int sum=digits[digits.length-1]+1;
        
            if(sum>=10){ //only one possibility of higher value 10
                carry=1;
                //digits[digits.length-1]=0;
                resultList.add(0,0);
            }
            else{
                //digits[digits.length-1]=sum;
                for (int digit : digits) {
                    resultList.add(digit);
                }
                resultList.set(resultList.size()-1,sum);
                int[] intArray = resultList.stream().mapToInt(Integer::intValue).toArray();
                return intArray;
            }

        
        int i=digits.length-2;

        for(;i>=0 ;i--){

            sum= carry + digits[i];

            if(sum>=10){ //only one possibility of higher value 10
                carry=1;
                //digits[i]=0; //bcz only one possibility of 10, carry can't be greater than 1'
                resultList.add(0,0);
            }
            else{
                //digits[i]=sum;
                resultList.add(0,sum);
                carry=0;
            }
        }
        if(carry==1){
            resultList.add(0,carry);
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}

// class Solution {
//     public int[] plusOne(int[] digits) {
//         for (int i = digits.length - 1; i >= 0; i--) {
// 	if (digits[i] < 9) {
// 		digits[i]++;
// 		return digits;
// 	}
// 	digits[i] = 0;
// }

// digits = new int[digits.length + 1];
// digits[0] = 1;
// return digits;
//     }
// }