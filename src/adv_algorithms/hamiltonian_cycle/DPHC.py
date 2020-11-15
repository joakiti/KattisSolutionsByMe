import itertools
import sys
from collections import defaultdict
import networkx as nx
from haversine import haversine

G = nx.Graph()

while sys.stdin:
    try:
        i = input()
        u, v = i.split()
        G.add_edge(u, v)
    except:
        break

DP = defaultdict(tuple)

start = list(G.nodes)[0]
DP[tuple([start]), start] = start
withoutStart = list(filter(lambda x: x != start, G.nodes))

for size in range(1, len(G.nodes) + 1):
    for S in itertools.combinations(withoutStart, size):
        for end in S:
            visited = tuple([start]) + tuple(S)
            if size < 2 and end in G.adj[start]:
                DP[visited, end] = start
            if size >= 2:
                removeEnd = tuple(filter(lambda v: v != end, visited))
                for u in removeEnd:
                    if DP.get((removeEnd, u), False) and u in G.adj[end]:
                        DP[visited, end] = u
path = []


def findPath(nodes, to):
    if len(nodes) > 1:
        path.append(DP[tuple(nodes), to])
        findPath(list(filter(lambda x: x != to, nodes)), DP[tuple(nodes), to])


for n in G.nodes:
    if DP.get((tuple(G.nodes), n), False) and start in G.adj[n]:
        path.append(start)
        path.append(n)
        findPath(G.nodes, n)
        print(path)
        exit(0)

print("No cycle!")
