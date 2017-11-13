from functools import reduce
import math
from random import randint

def main():
    while(True):
        response = str(input("Would you like a random(r) or custom(c) array? "))
        if response.lower() == "r":
            array = rarray()
            print(array)
            break
        if response.lower() == "c":
            array = carray()
            print(array)
            break
        else:
            print("Try again")

    var = variance(array)
    print("Variance = ", var)
    sdv = math.sqrt(var)
    print("Standard Deviation = ", sdv)

def carray():
    while(True):
        size = int(input("How large is your data set? "))
        if size <= 1:
            "Try Again"
        else:
            break
    array = []
    array.append(int(input("Enter your list followed by [ENTER]\n")))
    for i in range(size-1):
        array.append(int(input("")))
    return array

def rarray():
    while(True):
        size = int(input("How large is your data set? "))
        if size <= 1:
            print("Try Again")
        else:
            break
    while(True):
        ulimit = int(input("What is your upper bound? "))
        if ulimit <= 1:
            print("Try Again")
        else:
            break
    array = []
    for i in range(size-1):
        array.append(randint(0,ulimit))
    return array

def variance(array):
    mean = sum(array) / 2
    summ = 0
    for i in array:
        summ += (i - mean) ** 2
    summ /= len(array) - 1
    return math.sqrt(summ)


if __name__ == '__main__':
    main()
