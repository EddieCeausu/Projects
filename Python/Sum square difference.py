# -*- coding: utf-8 -*-

import numpy

squares = []
naturalsq = []
for i in range(1,101):
    a = i ** 2
    squares.append(a)

for i in range(1,101):
    naturalsq.append(i)
a = sum(naturalsq) ** 2
i = sum(squares)
print str(i)
print a
print str(a - i)
