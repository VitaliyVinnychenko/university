from src.playroom.toy import Toy


class Doll(Toy):
    """Base class for doll object"""
    def __init__(self, price, weight, type, sex="N/A", phrase="N/A", height=0, hair_color="N/A"):
        Toy.__init__(self, price, weight, type)
        self.__sex = sex
        self.__phrase = phrase
        self.__height = height
        self.__hair_color = hair_color

    @property
    def get_sex(self):
        return self.__sex

    @property
    def get_phrase(self):
        return self.__phrase

    @property
    def get_height(self):
        return self.__height

    @property
    def get_hair_color(self):
        return self.__hair_color

    @get_sex.setter
    def set_sex(self, value):
        self.__sex = value

    @get_phrase.setter
    def set_phrase(self, value):
        self.__phrase = value

    @get_height.setter
    def set_height(self, value):
        self.__height = value

    @get_hair_color.setter
    def set_hair_color(self, value):
        self.__hair_color = value

    # show info about doll object
    def __str__(self):
        return "Price: ${0}\nWeight: {1} kg\nType: \"{2}\"\n" \
               "Hair color: {3}\nSex: {4}\nHeight: {5} m\n"\
            .format(self._price, self._weight, self._type,
                    self.__hair_color, self.__sex, self.__height)