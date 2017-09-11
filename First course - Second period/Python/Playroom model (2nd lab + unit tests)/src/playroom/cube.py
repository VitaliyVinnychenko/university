from src.playroom.toy import Toy


class Cube(Toy):
    """Base class for cube object"""
    __volume = 0

    def __init__(self, price, weight, type, color, edge_length=0):
        Toy.__init__(self, price, weight, type)
        self.__color = color
        self.__edge_length = edge_length

    @property
    def get_color(self):
        return self.__color

    @property
    def get_edge_length(self):
        return self.__edge_length

    @property
    def get_volume(self):
        return self.__volume

    @get_color.setter
    def set_color(self, value):
        self.__color = value

    @get_edge_length.setter
    def set_edge_length(self, value):
        self.__edge_length = value

    # calculate cube object volume
    def calculate_toy_volume(self):
        self.__volume = pow(self.__edge_length, 3)

    # show info about cube object
    def __str__(self):
        return "Price: ${0}\nWeight: {1} kg\nType: \"{2}\"\n" \
               "Color: {3}\nEdge length: {4} m\nVolume: {5} c.m.\n"\
            .format(self._price, self._weight, self._type,
                    self.__color, self.__edge_length, self.__volume)