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

        if gap == 1:
            count += 1
        elif gap == 2:
            count += 2
            tmp -= 1
        elif tmp >= gap - 1 > 2 and tmp > 0:
            tmp -= gap - 1
            count += gap
        else:
            break

    count += tmp

    if result < count:
        result = count

print(result)
