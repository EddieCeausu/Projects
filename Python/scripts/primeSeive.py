from __future__ import absolute_import
from __future__ import division
import math, time

'''
This sieve has been optimized, check for a more simple standard implementation somewhere else
'''
def sieve(n):
    startgrid = [True]*n
    startgrid[0], startgrid[1] = False, False
    for even in xrange(4, n, 2):
        startgrid[even] = False
    for num in xrange(3, int(math.sqrt(n)+1), 2):
        if startgrid[num]:
            for composite in xrange(num*num, n, num*2):
                startgrid[composite] = False
    lst = ( [x for x in range(1, len(startgrid), 2) if startgrid[x]] )
    lst.insert(0, 2)
    return lst

def split(n):
    if n < sys.maxint:
        print sieve(n)
    else:
        if n % 15 ==  and < sys.maxint:
            j = n % 15
            for i in xrange(j):


### This currently takes 31.41s
times = time.time()
split(513821217024129243948411056803)
print('Done, took {}s'.format(time.time()-times))
