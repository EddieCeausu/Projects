from random import randint

def heapsort(array):
    heapify(array, len(array))
    end = len(array) - 1
    while end > 0:
        array[end], array[0] = array[end], array[0]
        end -= 1
        shiftdown(array, 0, len(array)-1)
    return array

def heapify(array, count):
    start = (count - 2) / 2
    while start >= 0:
        shiftdown(array, start, count - 1)
        start -= 1

def shiftdown(array, start, end):
    base = start
    while base * 2 + 1 <= end:
        child = base  * 2 + 1
        if child + 1 <= end and array[child] < array[child + 1]:
            child += 1
        if array[base] < array[child]:
            array[base], array[child] = array[child], array[base]
            base = child
        else:
            break

def swap(a,b):
    return b,a


def arraygen(n):
    array = []
    for i in range(n+1):
        j = randint(0, randint(0,n));
        array.append(j)
    return array

array = arraygen(randint(0,50))
print array,"\n"
array = heapsort(array)
print array
