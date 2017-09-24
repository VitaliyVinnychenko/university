import sys


def get_input_array():
    args = sys.argv[1:]

    if len(args) == 2 and args[0] == '-input':
        return [int(i) for i in open(args[1], 'r').read().split(' ')]

    return None


def get_max_collection(array, zero_number):
    array_length = range(1, len(array))
    max_length = 0

    for i in array:
        counter = zero_number + 1
        quota = zero_number

        for j in array_length:
            difference = array[j] - array[j - 1]

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
        zero_number = array.count(0)
        unique_cards = sorted(set(array))

        if zero_number:
            unique_cards = unique_cards[1:]

        result = get_max_collection(unique_cards, zero_number)

        print(result)


if __name__ == '__main__':
    main()
