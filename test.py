import math
def asdf():
    done = False
    j = 0
    while done == False:
        j += 1
        print j
        if j >= 2 ** 32 - 1:
            j = j - j
            while done == False:
                j = -2 ** 32
                j -= 1
                if j == 2 ** 64:
                    break
        break

response = int(input('Would you like to start??'))
if response == 1:
    asdf()
