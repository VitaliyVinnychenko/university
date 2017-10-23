
def main():
    array = sorted(map(int, open('lngpok.in', 'r').read().split()))
    zeroes_number = 0

    for i in array:
        if i != 0:
            break

        zeroes_number += 1

    array = sorted(list(set(array)))

    if zeroes_number != 0:
        array = array[1:]

    array_size = len(array)
    result = 0

    for i in range(array_size):
        tmp = zeroes_number
        count = 1

        for j in range(i + 1, array_size):
            gap = array[j] - array[j - 1]
            case = 0

            if gap == 1:
                count += 1
            elif gap == 2 and tmp > 0:
                count += 2
                case = 1
                tmp -= 1
            elif tmp >= gap - 1 > 2 and tmp > 0:
                tmp -= gap - 1
                count += gap
                case = 2
            else:
                break

            print(f'Prev - {array[j - 1]}, current - {array[j]}, case - {case}, count - {count}, gap - {gap}, tmp - {tmp}')

        count += tmp
        print()

        if result < count:
            result = count

    print(result)


if __name__ == '__main__':
    main()

# 1 3 5 9 10 11 12 0 0 0
