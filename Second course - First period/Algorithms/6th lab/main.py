def main():
    with open('govern.in', 'r') as i_file:
        data = i_file.read()
        input_nodes = dict((i, 0) for i in list(data.split()))
        dependencies = dict((i, set()) for i in list(data.split()))

        for item in data.split('\n'):
            item = item.split()

            dependencies[item[0]].add(item[1])
            input_nodes[item[0]] += 1

    input_nodes = dict(sorted(input_nodes.items(), key=lambda x: x[1]))
    result = input_nodes

    for i in result:
        for d in dependencies[i]:
            result[i] += result[d]

        print(i)


if __name__ == '__main__':
    main()
