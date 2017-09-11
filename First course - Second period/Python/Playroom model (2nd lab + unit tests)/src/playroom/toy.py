class Toy:
    """Base class for toy object"""
    def __init__(self, price=0, weight=0.1, type="N/A"):
        self._price = price
        self._weight = weight
        self._type = type

    @property
    def get_price(self):
        return self._price

    @property
    def get_weight(self):
        return self._weight

    @property
    def get_type(self):
        return self._type

    @get_price.setter
    def set_price(self, value):
        self._price = value

    @get_weight.setter
    def set_weight(self, value):
        self._weight = value

    @get_type.setter
    def set_type(self, value):
        self._type = value
