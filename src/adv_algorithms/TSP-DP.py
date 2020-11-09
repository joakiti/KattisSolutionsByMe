import itertools
import sys
from collections import defaultdict
from sys import maxsize
from itertools import permutations
from haversine import haversine, Unit
from dijkstar import Graph, find_path
import operator

graph = Graph()


def addEdge(frm, to, cost):
    graph.add_edge(frm, to, cost)


cities = dict()
index = 0
while sys.stdin:
    try:
        i = input()
        name, lat, lon = i.split()
        cities[index] = (name, lat, lon)
        index += 1
    except:
        break

for city in cities.keys():
    name, lat, lon = cities[city]
    for other in cities.keys():
        if city != other:
            neig, lat2, lon2 = cities[other]
            weight = haversine((float(lat), float(lon)), (float(lat2), float(lon2)))
            graph.add_edge(city, other, weight)

start = 0
DP = defaultdict(defaultdict)
DP[tuple([start]), start] = 0
vertex = list(filter(lambda v: v != start, cities.keys()))

for size in range(1, len(cities.keys())):
    print(size)
    for S in itertools.combinations(vertex, size):
        for end in S:
            visited = tuple([start]) + tuple(S)
            if size < 2:
                DP[visited][end] = find_path(graph, start, end).total_cost
            else:
                removeEnd = tuple(filter(lambda v: v != end, visited))
                DP[visited][end] = min([DP[removeEnd][j] + find_path(graph, j, end).total_cost for j in S if j != end and j != 0])

minimal = sys.maxsize
for t in cities.keys():
    if t != 0:
        minimal = min(minimal, DP[tuple(cities.keys())][t] + find_path(graph, t, start).total_cost)

print(minimal)