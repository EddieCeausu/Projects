from random import randint

def insertion(array):
    for i in xrange(1, len(array)):
        val = i
        j = i - 1
        while j >= 0 and array[j] > val:
            array[j+1] = array[j]
            j -= 1
        array[j+1] = val
    return array

def arraygen(n):
    array = []
    for i in range(n+1):
        j = randint(0, randint(0,n));
        array.append(j)
    return array

array = arraygen(randint(0,50))
print array,"\n" 
array = insertion(array)
print array
