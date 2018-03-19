while(True):
    s = input("Enter Your sring to swap between \" ")

    t = list(s)
    t[15:19], t[22:26] = t[22:26], t[15:19]

    print(''.join(t))
