import sys
import time


quicksort_exchanges = 0
quicksort_compares = 0


def get_input_array():
    args = sys.argv[1:]

    if len(args) == 2 and args[0] == '-input':
        return [int(i) for i in open(args[1], 'r').read().split(' ')[:-1]]


def insertion_sort(input_array):
    start_time = time.time()
    compares = exchanges = i = 0

    while i < len(input_array): # for
        j = i
        compares += 1

        while j > 0 and input_array[j - 1] >= input_array[j]:
            input_array[j], input_array[j - 1] = input_array[j - 1], input_array[j]
            compares += 1
            exchanges += 1
            j -= 1

        i += 1

    work_time = round((time.time() - start_time) * 1000, 2) # timeit
    info = (work_time, compares, exchanges)

    return input_array, info


def quicksort(input_array, left, right):
    global quicksort_compares, quicksort_exchanges

    i = left
    j = right
    pivot = input_array[round((left + right) / 2)]

    while left < j or i < right:
        quicksort_compares += 1

        while input_array[i] < pivot:
            quicksort_compares += 1
            i = i + 1

        while input_array[j] > pivot:
            quicksort_compares += 1
            j = j - 1

        quicksort_compares += 1

        if i <= j:
            quicksort_exchanges += 1
            input_array[i], input_array[j] = input_array[j], input_array[i]

            i += 1
            j -= 1

        else:
            quicksort_compares += 2

            if left < j:
                quicksort(input_array, left, j)

            if i < right:
                quicksort(input_array, i, right)

            return


def main():
    array = get_input_array()

    if array is None:
        print('Enter: python3 main.py -input <input file>')
    else:
        insertion_sorted_array, insertion_info = insertion_sort(array)

        quicksort_start_time = time.time()
        quicksort(array, 0, len(array) - 1)

        qs_info = (round((time.time() - quicksort_start_time) * 1000, 3), quicksort_compares, quicksort_exchanges)

        print('------------------------------------------------------------------------------')
        print('| Insertion: {} - time (ms), {} - compares, {} - exchanges'.format(*insertion_info))
        print('| Quicksort: {} - time (ms), {} - compares, {} - exchanges'.format(*qs_info))
        print('------------------------------------------------------------------------------')


if __name__ == '__main__':
    main()
