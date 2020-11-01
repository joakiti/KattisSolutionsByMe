import itertools
import math
import sys
from collections import defaultdict

from dijkstar import Graph, find_path
import operator

v = 5

vertices = [i for i in range(0, v)]

graph = Graph()


def addEdge(frm, to, cost):
    graph.add_edge(frm, to, cost)
    graph.add_edge(to, frm, cost)


for v in vertices:
    for neighbor in range(v, len(vertices)):
        addEdge(v, neighbor, 1)

OPT = defaultdict(defaultdict)

for t in range(0, len(vertices)):
    OPT[t][tuple({t})] = find_path(graph, 0, t).total_cost


for t in range(1, len(vertices)):
    for size in range(1, len(vertices)):
        for S in itertools.combinations(vertices, size):
            minCost = sys.maxsize
            endRemoved = set(filter(lambda vtx: vtx != t, S))
            for x in endRemoved:
                minCost = min(minCost, OPT[x][tuple(endRemoved)] + find_path(graph, x, t).total_cost)
            OPT[t][tuple({S})] = minCost




