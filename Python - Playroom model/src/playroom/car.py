from src.playroom.toy import Toy


class Car(Toy):
    """Base class for car object"""
    def __init__(self, price, weight, type, width=0, length=0, color="N/A"):
        Toy.__init__(self, price, weight, type)
        self.__width = width
        self.__length = length
        self.__color = color

    @property
    def get_width(self):
        return self.__width

    @property
    def get_length(self):
        return self.__length

    @property
    def get_color(self):
        return self.__color

    @get_width.setter
    def set_width(self, value):
        self.__width = value

    @get_length.setter
    def set_length(self, value):
        self.__length = value

    @get_color.setter
    def set_color(self, value):
        self.__color = value

    #show info about car object
    def __str__(self):
        return "Price: ${0}\nWeight: {1} kg\nType: \"{2}\"\n" \
               "Color: {3}\nWidth: {4} m\nLength: {5} m\n"\
            .format(self._price, self._weight, self._type,
                    self.__color, self.__width, self.__length)
