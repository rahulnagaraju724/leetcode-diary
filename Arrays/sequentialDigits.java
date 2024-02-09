// class Solution {
//     public List<Integer> sequentialDigits(int low, int high) {
//         //1291. Sequential Digits
//         ArrayList<Integer> result=new ArrayList<>();
//         //int[] digits = new int[1, 2, 3, 4, 5, 6, 7, 8, 9];
//         String s="0123456789"; //length=10;

//         String lowStr = String.valueOf(low);
//         int k = lowStr.charAt(0) - '0';  // Convert character to digit, to get first digit

//         int lowLength = lowStr.length();
//         int highLength = String.valueOf(high).length();
    

//         int digitsLength=lowLength;

//         while(digitsLength<=highLength){
//             if(k+digitsLength<=10){
//                 int value=Integer.parseInt(s.substring(k,k+digitsLength));
//                 if(value<=high && value>=low){
//                     result.add(value);
//                     //System.out.println(value);
//                 }
//                 k++;
//             }
//             else{
//                 k=1;
//                 digitsLength++;

//             }
//         }
//         return result;
//     }
// }

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        //1291. Sequential Digits
        String digits = "123456789";
        List<Integer> res = new ArrayList<>();
        int nl = String.valueOf(low).length();
        int nh = String.valueOf(high).length();
        
        for(int i = nl; i <= nh; i++){
            for(int j = 0; j < 10 - i; j++){
                int num = Integer.parseInt(digits.substring(j, j + i));
                if(num >= low && num <= high) res.add(num);
            }
        }
        return res;
    }
}