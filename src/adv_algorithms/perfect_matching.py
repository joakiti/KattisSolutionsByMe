import itertools
import math
import operator

n, m = 10, 2
v = n * m

# First thing is to represent a graph in grid form
# I'm just going to create a list of vertices, and name them as coordinates in the grid
# Starting by 0,0 at top-left
vertices = [(i, j) for i in range(n) for j in range(m)]

# Now a list of edges for every adjacent vertex (undirected)
edges = []
for i in range(n):
    for j in range(m):
        for direction in {(1, 0), (0, -1)}:
            vertex = tuple(map(operator.add, vertices[i * m + j], direction))
            if 0 <= vertex[0] < n and 0 <= vertex[1] < m:  # Tjek at vi ikke går uden for boksen/grid
                edges.append({vertices[i * m + j], vertex})
# For all possible subsets of vertices:
# Remove i vertices and count the total number of edges
cum_sum = 0
for i in range(1, len(vertices) + 1):
    print(i)
    # Vertices er 0 indekseret, men i er i dette tilfælde et udtryk for antallet
    # af vertices vi inkludere, derfor offset med 1.
    for I in itertools.combinations(vertices, i):
        # Is there any element _i in e for all elements in I
        ls = list(filter(lambda e: any([_i in e for _i in I]), edges))
        cum_sum += pow(-1, len(I)) * math.comb(len(ls), v // 2)  # antal kombineringer af |E_G-I| ud af n/2
print("Inclusion exclusion found: " + str(cum_sum))


def kasteleynsFormula():
    product = 1
    for j in range(1, n+1):
        for k in range(1, m+1):
            product *= math.pow((4 * math.pow(math.cos((math.pi * j) / (n + 1)), 2) +
                                 4 * math.pow(math.cos((math.pi * k) / (m + 1)), 2)), 1.0 / 4.)
    return product


print("Statistical physics says: " + str(kasteleynsFormula()))
