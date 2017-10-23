## © Jakob Ligget ##

def primesVanilla(n):
    r = [True] * n ##Array of true prime bools length of N
    r[0] = r[1] = False ##Starting Values, 0 and 1 not prime
    for i in range(n): ## For all numbers (generator)
        if r[i]: ## If marked as prime
            for j in range(i+i,n,i): ## Goto every number from double the current to the end, in increments of the current prime
                r[j]=False ## Mark composite as false
    return r

def primesVanillaConvert(r):
	primenum = []
	for x in range(len(r)-1):
		if r[x]:
			primenum.append(x)
	return primenum

checkto = int(input('Check primes under x: '))

primes = primesVanilla(checkto)
#trueprimes = ( primesVanillaConvert(primes) )
print ('Done!')
