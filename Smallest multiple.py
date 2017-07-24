print "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder."
print "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?"

done = False
num = 138192318
sto = 0
while not done:
    for i in range(1,20):
        if num % i == 0:
            sto += 1
            print sto
        if num % i != 0:
            num += 1
            sto = 0
            break
    print num
    if sto == 19:
        done = True
        print(num)
