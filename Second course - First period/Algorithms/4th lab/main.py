def main():
    graph, begin, end = read_input_data()
    pathes = list(dfs_paths(graph, begin, end))
    shortest_path = [0] * 10001

    for path in pathes:
        if len(shortest_path) > len(path):
            shortest_path = path

    print(shortest_path)



def read_input_data():
    with open('graph.in', 'r') as file:
        raw_data = file.readlines()
        edges = raw_data[1: -1]
        route = list(map(int, raw_data[-1].split()))
        graph = {}

        for key, value in enumerate(edges):
            edges[key] = list(map(int, value.split()))
            current_root_vertex, next_vertex = edges[key][0], edges[key][1]

            if current_root_vertex not in graph:
                graph[current_root_vertex] = {next_vertex}
            else:
                graph[current_root_vertex].add(next_vertex)

        return graph, route[0], route[1]


def dfs_paths(graph, begin, end):
    stack = [(begin, [begin])]
    while stack:
        (vertex, path) = stack.pop()
        for next_item in graph[vertex] - set(path):
            if next_item == end:
                yield path + [next_item]
            else:
                stack.append((next_item, path + [next_item]))


if __name__ == '__main__':
    main()
