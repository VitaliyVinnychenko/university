from src.playroom.toy import Toy
import math


class Ball(Toy):
    """Base class for ball object"""
    __volume = 0

    def __init__(self, price, weight, type, color="N\A", radius=0):
        Toy.__init__(self, price, weight, type)
        self.__color = color
        self.__radius = radius

    @property
    def get_color(self):
        return self.__color

    @property
    def get_radius(self):
        return self.__radius

    @property
    def get_volume(self):
        return self.__volume

    @get_color.setter
    def set_color(self, value):
        self.__color = value

    @get_radius.setter
    def set_radius(self, value):
        self.__radius = value

    # calculate ball object volume
    def calculate_toy_volume(self):
        self.__volume = 4 / 3 * math.pi * pow(self.__radius, 3)

    # show info about ball object
    def __str__(self):
        return "Price: ${0}\nWeight: {1} kg\nType: \"{2}\"\n" \
               "Color: {3}\nRadius: {4} m\nVolume: {5} c.m.\n"\
            .format(self._price, self._weight, self._type,
                    self.__color, self.__radius, self.__volume)

