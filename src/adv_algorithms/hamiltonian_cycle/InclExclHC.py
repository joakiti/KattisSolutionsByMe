import itertools
import sys

import numpy
import scipy
import numpy as np
from numpy.linalg import matrix_power

from scipy.linalg import expm, sinm, cosm

n = int(input())

matrix = np.array([
    [0 for _ in range(1, n + 1)] for _ in range(1, n + 1)
])
vertices = [i for i in range(1, len(matrix) + 1)]
while sys.stdin:
    try:
        i = input()
        u, v = map(int, i.split())
        matrix[u - 1][v - 1] = 1
        matrix[v - 1][u - 1] = 1
    except:
        break
cycleCount = 0

for i in range(0, n + 1):
    for I in itertools.combinations(vertices, i):
        GMinusS = numpy.copy(matrix)
        # Remove all vertices from I, first remove the v'th row
        for v in I:
            GMinusS[v - 1] = np.array([0 for _ in range(1, n + 1)])
            # and then remove the column
            for n in vertices:
                GMinusS[n - 1][v - 1] = 0
        GMinusS = matrix_power(GMinusS, n)
        numberWalks = sum([GMinusS[i][i] for i in range(0, n)])
        cycleCount += pow(-1, len(I)) * numberWalks

print(cycleCount)