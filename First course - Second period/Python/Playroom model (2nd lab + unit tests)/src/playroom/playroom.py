import operator


class Playroom:
    """Base class for playroom object"""
    __toys_number = 0
    __total_toys_price = 0
    __available_toys = []

    def __init__(self, capability=10):
        self.__capability = capability

    @property
    def get_capability(self):
        return self.__capability

    @property
    def get_available_toys(self):
        return self.__available_toys

    @property
    def get_total_toys_price(self):
        return self.__total_toys_price

    @property
    def get_toys_number(self):
        return self.__toys_number

    @get_capability.setter
    def set_capability(self, value):
        self.__capability = value

    def reset_values(self):
        self.__total_toys_price = 0
        self.__toys_number = 0
        self.__available_toys = []

    # show info about playroom object
    def __str__(self):
        return "Capacity: {0}\nNumber of toys: {1}\nTotal toys price: ${2}\n\n"\
            .format(self.__capability, self.__toys_number, self.__total_toys_price)

    # show all available toys from list
    def show_available_toys(self):
        result = ""
        for toy in self.__available_toys:
            result += toy.__str__() + "\n"
        return result

    # insert toy into toys list
    def push_toy(self, toy):
        self.__available_toys.append(toy)
        self.__toys_number += 1
        self.__total_toys_price += toy.get_price

    # sort by certain parameter all toys in playroom object
    def sort_toys_by_attr(self, attr_name):
        self.__available_toys.sort(key=operator.attrgetter('_' + attr_name))

    # search toy by certain param in playroom object
    def search_toys_by_type(self, value):
        result = ''
        matches = [toy for toy in self.__available_toys if toy.get_type.lower() == value.lower()]
        for obj in matches: result += obj.__str__() + '\n'
        return result
