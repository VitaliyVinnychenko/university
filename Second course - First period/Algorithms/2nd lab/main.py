import sys


def get_input_array():
    args = sys.argv[1:]

    if len(args) == 2 and args[0] == '-input':
        return [int(i) for i in open(args[1], 'r').read().split(' ')]

    return None


def quicksort(input_array, left, right):

    i = left
    j = right
    pivot = input_array[round((left + right) / 2)]

    while left < j or i < right:
        while input_array[i] < pivot:
            i = i + 1

        while input_array[j] > pivot:
            j = j - 1

        if i <= j:
            input_array[i], input_array[j] = input_array[j], input_array[i]
            i = i + 1
            j = j - 1

        else:
            if left < j:
                quicksort(input_array, left, j)

            if i < right:
                quicksort(input_array, i, right)

            return


def filter_array(array):
    zero_number = 0
    unique_cards = []
    flag = True

    for i in range(0, len(array) - 1):

        if array[i] == 0:
            zero_number = zero_number + 1
        else:
            if flag:
                unique_cards.append(array[i])
                flag = False

            if not array[i] == array[i + 1]:
                unique_cards.append(array[i + 1])

    return unique_cards, zero_number


def get_max_collection(array):

    unique_cards, zero_number = filter_array(array)
    unique_cards_number = range(1, len(unique_cards))
    max_length = 0

    for i in unique_cards:
        counter = zero_number + 1
        quota = zero_number

        for j in unique_cards_number:
            difference = unique_cards[j] - unique_cards[j - 1]

            if difference == 1:
                counter = counter + 1
            elif difference == 2 and quota > 0:
                counter = counter + 1
                quota = quota - 1
            else:
                break

        if counter > max_length:
            max_length = counter

    return max_length


def main():
    array = get_input_array()

    if array is None:
        print('Enter: python3 main.py -input <input file>')
    else:
        quicksort(array, 0, len(array) - 1)
        result = get_max_collection(array)

        print(result)


if __name__ == '__main__':
    main()
