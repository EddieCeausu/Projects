
# What is the 10 001st prime number?
q = 0

prime = 13
primes = []

while len(primes) < 10010:
    addprime = True
    i = 1
    while i <= prime:
        if prime % i == 0:
            addprime = False
            break
        i += 2
        print prime
    if addprime == True:
        primes.append(prime)
        print primes[q]
        q += 1
    prime += 2
print primes[10002]
