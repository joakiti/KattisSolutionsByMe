from collections import defaultdict

from pulp import LpMinimize, LpProblem, LpStatus, lpSum, LpVariable

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
            # If no matching is found, we hit false again
            missingMatching = False
print(len(matched))
# Create the model
model = LpProblem(name="small-problem", sense=LpMinimize)

# Initialize the decision variables
variables = [LpVariable(name=f"{i}", lowBound=0, upBound=1) for i in sorted(graph.keys())]
for x in range(0, len(variables)):
    for edge in graph[x]:
        model += (variables[x-1] + variables[edge - 1] >= 1)

# Add the objective function to the model
model += lpSum(variables)
status = model.solve()
print(f"status: {model.status}, {LpStatus[model.status]}")
print(f"objective: {model.objective.value()}")

# Solve the problem
status = model.solve()

for var in model.variables():
    if var.value() >= 0.5:
        var.value = lambda: 1
    else:
        var.value = lambda: 0
    print(f"{var.name}: {var.value()}")
print(f"objective: {model.objective.value()}")
