// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        
        int a[]={1,2,3,4,5};
        int multiplier=1;
        int finalNumber=0;
        for(int i=a.length-1;i>=0;i--){
            int number=multiplier*a[i];
            System.out.println("Digit at place i="+i+" is "+number);
            finalNumber+=number;
            multiplier*=10;
        }
        System.out.println("Final Number is ="+finalNumber);
    }
}