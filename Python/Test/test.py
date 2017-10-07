# Python program to display the Fibonacci sequence up to n-th term using recursive functions

def recur_fibo(n):
   """Recursive function to
   print Fibonacci sequence"""
   if n <= 1:
       return n
   else:
       return(recur_fibo(n-1) + recur_fibo(n-2))

# Change this value for a different result
nterms = 4000000

# uncomment to take input from the user
#nterms = int(input("How many terms? "))
fib = []
# check if the number of terms is valid
if nterms <= 0:
   print("Plese enter a positive integer")
else:
    print("Fibonacci sequence:")
    i = 0
    x = 0
    while x < :
        i += 1
        print(recur_fibo(i))
        if recur_fibo(i) % 2 == 0:
            x = recur_fibo(i)
            fib.append(x)
sum(fib)
