import unittest
from src.playroom.toy import Toy


class ToyTest(unittest.TestCase):

    __cube = Toy(.5, .01, 'sample')

    def test_get_price(self):
        self.assertEqual(self.__cube.get_price, .5)

    def test_get_weight(self):
        self.assertEqual(self.__cube.get_weight, .01)

    def test_get_type(self):
        self.assertEqual(self.__cube.get_type, 'sample')


if __name__ == '__main__':
    unittest.main()
