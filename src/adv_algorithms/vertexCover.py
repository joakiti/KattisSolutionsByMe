from collections import defaultdict

V = 5

graph = defaultdict(list)

while True:
    inp = ""
    try:
        inp = input()
        v, w = inp.split()
        v = int(v)
        w = int(w)
        graph[v].append(w)
        graph[w].append(v)
    except EOFError:
        break

matched = set()
matching = []
missingMatching = True
while missingMatching:
    for k in matched:
        graph.pop(k, None)
    missingMatching = False
    for dic in graph.keys():
        if dic not in matched:
            missingMatching = True
            for neighbor in graph[dic]:
                if neighbor not in matched:
                    matching.append((dic, neighbor))
                    matched.add(dic)
                    matched.add(neighbor)
                    break
            #If no matching is found, we hit false again
            missingMatching = False
print(matching)