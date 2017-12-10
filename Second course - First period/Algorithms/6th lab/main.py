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


def main():
    with open('govern.in', 'r') as i_file:
        data = i_file.read()
        input_nodes = dict((i, 0) for i in list(data.split()))
        dependencies = dict((i, set()) for i in list(data.split()))

        for item in data.split('\n'):
            item = item.split()

            dependencies[item[1]].add(item[0])
            input_nodes[item[0]] += 1

    input_nodes = dict(sorted(input_nodes.items(), key=lambda x: x[1]))
    vertices = list(input_nodes.keys())
    result = { vertices[0]: 0 }

    for i in vertices[1:]:
        pathes = list(dfs_paths(dependencies, vertices[0], i))
        longest_path = []

        for path in pathes:
            if len(longest_path) < len(path):
                longest_path = path

        result[i] = len(longest_path)

    for i in sorted(result.items(), key=lambda x: x[1]):
        print(i[0])


if __name__ == '__main__':
    main()
