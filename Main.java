import java.util.Scanner;

class Main {
    public static String intToRoman(int num) {
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

    public static void main(String[] args) {
       
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.print("Enter a number (enter 0 to exit): ");
            int num = scanner.nextInt();

            if (num == 0) {
                System.out.println("Exiting the program.");
                break;
            }

            String result = intToRoman(num);
            System.out.println("Roman numeral for " + num + ": " + result);
        }
        
    }
}


