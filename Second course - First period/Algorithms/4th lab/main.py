def main():
    graph, begin, end = read_input_data()
    pathes = list(dfs_paths(graph, begin, end))

    print(graph)

    if not pathes:
        return

    shortest_path = [0] * 10001
    result_string = 'Path is '

    for path in pathes:
        if len(shortest_path) > len(path):
            shortest_path = path

    for node in shortest_path:
        result_string += f'{node} -> '

    print(result_string[:-4] + '!')


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

        try:
            for next_item in graph[vertex] - set(path):
                if next_item == end:
                    yield path + [next_item]
                else:
                    stack.append((next_item, path + [next_item]))
        except:
            print(f'No path found from {begin} to {end}')
            return -1


if __name__ == '__main__':
    main()
