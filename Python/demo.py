def factorial(n):
    factorial_output=1
    for i in range(n,0,-1):
        print(i)
        factorial_output=factorial_output*i
    return factorial_output

def factorial_recursive(n):
    if (n==0):
        return 1
    return n* factorial_recursive(n-1)

def check_prime(num):
    for i in range(2,num): #6 ->[2,3,4,5]
        if(num % i ==0):
            return False
    
    return True
    
for i in range(2,50):
    if(check_prime(i)):
        print(i," is Prime")


for i in range(10): #i=0,
    for j in range(5):#j=0,1,2,3,4
        print("i",i,"j",j)


# output=factorial(7) 
# print("Result=",output)

# output2=factorial_recursive(7) 
# print("Result from recursive function=",output2)

